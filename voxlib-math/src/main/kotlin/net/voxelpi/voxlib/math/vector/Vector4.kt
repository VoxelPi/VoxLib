package net.voxelpi.voxlib.math.vector

/**
 * A vector in a generic 4 dimensional vector space.
 */
interface Vector4<T : Number> {

    val x: T

    val y: T

    val z: T

    val w: T

    operator fun component1(): T = x

    operator fun component2(): T = y

    operator fun component3(): T = z

    operator fun component4(): T = z


    operator fun unaryMinus(): Vector4<T>

    operator fun unaryPlus(): Vector4<T>

    operator fun plus(other: Vector4<T>): Vector4<T>

    operator fun minus(other: Vector4<T>): Vector4<T>

    operator fun times(scalar: T): Vector4<T>

    operator fun div(scalar: T): Vector4<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    infix fun dot(other: Vector4<T>): T


    /**
     * Creates an immutable copy of the vector.
     */
    fun copy(): Vector4<T>

    /**
     * Creates a mutable copy of the vector.
     */
    fun mutableCopy(): MutableVector4<T>

    /**
     * Returns the value of this vector as a Vector4D, which may involve rounding.
     */
    fun toDouble(): Vector4D {
        return MutableVector4D(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
    }

    /**
     * Returns the value of this vector as a Vector4F, which may involve rounding.
     */
    fun toFloat(): Vector4F {
        return MutableVector4F(x.toFloat(), y.toFloat(), z.toFloat(), z.toFloat())
    }

    /**
     * Returns the value of this vector as a Vector4I, which may involve rounding or truncation.
     */
    fun toInt(): Vector4I {
        return MutableVector4I(x.toInt(), y.toInt(), z.toInt(), w.toInt())
    }
}
