package net.voxelpi.voxlib.math.vector

import kotlin.math.sqrt

public data class MutableVector3F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
): Vector3F, MutableVector3<Float> {

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

    override fun timesAssign(scalar: Float) {
        x *= scalar
        y *= scalar
        z *= scalar
    }

    override fun divAssign(scalar: Float) {
        x /= scalar
        y /= scalar
        z /= scalar
    }

    override fun set(value: Vector3<Float>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Float) {
        x = value
        y = value
        z = value
    }


    override fun unaryMinus(): MutableVector3F {
        return MutableVector3F(-x, -y, -z)
    }

    override fun unaryPlus(): MutableVector3F {
        return MutableVector3F(+x, +y, +z)
    }

    override fun plus(other: Vector3<Float>): MutableVector3F {
        return MutableVector3F(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Float>): MutableVector3F {
        return MutableVector3F(x - other.x, y - other.y, z - other.z)
    }

    override fun times(scalar: Float): MutableVector3F {
        return MutableVector3F(x * scalar, y * scalar, z * scalar)
    }

    override fun div(scalar: Float): MutableVector3F {
        return MutableVector3F(x / scalar, y / scalar, z / scalar)
    }

    override fun dot(other: Vector3<Float>): Float {
        return x * other.x + y * other.y + z * other.z
    }


    override fun copy(): Vector3F {
        return MutableVector3F(x, y, z)
    }

    override fun mutableCopy(): MutableVector3F {
        return MutableVector3F(x, y, z)
    }


    override fun length(): Float {
        return sqrt(x*x + y*y + z*z)
    }

    override fun lengthSquared(): Float {
        return x*x + y*y + z*z
    }
}