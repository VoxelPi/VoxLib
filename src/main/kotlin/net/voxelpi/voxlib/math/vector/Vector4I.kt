package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4I
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4I
import kotlin.random.Random

public interface Vector4I : Vector4<Int> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Int

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector4D

    override fun unaryMinus(): Vector4I

    override fun unaryPlus(): Vector4I

    override fun plus(other: Vector4<Int>): Vector4I

    override fun minus(other: Vector4<Int>): Vector4I

    override fun times(scalar: Int): Vector4I

    override fun div(scalar: Int): Vector4I

    override fun copy(): Vector4I

    override fun mutableCopy(): MutableVector4I

    override fun position(): Position4I

    override fun position(origin: Position4<Int>): Position4I

    override fun mutablePosition(): MutablePosition4I

    override fun mutablePosition(origin: Position4<Int>): MutablePosition4I

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Int, y: Int, z: Int, w: Int): Vector4I {
            return MutableVector4I(x, y, z, w)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Int): Vector4I {
            return MutableVector4I(value, value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector4I {
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
        public fun random(from: Int, until: Int): Vector4I {
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
        public fun random(from: Vector4<Int>, until: Vector4<Int>): Vector4I {
            return MutableVector4I(
                Random.nextInt(from.x, until.x),
                Random.nextInt(from.y, until.y),
                Random.nextInt(from.z, until.z),
                Random.nextInt(from.w, until.w),
            )
        }
    }
}
