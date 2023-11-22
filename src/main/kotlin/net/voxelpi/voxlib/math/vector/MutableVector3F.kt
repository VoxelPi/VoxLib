package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3F
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3F
import net.voxelpi.voxlib.math.position.mutablePosition3F
import net.voxelpi.voxlib.math.position.position3F
import kotlin.math.cbrt
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector3F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
) : Vector3F, MutableVector3<Float> {

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

    override fun position(): Position3F {
        return position3F(x, y, z)
    }

    override fun position(origin: Position3<Float>): Position3F {
        return position3F(origin.x + x, origin.y + y, origin.z + z)
    }

    override fun mutablePosition(): MutablePosition3F {
        return mutablePosition3F(x, y, z)
    }

    override fun mutablePosition(origin: Position3<Float>): MutablePosition3F {
        return mutablePosition3F(origin.x + x, origin.y + y, origin.z + z)
    }

    override fun length(): Float {
        return sqrt(x * x + y * y + z * z)
    }

    override fun lengthSquared(): Float {
        return x * x + y * y + z * z
    }

    override fun normalized(): Vector3F {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVector3F {
        this /= length()
        return this
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Float, y: Float, z: Float): MutableVector3F {
            return MutableVector3F(x, y, z)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Float): MutableVector3F {
            return MutableVector3F(value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector3F {
            return MutableVector3F(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Float, until: Float): MutableVector3F {
            return MutableVector3F(
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector3<Float>, until: Vector3<Float>): MutableVector3F {
            return MutableVector3F(
                Random.nextFloat() * (until.x - from.x) + from.x,
                Random.nextFloat() * (until.y - from.y) + from.y,
                Random.nextFloat() * (until.z - from.z) + from.z,
            )
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideSphere(radius: Float = 1F): MutableVector3F {
            return randomOnSphere(radius) * cbrt(Random.nextFloat())
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnSphere(radius: Float = 1F): MutableVector3F {
            val random = java.util.Random()
            var x = 0F
            var y = 0F
            var z = 0F
            var magnitude = 0F
            while (magnitude < 1e-8) {
                x = random.nextGaussian().toFloat()
                y = random.nextGaussian().toFloat()
                z = random.nextGaussian().toFloat()
                magnitude = sqrt(x.pow(2) + y.pow(2) + z.pow(2))
            }
            return (mutableVector3F(x, y, z) / magnitude) * radius
        }
    }
}
