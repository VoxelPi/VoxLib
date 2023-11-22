package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3D
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3D
import kotlin.math.cbrt
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

public interface Vector3D : Vector3<Double> {

    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Double

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector3D

    override fun unaryMinus(): Vector3D

    override fun unaryPlus(): Vector3D

    override fun plus(other: Vector3<Double>): Vector3D

    override fun minus(other: Vector3<Double>): Vector3D

    override fun times(scalar: Double): Vector3D

    override fun div(scalar: Double): Vector3D

    override fun copy(): Vector3D

    override fun mutableCopy(): MutableVector3D

    override fun position(): Position3D

    override fun position(origin: Position3<Double>): Position3D

    override fun mutablePosition(): MutablePosition3D

    override fun mutablePosition(origin: Position3<Double>): MutablePosition3D

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Double, y: Double, z: Double): Vector3D {
            return MutableVector3D(x, y, z)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Double): Vector3D {
            return MutableVector3D(value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector3D {
            return MutableVector3D(
                Random.nextDouble(),
                Random.nextDouble(),
                Random.nextDouble(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Double, until: Double): Vector3D {
            return MutableVector3D(
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector3<Double>, until: Vector3<Double>): Vector3D {
            return MutableVector3D(
                Random.nextDouble(from.x, until.x),
                Random.nextDouble(from.y, until.y),
                Random.nextDouble(from.z, until.z),
            )
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideSphere(radius: Double = 1.0): Vector3D {
            return randomOnSphere(radius) * cbrt(Random.nextDouble())
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnSphere(radius: Double = 1.0): Vector3D {
            val random = java.util.Random()
            var x = 0.0
            var y = 0.0
            var z = 0.0
            var magnitude = 0.0
            while (magnitude < 1e-8) {
                x = random.nextGaussian()
                y = random.nextGaussian()
                z = random.nextGaussian()
                magnitude = sqrt(x.pow(2) + y.pow(2) + z.pow(2))
            }
            return (vector3D(x, y, z) / magnitude) * radius
        }
    }
}
