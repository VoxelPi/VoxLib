package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition
import net.voxelpi.voxlib.math.position.Position

/**
 * A vector in a generic n dimensional vector space.
 */
public interface Vector<T : Number> : Collection<T> {

    /**
     * Returns the [index] element of the vector.
     */
    public operator fun get(index: Int): T

    /**
     * Returns the range of valid indices for the vector.
     */
    public val indices: IntRange

    public operator fun unaryMinus(): Vector<T>

    public operator fun unaryPlus(): Vector<T>

    public operator fun plus(other: Vector<T>): Vector<T>

    public operator fun minus(other: Vector<T>): Vector<T>

    public operator fun times(scalar: T): Vector<T>

    public operator fun div(scalar: T): Vector<T>

    /**
     * Calculates the dot product of the two vectors.
     */
    public infix fun dot(other: Vector<T>): T

    /**
     * Creates an immutable copy of the vector.
     */
    public fun copy(): Vector<T>

    /**
     * Creates a mutable copy of the vector.
     */
    public fun mutableCopy(): MutableVector<T>

    /**
     * Returns a new position that is offset from the origin 0 by the current value of the vector.
     */
    public fun position(): Position<T>

    /**
     * Returns a new position that is offset from the given [origin] by the current value of the vector.
     */
    public fun position(origin: Position<T>): Position<T>

    /**
     * Returns a new mutable position that is offset from the origin 0 by the current value of the vector.
     */
    public fun mutablePosition(): MutablePosition<T>

    /**
     * Returns a new mutable position that is offset from the given [origin] by the current value of the vector.
     */
    public fun mutablePosition(origin: Position<T>): MutablePosition<T>

    /**
     * Returns the value of this vector as a VectorD, which may involve rounding.
     */
    public fun toDouble(): VectorD {
        return MutableVectorD(size) { index ->
            this[index].toDouble()
        }
    }

    /**
     * Returns the value of this vector as a VectorF, which may involve rounding.
     */
    public fun toFloat(): VectorF {
        return MutableVectorF(size) { index ->
            this[index].toFloat()
        }
    }

    /**
     * Returns the value of this vector as a VectorI, which may involve rounding or truncation.
     */
    public fun toInt(): VectorI {
        return MutableVectorI(size) { index ->
            this[index].toInt()
        }
    }
}
