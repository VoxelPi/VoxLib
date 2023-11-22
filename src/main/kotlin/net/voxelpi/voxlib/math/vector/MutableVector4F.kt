package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4F
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4F
import net.voxelpi.voxlib.math.position.mutablePosition4F
import net.voxelpi.voxlib.math.position.position4F
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector4F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
    override var w: Float,
) : Vector4F, MutableVector4<Float> {

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

    override fun position(): Position4F {
        return position4F(x, y, z, w)
    }

    override fun position(origin: Position4<Float>): Position4F {
        return position4F(origin.x + x, origin.y + y, origin.z + z, origin.w + w)
    }

    override fun mutablePosition(): MutablePosition4F {
        return mutablePosition4F(x, y, z, w)
    }

    override fun mutablePosition(origin: Position4<Float>): MutablePosition4F {
        return mutablePosition4F(origin.x + x, origin.y + y, origin.z + z, origin.w + w)
    }

    override fun length(): Float {
        return sqrt(x * x + y * y + z * z + w * w)
    }

    override fun lengthSquared(): Float {
        return x * x + y * y + z * z + w * w
    }

    override fun normalized(): Vector4F {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVector4F {
        this /= length()
        return this
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Float, y: Float, z: Float, w: Float): MutableVector4F {
            return MutableVector4F(x, y, z, w)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Float): MutableVector4F {
            return MutableVector4F(value, value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector4F {
            return MutableVector4F(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Float, until: Float): MutableVector4F {
            return MutableVector4F(
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector4<Float>, until: Vector4<Float>): MutableVector4F {
            return MutableVector4F(
                Random.nextFloat() * (until.x - from.x) + from.x,
                Random.nextFloat() * (until.y - from.y) + from.y,
                Random.nextFloat() * (until.z - from.z) + from.z,
                Random.nextFloat() * (until.w - from.w) + from.w,
            )
        }
    }
}
