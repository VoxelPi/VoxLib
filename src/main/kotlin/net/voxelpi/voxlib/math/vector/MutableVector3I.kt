package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3I
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3I
import net.voxelpi.voxlib.math.position.mutablePosition3I
import net.voxelpi.voxlib.math.position.position3I
import kotlin.math.sqrt

public data class MutableVector3I(
    override var x: Int,
    override var y: Int,
    override var z: Int,
) : Vector3I, MutableVector3<Int> {

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

    override fun position(): Position3I {
        return position3I(x, y, z)
    }

    override fun position(origin: Position3<Int>): Position3I {
        return position3I(origin.x + x, origin.y + y, origin.z + z)
    }

    override fun mutablePosition(): MutablePosition3I {
        return mutablePosition3I(x, y, z)
    }

    override fun mutablePosition(origin: Position3<Int>): MutablePosition3I {
        return mutablePosition3I(origin.x + x, origin.y + y, origin.z + z)
    }

    override fun length(): Double {
        return sqrt((x * x + y * y + z * z).toDouble())
    }

    override fun lengthSquared(): Int {
        return x * x + y * y + z * z
    }
}
