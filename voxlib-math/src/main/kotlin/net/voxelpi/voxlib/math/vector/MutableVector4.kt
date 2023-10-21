package net.voxelpi.voxlib.math.vector

interface MutableVector4<T : Number> : Vector4<T> {

    override var x: T

    override var y: T

    override var z: T

    override var w: T


    operator fun plusAssign(other: Vector4<T>)

    operator fun minusAssign(other: Vector4<T>)

    operator fun timesAssign(scalar: T)

    operator fun divAssign(scalar: T)


    fun set(value: Vector4<T>)

    fun set(value: T)

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
