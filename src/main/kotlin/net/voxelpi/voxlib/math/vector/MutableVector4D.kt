package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4D
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4D
import net.voxelpi.voxlib.math.position.mutablePosition4D
import net.voxelpi.voxlib.math.position.position4D
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector4D(
    override var x: Double,
    override var y: Double,
    override var z: Double,
    override var w: Double,
) : Vector4D, MutableVector4<Double> {

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

    override fun timesAssign(scalar: Double) {
        x *= scalar
        y *= scalar
        z *= scalar
        w *= scalar
    }

    override fun divAssign(scalar: Double) {
        x /= scalar
        y /= scalar
        z /= scalar
        w /= scalar
    }

    override fun set(value: Vector4<Double>) {
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

    override fun unaryMinus(): MutableVector4D {
        return MutableVector4D(-x, -y, -z, -w)
    }

    override fun unaryPlus(): MutableVector4D {
        return MutableVector4D(+x, +y, +z, +w)
    }

    override fun plus(other: Vector4<Double>): MutableVector4D {
        return MutableVector4D(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    override fun minus(other: Vector4<Double>): MutableVector4D {
        return MutableVector4D(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    override fun times(scalar: Double): MutableVector4D {
        return MutableVector4D(x * scalar, y * scalar, z * scalar, w * scalar)
    }

    override fun div(scalar: Double): MutableVector4D {
        return MutableVector4D(x / scalar, y / scalar, z / scalar, w / scalar)
    }

    override fun dot(other: Vector4<Double>): Double {
        return x * other.x + y * other.y + z * other.z + w * other.w
    }

    override fun copy(): Vector4D {
        return MutableVector4D(x, y, z, w)
    }

    override fun mutableCopy(): MutableVector4D {
        return MutableVector4D(x, y, z, w)
    }

    override fun position(): Position4D {
        return position4D(x, y, z, w)
    }

    override fun position(origin: Position4<Double>): Position4D {
        return position4D(origin.x + x, origin.y + y, origin.z + z, origin.w + w)
    }

    override fun mutablePosition(): MutablePosition4D {
        return mutablePosition4D(x, y, z, w)
    }

    override fun mutablePosition(origin: Position4<Double>): MutablePosition4D {
        return mutablePosition4D(origin.x + x, origin.y + y, origin.z + z, origin.w + w)
    }

    override fun length(): Double {
        return sqrt(x * x + y * y + z * z + w * w)
    }

    override fun lengthSquared(): Double {
        return x * x + y * y + z * z + w * w
    }

    override fun normalized(): Vector4D {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVector4D {
        this /= length()
        return this
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Double, y: Double, z: Double, w: Double): MutableVector4D {
            return MutableVector4D(x, y, z, w)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Double): MutableVector4D {
            return MutableVector4D(value, value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector4D {
            return MutableVector4D(
                Random.nextDouble(),
                Random.nextDouble(),
                Random.nextDouble(),
                Random.nextDouble(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Double, until: Double): MutableVector4D {
            return MutableVector4D(
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector4<Double>, until: Vector4<Double>): MutableVector4D {
            return MutableVector4D(
                Random.nextDouble(from.x, until.x),
                Random.nextDouble(from.y, until.y),
                Random.nextDouble(from.z, until.z),
                Random.nextDouble(from.w, until.w),
            )
        }
    }
}
