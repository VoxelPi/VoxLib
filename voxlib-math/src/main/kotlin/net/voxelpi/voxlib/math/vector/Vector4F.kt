package net.voxelpi.voxlib.math.vector

public interface Vector4F : Vector4<Float> {

    public fun length(): Float

    public fun lengthSquared(): Float


    override fun unaryMinus(): Vector4F

    override fun unaryPlus(): Vector4F

    override fun plus(other: Vector4<Float>): Vector4F

    override fun minus(other: Vector4<Float>): Vector4F

    override fun times(scalar: Float): Vector4F

    override fun div(scalar: Float): Vector4F


    override fun copy(): Vector4F

    override fun mutableCopy(): MutableVector4F
}
