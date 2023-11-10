package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector2

/**
 * A position in a 2 dimensional space.
 */
public interface MutablePosition2<T : Number> : Position2<T> {

    override var x: T

    override var y: T

    public operator fun plusAssign(other: Vector2<T>)

    public operator fun minusAssign(other: Vector2<T>)

    /**
     * Sets all elements of the position to corresponding elements of [value].
     */
    public fun set(value: Position2<T>)

    /**
     * Sets all elements of the position to [value].
     */
    public fun set(value: T)

    override fun toDouble(): MutablePosition2D {
        return MutablePosition2D(x.toDouble(), y.toDouble())
    }

    override fun toFloat(): MutablePosition2F {
        return MutablePosition2F(x.toFloat(), y.toFloat())
    }

    override fun toInt(): MutablePosition2I {
        return MutablePosition2I(x.toInt(), y.toInt())
    }
}
