package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2I
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2I
import kotlin.random.Random

public interface Vector2I : Vector2<Int> {

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
    public fun normalized(): Vector2D

    /**
     * Returns the angle theta of the polar coordinates (r, theta) that correspond to the rectangular coordinates (x, y).
     */
    public fun angle(): Double

    override fun unaryMinus(): Vector2I

    override fun unaryPlus(): Vector2I

    override fun plus(other: Vector2<Int>): Vector2I

    override fun minus(other: Vector2<Int>): Vector2I

    override fun times(scalar: Int): Vector2I

    override fun div(scalar: Int): Vector2I

    override fun copy(): Vector2I

    override fun mutableCopy(): MutableVector2I

    override fun position(): Position2I

    override fun position(origin: Position2<Int>): Position2I

    override fun mutablePosition(): MutablePosition2I

    override fun mutablePosition(origin: Position2<Int>): MutablePosition2I

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Int, y: Int): Vector2I {
            return MutableVector2I(x, y)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Int): Vector2I {
            return MutableVector2I(value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector2I {
            return MutableVector2I(Random.nextInt(), Random.nextInt())
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Int, until: Int): Vector2I {
            return MutableVector2I(Random.nextInt(from, until), Random.nextInt(from, until))
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector2<Int>, until: Vector2<Int>): Vector2I {
            return MutableVector2I(Random.nextInt(from.x, until.x), Random.nextInt(from.y, until.y))
        }
    }
}
