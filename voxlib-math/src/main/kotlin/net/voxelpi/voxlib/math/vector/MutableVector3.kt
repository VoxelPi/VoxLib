package net.voxelpi.voxlib.math.vector

interface MutableVector3<T : Number> : Vector3<T> {

    override var x: T

    override var y: T

    override var z: T


    operator fun plusAssign(other: Vector3<T>)

    operator fun minusAssign(other: Vector3<T>)

    operator fun timesAssign(scalar: T)

    operator fun divAssign(scalar: T)


    fun set(value: Vector3<T>)

    fun set(value: T)

    override fun toDouble(): MutableVector3D {
        return MutableVector3D(x.toDouble(), y.toDouble(), z.toDouble())
    }

    override fun toFloat(): MutableVector3F {
        return MutableVector3F(x.toFloat(), y.toFloat(), z.toFloat())
    }

    override fun toInt(): MutableVector3I {
        return MutableVector3I(x.toInt(), y.toInt(), z.toInt())
    }
}
