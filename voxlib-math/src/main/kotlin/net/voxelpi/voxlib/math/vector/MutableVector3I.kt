package net.voxelpi.voxlib.math.vector

import kotlin.math.sqrt

public data class MutableVector3I(
    override var x: Int,
    override var y: Int,
    override var z: Int,
): Vector3I, MutableVector3<Int> {

    override fun plusAssign(other: Vector3<Int>) {
        x += other.x
        y += other.y
        z += other.z
    }

    override fun minusAssign(other: Vector3<Int>) {
        x -= other.x
        y -= other.y
        z -= other.z
    }

    override fun timesAssign(scalar: Int) {
        x *= scalar
        y *= scalar
        z *= scalar
    }

    override fun divAssign(scalar: Int) {
        x /= scalar
        y /= scalar
        z /= scalar
    }

    override fun set(value: Vector3<Int>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Int) {
        x = value
        y = value
        z = value
    }


    override fun unaryMinus(): MutableVector3I {
        return MutableVector3I(-x, -y, -z)
    }

    override fun unaryPlus(): MutableVector3I {
        return MutableVector3I(+x, +y, +z)
    }

    override fun plus(other: Vector3<Int>): MutableVector3I {
        return MutableVector3I(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Int>): MutableVector3I {
        return MutableVector3I(x - other.x, y - other.y, z - other.z)
    }

    override fun times(scalar: Int): MutableVector3I {
        return MutableVector3I(x * scalar, y * scalar, z * scalar)
    }

    override fun div(scalar: Int): MutableVector3I {
        return MutableVector3I(x / scalar, y / scalar, z / scalar)
    }

    override fun dot(other: Vector3<Int>): Int {
        return x * other.x + y * other.y + z * other.z
    }


    override fun copy(): Vector3I {
        return MutableVector3I(x, y, z)
    }

    override fun mutableCopy(): MutableVector3I {
        return MutableVector3I(x, y, z)
    }


    override fun length(): Double {
        return sqrt((x*x + y*y + z*z).toDouble())
    }

    override fun lengthSquared(): Int {
        return x*x + y*y + z*z
    }
}
