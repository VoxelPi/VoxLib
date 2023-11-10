package net.voxelpi.voxlib.math.vector

import kotlin.math.sqrt

public data class MutableVector2D(
    override var x: Double,
    override var y: Double,
): Vector2D, MutableVector2<Double> {

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


    override fun length(): Double {
        return sqrt(x*x + y*y)
    }

    override fun lengthSquared(): Double {
        return x*x + y*y
    }
}