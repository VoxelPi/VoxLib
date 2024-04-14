package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition2I
import net.voxelpi.voxlib.math.position.Position2I
import net.voxelpi.voxlib.math.vector.Vector2I
import net.voxelpi.voxlib.math.vector.vector2I

public data class MutableAABB2I(
    override var min: MutablePosition2I,
    override var max: MutablePosition2I,
) : AABB2I, MutableAABB2<Int> {

    override val size: Vector2I
        get() = vector2I(max.x - min.x + 1, max.y - min.y + 1)

    override val surface: Int
        get() = (max.x - min.x + 1) * (max.y - min.y + 1)

    override fun expand(amount: Int) {
        min.x -= amount
        min.y -= amount
        max.x += amount
        max.y += amount
    }

    override fun expandedCopy(amount: Int): MutableAABB2I {
        return MutableAABB2I(min - vector2I(amount, amount), max + vector2I(amount, amount))
    }

    override fun iterator(): Iterator<Position2I> {
        return object : Iterator<Position2I> {
            private val next = min.mutableCopy()

            override fun hasNext(): Boolean {
                return next.x <= max.x && next.y <= max.y
            }

            override fun next(): Position2I {
                val position = next.copy()

                ++next.x
                if (next.x > max.x) {
                    next.x = min.x

                    ++next.y
                }

                return position
            }
        }
    }
}
