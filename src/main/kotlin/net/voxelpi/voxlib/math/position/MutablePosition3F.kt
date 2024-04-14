package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.aabb.AABB3
import net.voxelpi.voxlib.math.vector.MutableVector3F
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3F
import net.voxelpi.voxlib.math.vector.vector3F

public data class MutablePosition3F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
) : Position3F, MutablePosition3<Float> {

    override fun plusAssign(other: Vector3<Float>) {
        x += other.x
        y += other.y
        z += other.z
    }

    override fun minusAssign(other: Vector3<Float>) {
        x -= other.x
        y -= other.y
        z -= other.z
    }

    override fun set(value: Position3<Float>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Float) {
        x = value
        y = value
        z = value
    }

    override fun plus(other: Vector3<Float>): MutablePosition3F {
        return MutablePosition3F(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Float>): MutablePosition3F {
        return MutablePosition3F(x - other.x, y - other.y, z - other.z)
    }

    override fun minus(other: Position3<Float>): Vector3F {
        return vector3F(x - other.x, y - other.y, z - other.z)
    }

    override fun to(position: Position3<Float>): Vector3F {
        return vector3F(position.x - x, position.y - y, position.z - z)
    }

    override fun relativeTo(position: Position3<Float>): Position3F {
        return position3F(x - position.x, y - position.y, z - position.z)
    }

    override fun relativeTo(aabb: AABB3<Float>): Position3F {
        return position3F(x - aabb.min.x, y - aabb.min.y, z - aabb.min.z)
    }

    override fun copy(): Position3F {
        return MutablePosition3F(x, y, z)
    }

    override fun mutableCopy(): MutablePosition3F {
        return MutablePosition3F(x, y, z)
    }

    override fun vector(): Vector3F {
        return MutableVector3F(x, y, z)
    }

    override fun mutableVector(): MutableVector3F {
        return MutableVector3F(x, y, z)
    }
}
