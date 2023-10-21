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
}
