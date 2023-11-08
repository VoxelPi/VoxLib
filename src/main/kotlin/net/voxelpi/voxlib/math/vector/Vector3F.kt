package net.voxelpi.voxlib.math.vector

public interface Vector3F : Vector3<Float> {

    public fun length(): Float

    public fun lengthSquared(): Float


    override fun unaryMinus(): Vector3F

    override fun unaryPlus(): Vector3F

    override fun plus(other: Vector3<Float>): Vector3F

    override fun minus(other: Vector3<Float>): Vector3F

    override fun times(scalar: Float): Vector3F

    override fun div(scalar: Float): Vector3F


    override fun copy(): Vector3F

    override fun mutableCopy(): MutableVector3F
}
