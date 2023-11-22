package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2I
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2I
import net.voxelpi.voxlib.math.position.mutablePosition2I
import net.voxelpi.voxlib.math.position.position2I
import kotlin.math.sqrt

public data class MutableVector2I(
    override var x: Int,
    override var y: Int,
) : Vector2I, MutableVector2<Int> {

    override fun plusAssign(other: Vector2<Int>) {
        x += other.x
        y += other.y
    }

    override fun minusAssign(other: Vector2<Int>) {
        x -= other.x
        y -= other.y
    }

    override fun timesAssign(scalar: Int) {
        x *= scalar
        y *= scalar
    }

    override fun divAssign(scalar: Int) {
        x /= scalar
        y /= scalar
    }

    override fun set(value: Vector2<Int>) {
        x = value.x
        y = value.y
    }

    override fun set(value: Int) {
        x = value
        y = value
    }

    override fun unaryMinus(): MutableVector2I {
        return MutableVector2I(-x, -y)
    }

    override fun unaryPlus(): MutableVector2I {
        return MutableVector2I(+x, +y)
    }

    override fun plus(other: Vector2<Int>): MutableVector2I {
        return MutableVector2I(x + other.x, y + other.y)
    }

    override fun minus(other: Vector2<Int>): MutableVector2I {
        return MutableVector2I(x - other.x, y - other.y)
    }

    override fun times(scalar: Int): MutableVector2I {
        return MutableVector2I(x * scalar, y * scalar)
    }

    override fun div(scalar: Int): MutableVector2I {
        return MutableVector2I(x / scalar, y / scalar)
    }

    override fun dot(other: Vector2<Int>): Int {
        return x * other.x + y * other.y
    }

    override fun copy(): Vector2I {
        return MutableVector2I(x, y)
    }

    override fun mutableCopy(): MutableVector2I {
        return MutableVector2I(x, y)
    }

    override fun position(): Position2I {
        return position2I(x, y)
    }

    override fun position(origin: Position2<Int>): Position2I {
        return position2I(origin.x + x, origin.y + y)
    }

    override fun mutablePosition(): MutablePosition2I {
        return mutablePosition2I(x, y)
    }

    override fun mutablePosition(origin: Position2<Int>): MutablePosition2I {
        return mutablePosition2I(origin.x + x, origin.y + y)
    }

    override fun length(): Double {
        return sqrt((x * x + y * y).toDouble())
    }

    override fun lengthSquared(): Int {
        return x * x + y * y
    }

    override fun normalized(): Vector2D {
        return this.toDouble() / length()
    }
}
