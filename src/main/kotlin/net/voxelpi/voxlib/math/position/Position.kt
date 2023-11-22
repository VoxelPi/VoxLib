package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector
import net.voxelpi.voxlib.math.vector.Vector

/**
 * A position in a n dimensional space.
 */
public interface Position<T : Number> : Collection<T> {

    /**
     * Returns the [index] element of the position.
     */
    public operator fun get(index: Int): T

    /**
     * Returns the range of valid indices for the position.
     */
    public val indices: IntRange

    public operator fun plus(other: Vector<T>): Position<T>

    public operator fun minus(other: Vector<T>): Position<T>

    public operator fun minus(other: Position<T>): Vector<T>

    /**
     * Returns a vector that points from this position to the given [position].
     */
    public infix fun to(position: Position<T>): Vector<T>

    /**
     * Creates an immutable copy of the position.
     */
    public fun copy(): Position<T>

    /**
     * Creates a mutable copy of the position.
     */
    public fun mutableCopy(): MutablePosition<T>

    /**
     * Returns the offset from the origin as vector.
     */
    public fun vector(): Vector<T>

    /**
     * Returns the offset from the origin as mutable vector.
     */
    public fun mutableVector(): MutableVector<T>

    /**
     * Returns the value of this position as a PositionD, which may involve rounding.
     */
    public fun toDouble(): PositionD {
        return MutablePositionD(size) { index ->
            this[index].toDouble()
        }
    }

    /**
     * Returns the value of this position as a PositionF, which may involve rounding.
     */
    public fun toFloat(): PositionF {
        return MutablePositionF(size) { index ->
            this[index].toFloat()
        }
    }

    /**
     * Returns the value of this position as a PositionI, which may involve rounding or truncation.
     */
    public fun toInt(): PositionI {
        return MutablePositionI(size) { index ->
            this[index].toInt()
        }
    }
}
