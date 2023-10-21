package net.voxelpi.voxlib.math.vector

import kotlin.math.sqrt

data class MutableVector4F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
    override var w: Float,
): Vector4F, MutableVector4<Float> {

    override fun plusAssign(other: Vector4<Float>) {
        x += other.x
        y += other.y
        z += other.z
        w += other.w
    }

    override fun minusAssign(other: Vector4<Float>) {
        x -= other.x
        y -= other.y
        z -= other.z
        w -= other.w
    }

    override fun timesAssign(scalar: Float) {
        x *= scalar
        y *= scalar
        z *= scalar
        w *= scalar
    }

    override fun divAssign(scalar: Float) {
        x /= scalar
        y /= scalar
        z /= scalar
        w /= scalar
    }

    override fun set(value: Vector4<Float>) {
        x = value.x
        y = value.y
        z = value.z
        w = value.w
    }

    override fun set(value: Float) {
        x = value
        y = value
        z = value
        w = value
    }


    override fun unaryMinus(): MutableVector4F {
        return MutableVector4F(-x, -y, -z, -w)
    }

    override fun unaryPlus(): MutableVector4F {
        return MutableVector4F(+x, +y, +z, +w)
    }

    override fun plus(other: Vector4<Float>): MutableVector4F {
        return MutableVector4F(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    override fun minus(other: Vector4<Float>): MutableVector4F {
        return MutableVector4F(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    override fun times(scalar: Float): MutableVector4F {
        return MutableVector4F(x * scalar, y * scalar, z * scalar, w * scalar)
    }

    override fun div(scalar: Float): MutableVector4F {
        return MutableVector4F(x / scalar, y / scalar, z / scalar, w / scalar)
    }

    override fun dot(other: Vector4<Float>): Float {
        return x * other.x + y * other.y + z * other.z + w * other.w
    }


    override fun copy(): Vector4F {
        return MutableVector4F(x, y, z, w)
    }

    override fun mutableCopy(): MutableVector4F {
        return MutableVector4F(x, y, z, w)
    }


    override fun length(): Float {
        return sqrt(x*x + y*y + z*z + w*w)
    }

    override fun lengthSquared(): Float {
        return x*x + y*y + z*z + w*w
    }
}
