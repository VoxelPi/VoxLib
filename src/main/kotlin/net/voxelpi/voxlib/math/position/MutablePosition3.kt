package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector3

/**
 * A position in a 3-dimensional space.
 */
public interface MutablePosition3<T> : Position3<T> where T : Number, T : Comparable<T> {

    override var x: T

    override var y: T

    override var z: T

    public operator fun plusAssign(other: Vector3<T>)

    public operator fun minusAssign(other: Vector3<T>)

    /**
     * Sets all elements of the position to corresponding elements of [value].
     */
    public fun set(value: Position3<T>)

    /**
     * Sets all elements of the position to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutablePosition3D {
        return MutablePosition3D(x.toDouble(), y.toDouble(), z.toDouble())
    }

    override fun toFloat(): MutablePosition3F {
        return MutablePosition3F(x.toFloat(), y.toFloat(), z.toFloat())
    }

    override fun toInt(): MutablePosition3I {
        return MutablePosition3I(x.toInt(), y.toInt(), z.toInt())
    }
}
