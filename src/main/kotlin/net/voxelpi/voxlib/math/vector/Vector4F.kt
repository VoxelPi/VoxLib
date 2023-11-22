package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4F
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4F
import kotlin.random.Random

public interface Vector4F : Vector4<Float> {

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
    public fun normalized(): Vector4F

    override fun unaryMinus(): Vector4F

    override fun unaryPlus(): Vector4F

    override fun plus(other: Vector4<Float>): Vector4F

    override fun minus(other: Vector4<Float>): Vector4F

    override fun times(scalar: Float): Vector4F

    override fun div(scalar: Float): Vector4F

    override fun copy(): Vector4F

    override fun mutableCopy(): MutableVector4F

    override fun position(): Position4F

    override fun position(origin: Position4<Float>): Position4F

    override fun mutablePosition(): MutablePosition4F

    override fun mutablePosition(origin: Position4<Float>): MutablePosition4F

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Float, y: Float, z: Float, w: Float): Vector4F {
            return MutableVector4F(x, y, z, w)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Float): Vector4F {
            return MutableVector4F(value, value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector4F {
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
        public fun random(from: Float, until: Float): Vector4F {
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
        public fun random(from: Vector4<Float>, until: Vector4<Float>): Vector4F {
            return MutableVector4F(
                Random.nextFloat() * (until.x - from.x) + from.x,
                Random.nextFloat() * (until.y - from.y) + from.y,
                Random.nextFloat() * (until.z - from.z) + from.z,
                Random.nextFloat() * (until.w - from.w) + from.w,
            )
        }
    }
}
