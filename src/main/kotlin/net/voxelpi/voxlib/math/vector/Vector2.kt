package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2
import net.voxelpi.voxlib.math.position.Position2

/**
 * A vector in a 2-dimensional vector space.
 */
public interface Vector2<T> where T : Number, T : Comparable<T> {

    public val x: T

    public val y: T

    public operator fun component1(): T = x

    public operator fun component2(): T = y

    public operator fun unaryMinus(): Vector2<T>

    public operator fun unaryPlus(): Vector2<T>

    public operator fun plus(other: Vector2<T>): Vector2<T>

    public operator fun minus(other: Vector2<T>): Vector2<T>

    public operator fun times(scalar: T): Vector2<T>

    public operator fun div(scalar: T): Vector2<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    public infix fun dot(other: Vector2<T>): T

    /**
     * Creates an immutable copy of the vector.
     */
    public fun copy(): Vector2<T>

    /**
     * Creates a mutable copy of the vector.
     */
    public fun mutableCopy(): MutableVector2<T>

    /**
     * Returns a new position that is offset from the origin 0 by the current value of the vector.
     */
    public fun position(): Position2<T>

    /**
     * Returns a new position that is offset from the given [origin] by the current value of the vector.
     */
    public fun position(origin: Position2<T>): Position2<T>

    /**
     * Returns a new mutable position that is offset from the origin 0 by the current value of the vector.
     */
    public fun mutablePosition(): MutablePosition2<T>

    /**
     * Returns a new mutable position that is offset from the given [origin] by the current value of the vector.
     */
    public fun mutablePosition(origin: Position2<T>): MutablePosition2<T>

    /**
     * Returns the value of this vector as a Vector2D, which may involve rounding.
     */
    public fun toDouble(): Vector2D {
        return MutableVector2D(x.toDouble(), y.toDouble())
    }

    /**
     * Returns the value of this vector as a Vector2F, which may involve rounding.
     */
    public fun toFloat(): Vector2F {
        return MutableVector2F(x.toFloat(), y.toFloat())
    }

    /**
     * Returns the value of this vector as a Vector2I, which may involve rounding or truncation.
     */
    public fun toInt(): Vector2I {
        return MutableVector2I(x.toInt(), y.toInt())
    }
}
