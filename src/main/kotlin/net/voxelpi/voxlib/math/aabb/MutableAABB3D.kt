package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition3D
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.vector.Vector3D
import net.voxelpi.voxlib.math.vector.vector3D
import kotlin.math.abs

public data class MutableAABB3D(
    override var min: MutablePosition3D,
    override var max: MutablePosition3D,
) : AABB3D, MutableAABB3<Double> {

    override val size: Vector3D
        get() = vector3D(max.x - min.x, max.y - min.y, max.z - min.z)

    override val surface: Double
        get() {
            val size = size
            return 2 * (size.x * size.y + size.y * size.z + size.z * size.x)
        }

    override val volume: Double
        get() = (max.x - min.x) * (max.y - min.y) * (max.z - min.z)

    override fun expand(amount: Double) {
        min.x -= amount
        min.y -= amount
        min.z -= amount
        max.x += amount
        max.y += amount
        max.z += amount
    }

    override fun expandedCopy(amount: Double): MutableAABB3D {
        return MutableAABB3D(min - vector3D(amount, amount, amount), max + vector3D(amount, amount, amount))
    }

    override fun isOnBoundary(position: Position3<Double>): Boolean {
        return position.x == min.x || position.x == max.x
            || position.y == min.y || position.y == max.y
            || position.z == min.z || position.z == max.z
    }

    override fun isOnBoundary(position: Position3<Double>, tolerance: Double): Boolean {
        return abs(position.x - min.x) < tolerance || abs(position.x - max.x) < tolerance
            || abs(position.y - min.y) < tolerance || abs(position.y - max.y) < tolerance
            || abs(position.z - min.z) < tolerance || abs(position.z - max.z) < tolerance
    }
}
