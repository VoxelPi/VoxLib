package net.voxelpi.voxlib.math.vector

/**
 * A vector in a generic 3 dimensional vector space.
 */
interface Vector3<T : Number> {

    val x: T

    val y: T

    val z: T

    operator fun component1(): T = x

    operator fun component2(): T = y

    operator fun component3(): T = z


    operator fun unaryMinus(): Vector3<T>

    operator fun unaryPlus(): Vector3<T>

    operator fun plus(other: Vector3<T>): Vector3<T>

    operator fun minus(other: Vector3<T>): Vector3<T>

    operator fun times(scalar: T): Vector3<T>

    operator fun div(scalar: T): Vector3<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    infix fun dot(other: Vector3<T>): T


    /**
     * Creates an immutable copy of the vector.
     */
    fun copy(): Vector3<T>

    /**
     * Creates a mutable copy of the vector.
     */
    fun mutableCopy(): MutableVector3<T>

    /**
     * Returns the value of this vector as a Vector3D, which may involve rounding.
     */
    fun toDouble(): Vector3D {
        return MutableVector3D(x.toDouble(), y.toDouble(), z.toDouble())
    }

    /**
     * Returns the value of this vector as a Vector3I, which may involve rounding or truncation.
     */
    fun toInt(): Vector3I {
        return MutableVector3I(x.toInt(), y.toInt(), z.toInt())
    }
}
