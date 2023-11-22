package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2D
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2D
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

public interface Vector2D : Vector2<Double> {

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
    public fun normalized(): Vector2D

    /**
     * Returns the angle theta of the polar coordinates (r, theta) that correspond to the rectangular coordinates (x, y).
     */
    public fun angle(): Double

    override fun unaryMinus(): Vector2D

    override fun unaryPlus(): Vector2D

    override fun plus(other: Vector2<Double>): Vector2D

    override fun minus(other: Vector2<Double>): Vector2D

    override fun times(scalar: Double): Vector2D

    override fun div(scalar: Double): Vector2D

    override fun copy(): Vector2D

    override fun mutableCopy(): MutableVector2D

    override fun position(): Position2D

    override fun position(origin: Position2<Double>): Position2D

    override fun mutablePosition(): MutablePosition2D

    override fun mutablePosition(origin: Position2<Double>): MutablePosition2D

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Double, y: Double): Vector2D {
            return MutableVector2D(x, y)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Double): Vector2D {
            return MutableVector2D(value, value)
        }

        /**
         * Returns a new vector with the given polar coordinates.
         */
        public fun polar(r: Double, phi: Double): Vector2D {
            return MutableVector2D(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector.
         */
        public fun random(): Vector2D {
            return MutableVector2D(Random.nextDouble(), Random.nextDouble())
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Double, until: Double): Vector2D {
            return MutableVector2D(Random.nextDouble(from, until), Random.nextDouble(from, until))
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector2<Double>, until: Vector2<Double>): Vector2D {
            return MutableVector2D(Random.nextDouble(from.x, until.x), Random.nextDouble(from.y, until.y))
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideCircle(radius: Double = 1.0): Vector2D {
            val phi = Random.nextDouble() * 2 * PI
            val r = radius * sqrt(Random.nextDouble())
            return MutableVector2D(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnCircle(radius: Double = 1.0): Vector2D {
            val phi = Random.nextDouble() * 2 * PI
            return MutableVector2D(cos(phi), sin(phi))
        }
    }
}
