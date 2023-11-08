package net.voxelpi.voxlib.math.vector

import kotlin.math.sqrt

public data class MutableVector3D(
    override var x: Double,
    override var y: Double,
    override var z: Double,
): Vector3D, MutableVector3<Double> {

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

    override fun timesAssign(scalar: Double) {
        x *= scalar
        y *= scalar
        z *= scalar
    }

    override fun divAssign(scalar: Double) {
        x /= scalar
        y /= scalar
        z /= scalar
    }

    override fun set(value: Vector3<Double>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Double) {
        x = value
        y = value
        z = value
    }


    override fun unaryMinus(): MutableVector3D {
        return MutableVector3D(-x, -y, -z)
    }

    override fun unaryPlus(): MutableVector3D {
        return MutableVector3D(+x, +y, +z)
    }

    override fun plus(other: Vector3<Double>): MutableVector3D {
        return MutableVector3D(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Double>): MutableVector3D {
        return MutableVector3D(x - other.x, y - other.y, z - other.z)
    }

    override fun times(scalar: Double): MutableVector3D {
        return MutableVector3D(x * scalar, y * scalar, z * scalar)
    }

    override fun div(scalar: Double): MutableVector3D {
        return MutableVector3D(x / scalar, y / scalar, z / scalar)
    }

    override fun dot(other: Vector3<Double>): Double {
        return x * other.x + y * other.y + z * other.z
    }


    override fun copy(): Vector3D {
        return MutableVector3D(x, y, z)
    }

    override fun mutableCopy(): MutableVector3D {
        return MutableVector3D(x, y, z)
    }


    override fun length(): Double {
        return sqrt(x*x + y*y + z*z)
    }

    override fun lengthSquared(): Double {
        return x*x + y*y + z*z
    }
}
