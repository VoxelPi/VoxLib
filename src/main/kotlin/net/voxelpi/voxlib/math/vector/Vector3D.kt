package net.voxelpi.voxlib.math.vector

public interface Vector3D : Vector3<Double> {

    public fun length(): Double

    public fun lengthSquared(): Double

    override fun unaryMinus(): Vector3D

    override fun unaryPlus(): Vector3D

    override fun plus(other: Vector3<Double>): Vector3D

    override fun minus(other: Vector3<Double>): Vector3D

    override fun times(scalar: Double): Vector3D

    override fun div(scalar: Double): Vector3D

    override fun copy(): Vector3D

    override fun mutableCopy(): MutableVector3D
}
