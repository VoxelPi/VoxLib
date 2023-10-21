package net.voxelpi.voxlib.math.vector

interface MutableVector2<T : Number> : Vector2<T> {

    override var x: T

    override var y: T


    operator fun plusAssign(other: Vector2<T>)

    operator fun minusAssign(other: Vector2<T>)

    operator fun timesAssign(scalar: T)

    operator fun divAssign(scalar: T)


    fun set(value: Vector2<T>)

    fun set(value: T)

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
