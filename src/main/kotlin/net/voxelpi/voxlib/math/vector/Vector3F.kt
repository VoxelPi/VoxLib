package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3F
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3F
import kotlin.math.cbrt
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

public interface Vector3F : Vector3<Float> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Float

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Float

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector3F

    override fun unaryMinus(): Vector3F

    override fun unaryPlus(): Vector3F

    override fun plus(other: Vector3<Float>): Vector3F

    override fun minus(other: Vector3<Float>): Vector3F

    override fun times(scalar: Float): Vector3F

    override fun div(scalar: Float): Vector3F

    override fun copy(): Vector3F

    override fun mutableCopy(): MutableVector3F

    override fun position(): Position3F

    override fun position(origin: Position3<Float>): Position3F

    override fun mutablePosition(): MutablePosition3F

    override fun mutablePosition(origin: Position3<Float>): MutablePosition3F

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Float, y: Float, z: Float): Vector3F {
            return MutableVector3F(x, y, z)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Float): Vector3F {
            return MutableVector3F(value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector3F {
            return MutableVector3F(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Float, until: Float): Vector3F {
            return MutableVector3F(
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector3<Float>, until: Vector3<Float>): Vector3F {
            return MutableVector3F(
                Random.nextFloat() * (until.x - from.x) + from.x,
                Random.nextFloat() * (until.y - from.y) + from.y,
                Random.nextFloat() * (until.z - from.z) + from.z,
            )
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideSphere(radius: Float = 1F): Vector3F {
            return randomOnSphere(radius) * cbrt(Random.nextFloat())
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnSphere(radius: Float = 1F): Vector3F {
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
            return (vector3F(x, y, z) / magnitude) * radius
        }
    }
}
