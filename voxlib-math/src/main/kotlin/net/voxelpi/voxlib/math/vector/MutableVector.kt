package net.voxelpi.voxlib.math.vector

interface MutableVector<T : Number> : Vector<T> {

    operator fun set(index: Int, value: T)


    operator fun plusAssign(other: Vector<T>)

    operator fun minusAssign(other: Vector<T>)

    operator fun timesAssign(scalar: T)

    operator fun divAssign(scalar: T)


    /**
     * Sets all elements of the vector to corresponding elements of [value].
     */
    fun set(value: Vector<T>)

    /**
     * Sets all elements of the vector to [value].
     */
    fun set(value: T)

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
