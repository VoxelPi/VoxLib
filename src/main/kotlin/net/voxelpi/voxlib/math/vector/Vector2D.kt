package net.voxelpi.voxlib.math.vector

public interface Vector2D : Vector2<Double> {

    public fun length(): Double

    public fun lengthSquared(): Double

    override fun unaryMinus(): Vector2D

    override fun unaryPlus(): Vector2D

    override fun plus(other: Vector2<Double>): Vector2D

    override fun minus(other: Vector2<Double>): Vector2D

    override fun times(scalar: Double): Vector2D

    override fun div(scalar: Double): Vector2D

    override fun copy(): Vector2D

    override fun mutableCopy(): MutableVector2D
}
