package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector3D
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3D
import net.voxelpi.voxlib.math.vector.vector3D

public data class MutablePosition3D(
    override var x: Double,
    override var y: Double,
    override var z: Double,
) : Position3D, MutablePosition3<Double> {

    override fun plusAssign(other: Vector3<Double>) {
        x += other.x
        y += other.y
        z += other.z
    }

    override fun minusAssign(other: Vector3<Double>) {
        x -= other.x
        y -= other.y
        z -= other.z
    }

    override fun set(value: Position3<Double>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Double) {
        x = value
        y = value
        z = value
    }

    override fun plus(other: Vector3<Double>): MutablePosition3D {
        return MutablePosition3D(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Double>): MutablePosition3D {
        return MutablePosition3D(x - other.x, y - other.y, z - other.z)
    }

    override fun minus(other: Position3<Double>): Vector3D {
        return vector3D(x - other.x, y - other.y, z - other.z)
    }

    override fun copy(): Position3D {
        return MutablePosition3D(x, y, z)
    }

    override fun mutableCopy(): MutablePosition3D {
        return MutablePosition3D(x, y, z)
    }

    override fun vector(): Vector3D {
        return MutableVector3D(x, y, z)
    }

    override fun mutableVector(): MutableVector3D {
        return MutableVector3D(x, y, z)
    }
}
