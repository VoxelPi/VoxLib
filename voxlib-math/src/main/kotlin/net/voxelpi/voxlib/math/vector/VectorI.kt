package net.voxelpi.voxlib.math.vector

interface VectorI : Vector<Int> {

    fun length(): Double

    fun lengthSquared(): Int


    override fun unaryMinus(): VectorI

    override fun unaryPlus(): VectorI

    override fun plus(other: Vector<Int>): VectorI

    override fun minus(other: Vector<Int>): VectorI

    override fun times(scalar: Int): VectorI

    override fun div(scalar: Int): VectorI


    override fun copy(): VectorI

    override fun mutableCopy(): MutableVectorI
}
