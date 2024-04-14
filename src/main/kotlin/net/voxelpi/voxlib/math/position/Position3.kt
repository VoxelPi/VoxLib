package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.aabb.AABB3
import net.voxelpi.voxlib.math.vector.MutableVector3
import net.voxelpi.voxlib.math.vector.Vector3

/**
 * A position in a 3-dimensional space.
 */
public interface Position3<T> where T : Number, T : Comparable<T> {

    public val x: T

    public val y: T

    public val z: T

    public operator fun component1(): T = x

    public operator fun component2(): T = y

    public operator fun component3(): T = z

    public operator fun plus(other: Vector3<T>): Position3<T>

    public operator fun minus(other: Vector3<T>): Position3<T>

    public operator fun minus(other: Position3<T>): Vector3<T>

    /**
     * Returns a vector that points from this position to the given [position].
     */
    public infix fun to(position: Position3<T>): Vector3<T>

    /**
     * Returns a new position that is relative to given [position].
     */
    public fun relativeTo(position: Position3<T>): Position3<T>

    /**
     * Returns a new position that is relative to the min corner of the given [aabb].
     */
    public fun relativeTo(aabb: AABB3<T>): Position3<T>

    /**
     * Creates an immutable copy of the position.
     */
    public fun copy(): Position3<T>

    /**
     * Creates a mutable copy of the position.
     */
    public fun mutableCopy(): MutablePosition3<T>

    /**
     * Returns the offset from the origin as vector.
     */
    public fun vector(): Vector3<T>

    /**
     * Returns the offset from the origin as mutable vector.
     */
    public fun mutableVector(): MutableVector3<T>

    /**
     * Returns the value of this position as a Position3D, which may involve rounding.
     */
    public fun toDouble(): Position3D {
        return MutablePosition3D(x.toDouble(), y.toDouble(), z.toDouble())
    }

    /**
     * Returns the value of this position as a Position3F, which may involve rounding.
     */
    public fun toFloat(): Position3F {
        return MutablePosition3F(x.toFloat(), y.toFloat(), z.toFloat())
    }

    /**
     * Returns the value of this position as a Position3I, which may involve rounding or truncation.
     */
    public fun toInt(): Position3I {
        return MutablePosition3I(x.toInt(), y.toInt(), z.toInt())
    }
}
