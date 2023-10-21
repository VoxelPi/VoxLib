package net.voxelpi.voxlib.math.vector

interface VectorF : Vector<Float> {

    fun length(): Float

    fun lengthSquared(): Float


    override fun unaryMinus(): VectorF

    override fun unaryPlus(): VectorF

    override fun plus(other: Vector<Float>): VectorF

    override fun minus(other: Vector<Float>): VectorF

    override fun times(scalar: Float): VectorF

    override fun div(scalar: Float): VectorF


    override fun copy(): VectorF

    override fun mutableCopy(): MutableVectorF
}
