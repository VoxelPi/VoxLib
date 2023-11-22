package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionF
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionF
import kotlin.random.Random

public interface VectorF : Vector<Float> {

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
    public fun normalized(): VectorF

    override fun unaryMinus(): VectorF

    override fun unaryPlus(): VectorF

    override fun plus(other: Vector<Float>): VectorF

    override fun minus(other: Vector<Float>): VectorF

    override fun times(scalar: Float): VectorF

    override fun div(scalar: Float): VectorF

    override fun copy(): VectorF

    override fun mutableCopy(): MutableVectorF

    override fun position(): PositionF

    override fun position(origin: Position<Float>): PositionF

    override fun mutablePosition(): MutablePositionF

    override fun mutablePosition(origin: Position<Float>): MutablePositionF

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(vararg data: Float): VectorF {
            return MutableVectorF(data)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(size: Int, value: Float): VectorF {
            return MutableVectorF(size) { value }
        }

        /**
         * Generates a random vector.
         */
        public fun random(size: Int): VectorF {
            return MutableVectorF(size) {
                Random.nextFloat()
            }
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(size: Int, from: Float, until: Float): VectorF {
            return MutableVectorF(size) {
                Random.nextFloat() * (until - from) + from
            }
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(size: Int, from: Vector<Float>, until: Vector<Float>): VectorF {
            return MutableVectorF(size) { i ->
                Random.nextFloat() * (until[i] - from[i]) + from[i]
            }
        }
    }
}
