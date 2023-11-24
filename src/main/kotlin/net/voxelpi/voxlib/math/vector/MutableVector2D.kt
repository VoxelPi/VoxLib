package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2D
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2D
import net.voxelpi.voxlib.math.position.mutablePosition2D
import net.voxelpi.voxlib.math.position.position2D
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector2D(
    override var x: Double,
    override var y: Double,
) : Vector2D, MutableVector2<Double> {

    override fun plusAssign(other: Vector2<Double>) {
        x += other.x
        y += other.y
    }

    override fun minusAssign(other: Vector2<Double>) {
        x -= other.x
        y -= other.y
    }

    override fun timesAssign(scalar: Double) {
        x *= scalar
        y *= scalar
    }

    override fun divAssign(scalar: Double) {
        x /= scalar
        y /= scalar
    }

    override fun set(value: Vector2<Double>) {
        x = value.x
        y = value.y
    }

    override fun set(value: Double) {
        x = value
        y = value
    }

    override fun unaryMinus(): MutableVector2D {
        return MutableVector2D(-x, -y)
    }

    override fun unaryPlus(): MutableVector2D {
        return MutableVector2D(+x, +y)
    }

    override fun plus(other: Vector2<Double>): MutableVector2D {
        return MutableVector2D(x + other.x, y + other.y)
    }

    override fun minus(other: Vector2<Double>): MutableVector2D {
        return MutableVector2D(x - other.x, y - other.y)
    }

    override fun times(scalar: Double): MutableVector2D {
        return MutableVector2D(x * scalar, y * scalar)
    }

    override fun div(scalar: Double): MutableVector2D {
        return MutableVector2D(x / scalar, y / scalar)
    }

    override fun dot(other: Vector2<Double>): Double {
        return x * other.x + y * other.y
    }

    override fun copy(): Vector2D {
        return MutableVector2D(x, y)
    }

    override fun mutableCopy(): MutableVector2D {
        return MutableVector2D(x, y)
    }

    override fun position(): Position2D {
        return position2D(x, y)
    }

    override fun position(origin: Position2<Double>): Position2D {
        return position2D(origin.x + x, origin.y + y)
    }

    override fun mutablePosition(): MutablePosition2D {
        return mutablePosition2D(x, y)
    }

    override fun mutablePosition(origin: Position2<Double>): MutablePosition2D {
        return mutablePosition2D(origin.x + x, origin.y + y)
    }

    override fun length(): Double {
        return sqrt(x * x + y * y)
    }

    override fun lengthSquared(): Double {
        return x * x + y * y
    }

    override fun normalized(): Vector2D {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVector2D {
        this /= length()
        return this
    }

    override fun angle(): Double {
        return atan2(y, x)
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Double, y: Double): MutableVector2D {
            return MutableVector2D(x, y)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Double): MutableVector2D {
            return MutableVector2D(value, value)
        }

        /**
         * Returns a new vector with the given polar coordinates.
         */
        public fun polar(r: Double, phi: Double): MutableVector2D {
            return MutableVector2D(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector2D {
            return MutableVector2D(Random.nextDouble(), Random.nextDouble())
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Double, until: Double): MutableVector2D {
            return MutableVector2D(Random.nextDouble(from, until), Random.nextDouble(from, until))
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector2<Double>, until: Vector2<Double>): MutableVector2D {
            return MutableVector2D(Random.nextDouble(from.x, until.x), Random.nextDouble(from.y, until.y))
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideCircle(radius: Double = 1.0): MutableVector2D {
            val phi = Random.nextDouble() * 2 * PI
            val r = radius * sqrt(Random.nextDouble())
            return MutableVector2D(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnCircle(radius: Double = 1.0): MutableVector2D {
            val phi = Random.nextDouble() * 2 * PI
            return MutableVector2D(radius * cos(phi), radius * sin(phi))
        }
    }
}
