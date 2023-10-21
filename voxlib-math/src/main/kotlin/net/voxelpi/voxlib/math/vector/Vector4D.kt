package net.voxelpi.voxlib.math.vector

interface Vector4D : Vector4<Double> {

    fun length(): Double

    fun lengthSquared(): Double


    override fun unaryMinus(): Vector4D

    override fun unaryPlus(): Vector4D

    override fun plus(other: Vector4<Double>): Vector4D

    override fun minus(other: Vector4<Double>): Vector4D

    override fun times(scalar: Double): Vector4D

    override fun div(scalar: Double): Vector4D


    override fun copy(): Vector4D

    override fun mutableCopy(): MutableVector4D
}
