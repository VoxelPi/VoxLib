package net.voxelpi.voxlib.math.vector

/**
 * A vector in a generic 2 dimensional vector space.
 */
interface Vector2<T : Number> {

    val x: T

    val y: T

    operator fun component1(): T = x

    operator fun component2(): T = y


    operator fun unaryMinus(): Vector2<T>

    operator fun unaryPlus(): Vector2<T>

    operator fun plus(other: Vector2<T>): Vector2<T>

    operator fun minus(other: Vector2<T>): Vector2<T>

    operator fun times(scalar: T): Vector2<T>

    operator fun div(scalar: T): Vector2<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    infix fun dot(other: Vector2<T>): T


    /**
     * Creates an immutable copy of the vector.
     */
    fun copy(): Vector2<T>

    /**
     * Creates a mutable copy of the vector.
     */
    fun mutableCopy(): MutableVector2<T>

    /**
     * Returns the value of this vector as a Vector3D, which may involve rounding.
     */
    fun toDouble(): Vector2D {
        return MutableVector2D(x.toDouble(), y.toDouble())
    }

    /**
     * Returns the value of this vector as a Vector3I, which may involve rounding or truncation.
     */
    fun toInt(): Vector2I {
        return MutableVector2I(x.toInt(), y.toInt())
    }
}
