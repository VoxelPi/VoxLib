package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3I
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3I
import kotlin.random.Random

public interface Vector3I : Vector3<Int> {

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
    public fun normalized(): Vector3D

    override fun unaryMinus(): Vector3I

    override fun unaryPlus(): Vector3I

    override fun plus(other: Vector3<Int>): Vector3I

    override fun minus(other: Vector3<Int>): Vector3I

    override fun times(scalar: Int): Vector3I

    override fun div(scalar: Int): Vector3I

    override fun copy(): Vector3I

    override fun mutableCopy(): MutableVector3I

    override fun position(): Position3I

    override fun position(origin: Position3<Int>): Position3I

    override fun mutablePosition(): MutablePosition3I

    override fun mutablePosition(origin: Position3<Int>): MutablePosition3I

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Int, y: Int, z: Int): Vector3I {
            return MutableVector3I(x, y, z)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Int): Vector3I {
            return MutableVector3I(value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector3I {
            return MutableVector3I(
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Int, until: Int): Vector3I {
            return MutableVector3I(
                Random.nextInt(from, until),
                Random.nextInt(from, until),
                Random.nextInt(from, until),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector3<Int>, until: Vector3<Int>): Vector3I {
            return MutableVector3I(
                Random.nextInt(from.x, until.x),
                Random.nextInt(from.y, until.y),
                Random.nextInt(from.z, until.z),
            )
        }
    }
}
