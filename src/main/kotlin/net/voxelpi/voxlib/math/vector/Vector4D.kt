package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4D
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4D
import kotlin.random.Random

public interface Vector4D : Vector4<Double> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Double

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector4D

    override fun unaryMinus(): Vector4D

    override fun unaryPlus(): Vector4D

    override fun plus(other: Vector4<Double>): Vector4D

    override fun minus(other: Vector4<Double>): Vector4D

    override fun times(scalar: Double): Vector4D

    override fun div(scalar: Double): Vector4D

    override fun copy(): Vector4D

    override fun mutableCopy(): MutableVector4D

    override fun position(): Position4D

    override fun position(origin: Position4<Double>): Position4D

    override fun mutablePosition(): MutablePosition4D

    override fun mutablePosition(origin: Position4<Double>): MutablePosition4D

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Double, y: Double, z: Double, w: Double): Vector4D {
            return MutableVector4D(x, y, z, w)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Double): Vector4D {
            return MutableVector4D(value, value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector4D {
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
        public fun random(from: Double, until: Double): Vector4D {
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
        public fun random(from: Vector4<Double>, until: Vector4<Double>): Vector4D {
            return MutableVector4D(
                Random.nextDouble(from.x, until.x),
                Random.nextDouble(from.y, until.y),
                Random.nextDouble(from.z, until.z),
                Random.nextDouble(from.w, until.w),
            )
        }
    }
}
