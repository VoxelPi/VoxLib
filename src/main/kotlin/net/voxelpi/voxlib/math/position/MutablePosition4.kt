package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4

/**
 * A position in a 4-dimensional space.
 */
public interface MutablePosition4<T> : Position4<T> where T : Number, T : Comparable<T> {

    override var x: T

    override var y: T

    override var z: T

    override var w: T

    public operator fun plusAssign(other: Vector4<T>)

    public operator fun minusAssign(other: Vector4<T>)

    /**
     * Sets all elements of the position to corresponding elements of [value].
     */
    public fun set(value: Position4<T>)

    /**
     * Sets all elements of the position to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutablePosition4D {
        return MutablePosition4D(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
    }

    override fun toFloat(): MutablePosition4F {
        return MutablePosition4F(x.toFloat(), y.toFloat(), z.toFloat(), w.toFloat())
    }

    override fun toInt(): MutablePosition4I {
        return MutablePosition4I(x.toInt(), y.toInt(), z.toInt(), w.toInt())
    }
}
