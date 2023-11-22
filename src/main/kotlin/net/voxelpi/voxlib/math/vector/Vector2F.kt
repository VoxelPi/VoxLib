package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2F
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2F
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

public interface Vector2F : Vector2<Float> {

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
    public fun normalized(): Vector2F

    /**
     * Returns the angle theta of the polar coordinates (r, theta) that correspond to the rectangular coordinates (x, y).
     */
    public fun angle(): Float

    override fun unaryMinus(): Vector2F

    override fun unaryPlus(): Vector2F

    override fun plus(other: Vector2<Float>): Vector2F

    override fun minus(other: Vector2<Float>): Vector2F

    override fun times(scalar: Float): Vector2F

    override fun div(scalar: Float): Vector2F

    override fun copy(): Vector2F

    override fun mutableCopy(): MutableVector2F

    override fun position(): Position2F

    override fun position(origin: Position2<Float>): Position2F

    override fun mutablePosition(): MutablePosition2F

    override fun mutablePosition(origin: Position2<Float>): MutablePosition2F

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Float, y: Float): Vector2F {
            return MutableVector2F(x, y)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Float): Vector2F {
            return MutableVector2F(value, value)
        }

        /**
         * Returns a new vector with the given polar coordinates.
         */
        public fun polar(r: Float, phi: Float): Vector2F {
            return MutableVector2F(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector2F {
            return MutableVector2F(Random.nextFloat(), Random.nextFloat())
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Float, until: Float): Vector2F {
            return MutableVector2F(
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector2<Float>, until: Vector2<Float>): Vector2F {
            return MutableVector2F(
                Random.nextFloat() * (until.x - from.x) + from.x,
                Random.nextFloat() * (until.y - from.y) + from.y,
            )
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideCircle(radius: Float = 1F): Vector2F {
            val phi = Random.nextFloat() * 2F * PI.toFloat()
            val r = radius * sqrt(Random.nextFloat())
            return MutableVector2F(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnCircle(radius: Float = 1F): Vector2F {
            val phi = Random.nextFloat() * 2F * PI.toFloat()
            return MutableVector2F(cos(phi), sin(phi))
        }
    }
}
