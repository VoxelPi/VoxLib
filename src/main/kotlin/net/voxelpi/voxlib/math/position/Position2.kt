package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.aabb.AABB2
import net.voxelpi.voxlib.math.vector.MutableVector2
import net.voxelpi.voxlib.math.vector.Vector2

/**
 * A position in a 2-dimensional space.
 */
public interface Position2<T> where T : Number, T : Comparable<T> {

    public val x: T

    public val y: T

    public operator fun component1(): T = x

    public operator fun component2(): T = y

    public operator fun plus(other: Vector2<T>): Position2<T>

    public operator fun minus(other: Vector2<T>): Position2<T>

    public operator fun minus(other: Position2<T>): Vector2<T>

    /**
     * Returns a vector that points from this position to the given [position].
     */
    public infix fun to(position: Position2<T>): Vector2<T>

    /**
     * Returns a new position that is relative to given [position].
     */
    public fun relativeTo(position: Position2<T>): Position2<T>

    /**
     * Returns a new position that is relative to the min corner of the given [aabb].
     */
    public fun relativeTo(aabb: AABB2<T>): Position2<T>

    /**
     * Creates an immutable copy of the position.
     */
    public fun copy(): Position2<T>

    /**
     * Creates a mutable copy of the position.
     */
    public fun mutableCopy(): MutablePosition2<T>

    /**
     * Returns the offset from the origin as vector.
     */
    public fun vector(): Vector2<T>

    /**
     * Returns the offset from the origin as mutable vector.
     */
    public fun mutableVector(): MutableVector2<T>

    /**
     * Returns the value of this position as a Position2D, which may involve rounding.
     */
    public fun toDouble(): Position2D {
        return MutablePosition2D(x.toDouble(), y.toDouble())
    }

    /**
     * Returns the value of this position as a Position2F, which may involve rounding.
     */
    public fun toFloat(): Position2F {
        return MutablePosition2F(x.toFloat(), y.toFloat())
    }

    /**
     * Returns the value of this position as a Position2I, which may involve rounding or truncation.
     */
    public fun toInt(): Position2I {
        return MutablePosition2I(x.toInt(), y.toInt())
    }
}
