package net.voxelpi.voxlib.math.vector

/**
 * A vector in a generic n dimensional vector space.
 */
interface Vector<T : Number> : Collection<T> {

    /**
     * Returns the [index] element of the vector.
     */
    operator fun get(index: Int): T

    /**
     * Returns the range of valid indices for the vector.
     */
    val indices: IntRange


    operator fun unaryMinus(): Vector<T>

    operator fun unaryPlus(): Vector<T>

    operator fun plus(other: Vector<T>): Vector<T>

    operator fun minus(other: Vector<T>): Vector<T>

    operator fun times(scalar: T): Vector<T>

    operator fun div(scalar: T): Vector<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    infix fun dot(other: Vector<T>): T


    /**
     * Creates an immutable copy of the vector.
     */
    fun copy(): Vector<T>

    /**
     * Creates a mutable copy of the vector.
     */
    fun mutableCopy(): MutableVector<T>

    /**
     * Returns the value of this vector as a Vector3D, which may involve rounding.
     */
    fun toDouble(): VectorD {
        return MutableVectorD(size) { index ->
            this[index].toDouble()
        }
    }

    /**
     * Returns the value of this vector as a Vector3I, which may involve rounding or truncation.
     */
    fun toInt(): VectorI {
        return MutableVectorI(size) { index ->
            this[index].toInt()
        }
    }
}
