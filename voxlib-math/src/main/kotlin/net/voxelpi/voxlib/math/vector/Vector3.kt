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
}
