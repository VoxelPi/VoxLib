package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2F
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2F
import net.voxelpi.voxlib.math.position.mutablePosition2F
import net.voxelpi.voxlib.math.position.position2F
import kotlin.math.sqrt

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
}
