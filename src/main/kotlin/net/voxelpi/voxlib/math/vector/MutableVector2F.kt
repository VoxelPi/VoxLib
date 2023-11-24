package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2F
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2F
import net.voxelpi.voxlib.math.position.mutablePosition2F
import net.voxelpi.voxlib.math.position.position2F
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector2F(
    override var x: Float,
    override var y: Float,
) : Vector2F, MutableVector2<Float> {

    override fun plusAssign(other: Vector2<Float>) {
        x += other.x
        y += other.y
    }

    override fun minusAssign(other: Vector2<Float>) {
        x -= other.x
        y -= other.y
    }

    override fun timesAssign(scalar: Float) {
        x *= scalar
        y *= scalar
    }

    override fun divAssign(scalar: Float) {
        x /= scalar
        y /= scalar
    }

    override fun set(value: Vector2<Float>) {
        x = value.x
        y = value.y
    }

    override fun set(value: Float) {
        x = value
        y = value
    }

    override fun unaryMinus(): MutableVector2F {
        return MutableVector2F(-x, -y)
    }

    override fun unaryPlus(): MutableVector2F {
        return MutableVector2F(+x, +y)
    }

    override fun plus(other: Vector2<Float>): MutableVector2F {
        return MutableVector2F(x + other.x, y + other.y)
    }

    override fun minus(other: Vector2<Float>): MutableVector2F {
        return MutableVector2F(x - other.x, y - other.y)
    }

    override fun times(scalar: Float): MutableVector2F {
        return MutableVector2F(x * scalar, y * scalar)
    }

    override fun div(scalar: Float): MutableVector2F {
        return MutableVector2F(x / scalar, y / scalar)
    }

    override fun dot(other: Vector2<Float>): Float {
        return x * other.x + y * other.y
    }

    override fun copy(): Vector2F {
        return MutableVector2F(x, y)
    }

    override fun mutableCopy(): MutableVector2F {
        return MutableVector2F(x, y)
    }

    override fun position(): Position2F {
        return position2F(x, y)
    }

    override fun position(origin: Position2<Float>): Position2F {
        return position2F(origin.x + x, origin.y + y)
    }

    override fun mutablePosition(): MutablePosition2F {
        return mutablePosition2F(x, y)
    }

    override fun mutablePosition(origin: Position2<Float>): MutablePosition2F {
        return mutablePosition2F(origin.x + x, origin.y + y)
    }

    override fun length(): Float {
        return sqrt(x * x + y * y)
    }

    override fun lengthSquared(): Float {
        return x * x + y * y
    }

    override fun normalized(): Vector2F {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVector2F {
        this /= length()
        return this
    }

    override fun angle(): Float {
        return atan2(y, x)
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Float, y: Float): MutableVector2F {
            return MutableVector2F(x, y)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Float): MutableVector2F {
            return MutableVector2F(value, value)
        }

        /**
         * Returns a new vector with the given polar coordinates.
         */
        public fun polar(r: Float, phi: Float): MutableVector2F {
            return MutableVector2F(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector2F {
            return MutableVector2F(Random.nextFloat(), Random.nextFloat())
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Float, until: Float): MutableVector2F {
            return MutableVector2F(
                Random.nextFloat() * (until - from) + from,
                Random.nextFloat() * (until - from) + from,
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector2<Float>, until: Vector2<Float>): MutableVector2F {
            return MutableVector2F(
                Random.nextFloat() * (until.x - from.x) + from.x,
                Random.nextFloat() * (until.y - from.y) + from.y,
            )
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideCircle(radius: Float = 1F): MutableVector2F {
            val phi = Random.nextFloat() * 2F * PI.toFloat()
            val r = radius * sqrt(Random.nextFloat())
            return MutableVector2F(r * cos(phi), r * sin(phi))
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnCircle(radius: Float = 1F): MutableVector2F {
            val phi = Random.nextFloat() * 2F * PI.toFloat()
            return MutableVector2F(radius * cos(phi), radius * sin(phi))
        }
    }
}
