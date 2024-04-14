package net.voxelpi.voxlib.math.vector

/**
 * A vector in a 2-dimensional vector space.
 */
public interface MutableVector2<T> : Vector2<T> where T : Number, T : Comparable<T> {

    override var x: T

    override var y: T

    public operator fun plusAssign(other: Vector2<T>)

    public operator fun minusAssign(other: Vector2<T>)

    public operator fun timesAssign(scalar: T)

    public operator fun divAssign(scalar: T)

    /**
     * Sets all elements of the vector to corresponding elements of [value].
     */
    public fun set(value: Vector2<T>)

    /**
     * Sets all elements of the vector to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutableVector2D {
        return MutableVector2D(x.toDouble(), y.toDouble())
    }

    override fun toFloat(): MutableVector2F {
        return MutableVector2F(x.toFloat(), y.toFloat())
    }

    override fun toInt(): MutableVector2I {
        return MutableVector2I(x.toInt(), y.toInt())
    }
}
