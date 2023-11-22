package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionI
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionI
import kotlin.random.Random

public interface VectorI : Vector<Int> {

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
    public fun normalized(): VectorD

    override fun unaryMinus(): VectorI

    override fun unaryPlus(): VectorI

    override fun plus(other: Vector<Int>): VectorI

    override fun minus(other: Vector<Int>): VectorI

    override fun times(scalar: Int): VectorI

    override fun div(scalar: Int): VectorI

    override fun copy(): VectorI

    override fun mutableCopy(): MutableVectorI

    override fun position(): PositionI

    override fun position(origin: Position<Int>): PositionI

    override fun mutablePosition(): MutablePositionI

    override fun mutablePosition(origin: Position<Int>): MutablePositionI

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(vararg data: Int): VectorI {
            return MutableVectorI(data)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(size: Int, value: Int): VectorI {
            return MutableVectorI(size) { value }
        }

        /**
         * Generates a random vector.
         */
        public fun random(size: Int): VectorI {
            return MutableVectorI(size) {
                Random.nextInt()
            }
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(size: Int, from: Int, until: Int): VectorI {
            return MutableVectorI(size) {
                Random.nextInt(from, until)
            }
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(size: Int, from: Vector<Int>, until: Vector<Int>): VectorI {
            return MutableVectorI(size) { i ->
                Random.nextInt(from[i], until[i])
            }
        }
    }
}
