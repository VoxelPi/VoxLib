package net.voxelpi.voxlib.math.vector

interface Vector3I : Vector3<Int> {

    fun length(): Double

    fun lengthSquared(): Int


    override fun unaryMinus(): Vector3I

    override fun unaryPlus(): Vector3I

    override fun plus(other: Vector3<Int>): Vector3I

    override fun minus(other: Vector3<Int>): Vector3I

    override fun times(scalar: Int): Vector3I

    override fun div(scalar: Int): Vector3I


    override fun copy(): Vector3I

    override fun mutableCopy(): MutableVector3I
}
