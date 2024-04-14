package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3
import net.voxelpi.voxlib.math.position.Position3

/**
 * A vector in a 3-dimensional vector space.
 */
public interface Vector3<T> where T : Number, T : Comparable<T> {

    public val x: T

    public val y: T

    public val z: T

    public operator fun component1(): T = x

    public operator fun component2(): T = y

    public operator fun component3(): T = z

    public operator fun unaryMinus(): Vector3<T>

    public operator fun unaryPlus(): Vector3<T>

    public operator fun plus(other: Vector3<T>): Vector3<T>

    public operator fun minus(other: Vector3<T>): Vector3<T>

    public operator fun times(scalar: T): Vector3<T>

    public operator fun div(scalar: T): Vector3<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    public infix fun dot(other: Vector3<T>): T

    /**
     * Creates an immutable copy of the vector.
     */
    public fun copy(): Vector3<T>

    /**
     * Creates a mutable copy of the vector.
     */
    public fun mutableCopy(): MutableVector3<T>

    /**
     * Returns a new position that is offset from the origin 0 by the current value of the vector.
     */
    public fun position(): Position3<T>

    /**
     * Returns a new position that is offset from the given [origin] by the current value of the vector.
     */
    public fun position(origin: Position3<T>): Position3<T>

    /**
     * Returns a new mutable position that is offset from the origin 0 by the current value of the vector.
     */
    public fun mutablePosition(): MutablePosition3<T>

    /**
     * Returns a new mutable position that is offset from the given [origin] by the current value of the vector.
     */
    public fun mutablePosition(origin: Position3<T>): MutablePosition3<T>

    /**
     * Returns the value of this vector as a Vector3D, which may involve rounding.
     */
    public fun toDouble(): Vector3D {
        return MutableVector3D(x.toDouble(), y.toDouble(), z.toDouble())
    }

    /**
     * Returns the value of this vector as a Vector3F, which may involve rounding.
     */
    public fun toFloat(): Vector3F {
        return MutableVector3F(x.toFloat(), y.toFloat(), z.toFloat())
    }

    /**
     * Returns the value of this vector as a Vector3I, which may involve rounding or truncation.
     */
    public fun toInt(): Vector3I {
        return MutableVector3I(x.toInt(), y.toInt(), z.toInt())
    }
}
