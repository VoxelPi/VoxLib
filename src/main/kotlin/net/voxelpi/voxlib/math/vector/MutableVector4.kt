package net.voxelpi.voxlib.math.vector

/**
 * A vector in a 4-dimensional vector space.
 */
public interface MutableVector4<T> : Vector4<T> where T : Number, T : Comparable<T> {

    override var x: T

    override var y: T

    override var z: T

    override var w: T

    public operator fun plusAssign(other: Vector4<T>)

    public operator fun minusAssign(other: Vector4<T>)

    public operator fun timesAssign(scalar: T)

    public operator fun divAssign(scalar: T)

    /**
     * Sets all elements of the vector to corresponding elements of [value].
     */
    public fun set(value: Vector4<T>)

    /**
     * Sets all elements of the vector to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutableVector4D {
        return MutableVector4D(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
    }

    override fun toFloat(): MutableVector4F {
        return MutableVector4F(x.toFloat(), y.toFloat(), z.toFloat(), w.toFloat())
    }

    override fun toInt(): MutableVector4I {
        return MutableVector4I(x.toInt(), y.toInt(), z.toInt(), w.toInt())
    }
}
