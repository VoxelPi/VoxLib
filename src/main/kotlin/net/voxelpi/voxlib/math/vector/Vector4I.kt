package net.voxelpi.voxlib.math.vector

public interface Vector4I : Vector4<Int> {

    public fun length(): Double

    public fun lengthSquared(): Int

    override fun unaryMinus(): Vector4I

    override fun unaryPlus(): Vector4I

    override fun plus(other: Vector4<Int>): Vector4I

    override fun minus(other: Vector4<Int>): Vector4I

    override fun times(scalar: Int): Vector4I

    override fun div(scalar: Int): Vector4I

    override fun copy(): Vector4I

    override fun mutableCopy(): MutableVector4I
}
