package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition3I
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3I
import net.voxelpi.voxlib.math.vector.Vector3I
import net.voxelpi.voxlib.math.vector.vector3I

public data class MutableAABB3I(
    override var min: MutablePosition3I,
    override var max: MutablePosition3I,
) : AABB3I, MutableAABB3<Int> {

    override val size: Vector3I
        get() = vector3I(max.x - min.x + 1, max.y - min.y + 1, max.z - min.z + 1)

    override val surface: Int
        get() {
            val size = size
            return 2 * (size.x * size.y + size.y * size.z + size.z * size.x)
        }

    override val volume: Int
        get() = (max.x - min.x + 1) * (max.y - min.y + 1) * (max.z - min.z + 1)

    override fun expand(amount: Int) {
        min.x -= amount
        min.y -= amount
        min.z -= amount
        max.x += amount
        max.y += amount
        max.z += amount
    }

    override fun expandedCopy(amount: Int): MutableAABB3I {
        return MutableAABB3I(min - vector3I(amount, amount, amount), max + vector3I(amount, amount, amount))
    }

    override fun isOnSurface(position: Position3<Int>): Boolean {
        return position.x == min.x || position.x == max.x || position.y == min.y || position.y == max.y || position.z == min.z || position.z == max.z
    }

    override fun iterator(): Iterator<Position3I> {
        return object : Iterator<Position3I> {
            private val next = min.mutableCopy()

            override fun hasNext(): Boolean {
                return next.x <= max.x && next.y <= max.y && next.z <= max.z
            }

            override fun next(): Position3I {
                val position = next.copy()

                ++next.x
                if (next.x > max.x) {
                    next.x = min.x

                    ++next.y
                    if (next.y > max.y) {
                        next.y = min.y

                        ++next.z
                    }
                }

                return position
            }
        }
    }
}
