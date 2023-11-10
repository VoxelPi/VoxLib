package net.voxelpi.voxlib.math.vector

public interface VectorF : Vector<Float> {

    public fun length(): Float

    public fun lengthSquared(): Float

    override fun unaryMinus(): VectorF

    override fun unaryPlus(): VectorF

    override fun plus(other: Vector<Float>): VectorF

    override fun minus(other: Vector<Float>): VectorF

    override fun times(scalar: Float): VectorF

    override fun div(scalar: Float): VectorF

    override fun copy(): VectorF

    override fun mutableCopy(): MutableVectorF
}
