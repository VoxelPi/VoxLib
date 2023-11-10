package net.voxelpi.voxlib.math.vector

/**
 * A mutable vector in a generic n dimensional vector space.
 */
public interface MutableVector<T : Number> : Vector<T> {

    /**
     * Sets the [index] element of the vector to the given [value].
     */
    public operator fun set(index: Int, value: T)

    public operator fun plusAssign(other: Vector<T>)

    public operator fun minusAssign(other: Vector<T>)

    public operator fun timesAssign(scalar: T)

    public operator fun divAssign(scalar: T)

    /**
     * Sets all elements of the vector to corresponding elements of [value].
     */
    public fun set(value: Vector<T>)

    /**
     * Sets all elements of the vector to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutableVectorD {
        return MutableVectorD(size) { index ->
            this[index].toDouble()
        }
    }

    override fun toFloat(): MutableVectorF {
        return MutableVectorF(size) { index ->
            this[index].toFloat()
        }
    }

    override fun toInt(): MutableVectorI {
        return MutableVectorI(size) { index ->
            this[index].toInt()
        }
    }
}
