package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4I
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4I
import net.voxelpi.voxlib.math.position.mutablePosition4I
import net.voxelpi.voxlib.math.position.position4I
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector4I(
    override var x: Int,
    override var y: Int,
    override var z: Int,
    override var w: Int,
) : Vector4I, MutableVector4<Int> {

    override fun plusAssign(other: Vector4<Int>) {
        x += other.x
        y += other.y
        z += other.z
        w += other.w
    }

    override fun minusAssign(other: Vector4<Int>) {
        x -= other.x
        y -= other.y
        z -= other.z
        w -= other.w
    }

    override fun timesAssign(scalar: Int) {
        x *= scalar
        y *= scalar
        z *= scalar
        w *= scalar
    }

    override fun divAssign(scalar: Int) {
        x /= scalar
        y /= scalar
        z /= scalar
        w /= scalar
    }

    override fun set(value: Vector4<Int>) {
        x = value.x
        y = value.y
        z = value.z
        w = value.w
    }

    override fun set(value: Int) {
        x = value
        y = value
        z = value
        w = value
    }

    override fun unaryMinus(): MutableVector4I {
        return MutableVector4I(-x, -y, -z, -w)
    }

    override fun unaryPlus(): MutableVector4I {
        return MutableVector4I(+x, +y, +z, +w)
    }

    override fun plus(other: Vector4<Int>): MutableVector4I {
        return MutableVector4I(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    override fun minus(other: Vector4<Int>): MutableVector4I {
        return MutableVector4I(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    override fun times(scalar: Int): MutableVector4I {
        return MutableVector4I(x * scalar, y * scalar, z * scalar, w * scalar)
    }

    override fun div(scalar: Int): MutableVector4I {
        return MutableVector4I(x / scalar, y / scalar, z / scalar, w / scalar)
    }

    override fun dot(other: Vector4<Int>): Int {
        return x * other.x + y * other.y + z * other.z + w * other.w
    }

    override fun copy(): Vector4I {
        return MutableVector4I(x, y, z, w)
    }

    override fun mutableCopy(): MutableVector4I {
        return MutableVector4I(x, y, z, w)
    }

    override fun position(): Position4I {
        return position4I(x, y, z, w)
    }

    override fun position(origin: Position4<Int>): Position4I {
        return position4I(origin.x + x, origin.y + y, origin.z + z, origin.w + w)
    }

    override fun mutablePosition(): MutablePosition4I {
        return mutablePosition4I(x, y, z, w)
    }

    override fun mutablePosition(origin: Position4<Int>): MutablePosition4I {
        return mutablePosition4I(origin.x + x, origin.y + y, origin.z + z, origin.w + w)
    }

    override fun length(): Double {
        return sqrt((x * x + y * y + z * z + w * w).toDouble())
    }

    override fun lengthSquared(): Int {
        return x * x + y * y + z * z + w * w
    }

    override fun normalized(): Vector4D {
        return this.toDouble() / length()
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Int, y: Int, z: Int, w: Int): MutableVector4I {
            return MutableVector4I(x, y, z, w)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Int): MutableVector4I {
            return MutableVector4I(value, value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector4I {
            return MutableVector4I(
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Int, until: Int): MutableVector4I {
            return MutableVector4I(
                Random.nextInt(from, until),
                Random.nextInt(from, until),
                Random.nextInt(from, until),
                Random.nextInt(from, until),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector4<Int>, until: Vector4<Int>): MutableVector4I {
            return MutableVector4I(
                Random.nextInt(from.x, until.x),
                Random.nextInt(from.y, until.y),
                Random.nextInt(from.z, until.z),
                Random.nextInt(from.w, until.w),
            )
        }
    }
}
