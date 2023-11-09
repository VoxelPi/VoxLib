package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector

/**
 * A mutable position in a n dimensional space.
 */
public interface MutablePosition<T : Number> : Position<T> {

    /**
     * Sets the [index] element of the position to the given [value].
     */
    public operator fun set(index: Int, value: T)


    public operator fun plusAssign(other: Vector<T>)

    public operator fun minusAssign(other: Vector<T>)


    /**
     * Sets all elements of the position to corresponding elements of [value].
     */
    public fun set(value: Position<T>)

    /**
     * Sets all elements of the position to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutablePositionD {
        return MutablePositionD(size) { index ->
            this[index].toDouble()
        }
    }

    override fun toFloat(): MutablePositionF {
        return MutablePositionF(size) { index ->
            this[index].toFloat()
        }
    }

    override fun toInt(): MutablePositionI {
        return MutablePositionI(size) { index ->
            this[index].toInt()
        }
    }
}
