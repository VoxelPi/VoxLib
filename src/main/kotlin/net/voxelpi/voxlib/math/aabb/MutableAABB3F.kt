package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition3F
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.vector.Vector3F
import net.voxelpi.voxlib.math.vector.vector3F

public data class MutableAABB3F(
    override var min: MutablePosition3F,
    override var max: MutablePosition3F,
) : AABB3F, MutableAABB3<Float> {

    override val size: Vector3F
        get() = vector3F(max.x - min.x, max.y - min.y, max.z - min.z)

    override val surface: Float
        get() {
            val size = size
            return 2 * (size.x * size.y + size.y * size.z + size.z * size.x)
        }

    override val volume: Float
        get() = (max.x - min.x) * (max.y - min.y) * (max.z - min.z)

    override fun expand(amount: Float) {
        min.x -= amount
        min.y -= amount
        min.z -= amount
        max.x += amount
        max.y += amount
        max.z += amount
    }

    override fun expandedCopy(amount: Float): MutableAABB3F {
        return MutableAABB3F(min - vector3F(amount, amount, amount), max + vector3F(amount, amount, amount))
    }

    override fun isOnSurface(position: Position3<Float>): Boolean {
        return position.x == min.x || position.x == max.x
            || position.y == min.y || position.y == max.y
            || position.z == min.z || position.z == max.z
    }
}
