package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4
import net.voxelpi.voxlib.math.position.Position4

/**
 * A vector in a generic 4 dimensional vector space.
 */
public interface Vector4<T : Number> {

    public val x: T

    public val y: T

    public val z: T

    public val w: T

    public operator fun component1(): T = x

    public operator fun component2(): T = y

    public operator fun component3(): T = z

    public operator fun component4(): T = z

    public operator fun unaryMinus(): Vector4<T>

    public operator fun unaryPlus(): Vector4<T>

    public operator fun plus(other: Vector4<T>): Vector4<T>

    public operator fun minus(other: Vector4<T>): Vector4<T>

    public operator fun times(scalar: T): Vector4<T>

    public operator fun div(scalar: T): Vector4<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    public infix fun dot(other: Vector4<T>): T

    /**
     * Creates an immutable copy of the vector.
     */
    public fun copy(): Vector4<T>

    /**
     * Creates a mutable copy of the vector.
     */
    public fun mutableCopy(): MutableVector4<T>

    /**
     * Returns a new position that is offset from the origin 0 by the current value of the vector.
     */
    public fun position(): Position4<T>

    /**
     * Returns a new position that is offset from the given [origin] by the current value of the vector.
     */
    public fun position(origin: Position4<T>): Position4<T>

    /**
     * Returns a new mutable position that is offset from the origin 0 by the current value of the vector.
     */
    public fun mutablePosition(): MutablePosition4<T>

    /**
     * Returns a new mutable position that is offset from the given [origin] by the current value of the vector.
     */
    public fun mutablePosition(origin: Position4<T>): MutablePosition4<T>

    /**
     * Returns the value of this vector as a Vector4D, which may involve rounding.
     */
    public fun toDouble(): Vector4D {
        return MutableVector4D(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
    }

    /**
     * Returns the value of this vector as a Vector4F, which may involve rounding.
     */
    public fun toFloat(): Vector4F {
        return MutableVector4F(x.toFloat(), y.toFloat(), z.toFloat(), z.toFloat())
    }

    /**
     * Returns the value of this vector as a Vector4I, which may involve rounding or truncation.
     */
    public fun toInt(): Vector4I {
        return MutableVector4I(x.toInt(), y.toInt(), z.toInt(), w.toInt())
    }
}
