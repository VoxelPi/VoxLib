package net.voxelpi.voxlib.math.vector

import kotlin.math.sqrt

public data class MutableVector2F(
    override var x: Float,
    override var y: Float,
): Vector2F, MutableVector2<Float> {

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


    override fun length(): Float {
        return sqrt(x*x + y*y)
    }

    override fun lengthSquared(): Float {
        return x*x + y*y
    }
}
