package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector4D
import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4D
import net.voxelpi.voxlib.math.vector.vector4D

public data class MutablePosition4D(
    override var x: Double,
    override var y: Double,
    override var z: Double,
    override var w: Double,
) : Position4D, MutablePosition4<Double> {

    override fun plusAssign(other: Vector4<Double>) {
        x += other.x
        y += other.y
        z += other.z
        w += other.w
    }

    override fun minusAssign(other: Vector4<Double>) {
        x -= other.x
        y -= other.y
        z -= other.z
        w -= other.w
    }

    override fun set(value: Position4<Double>) {
        x = value.x
        y = value.y
        z = value.z
        w = value.w
    }

    override fun set(value: Double) {
        x = value
        y = value
        z = value
        w = value
    }

    override fun plus(other: Vector4<Double>): MutablePosition4D {
        return MutablePosition4D(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    override fun minus(other: Vector4<Double>): MutablePosition4D {
        return MutablePosition4D(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    override fun minus(other: Position4<Double>): Vector4D {
        return vector4D(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    override fun copy(): Position4D {
        return MutablePosition4D(x, y, z, w)
    }

    override fun mutableCopy(): MutablePosition4D {
        return MutablePosition4D(x, y, z, w)
    }

    override fun vector(): Vector4D {
        return MutableVector4D(x, y, z, w)
    }

    override fun mutableVector(): MutableVector4D {
        return MutableVector4D(x, y, z, w)
    }
}
