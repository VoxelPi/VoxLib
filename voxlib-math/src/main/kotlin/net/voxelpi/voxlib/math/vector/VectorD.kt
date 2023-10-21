package net.voxelpi.voxlib.math.vector

interface VectorD : Vector<Double> {

    fun length(): Double

    fun lengthSquared(): Double


    override fun unaryMinus(): VectorD

    override fun unaryPlus(): VectorD

    override fun plus(other: Vector<Double>): VectorD

    override fun minus(other: Vector<Double>): VectorD

    override fun times(scalar: Double): VectorD

    override fun div(scalar: Double): VectorD


    override fun copy(): VectorD

    override fun mutableCopy(): MutableVectorD
}
