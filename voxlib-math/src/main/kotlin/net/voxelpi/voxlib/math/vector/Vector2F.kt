package net.voxelpi.voxlib.math.vector

interface Vector2F : Vector2<Float> {

    fun length(): Float

    fun lengthSquared(): Float


    override fun unaryMinus(): Vector2F

    override fun unaryPlus(): Vector2F

    override fun plus(other: Vector2<Float>): Vector2F

    override fun minus(other: Vector2<Float>): Vector2F

    override fun times(scalar: Float): Vector2F

    override fun div(scalar: Float): Vector2F


    override fun copy(): Vector2F

    override fun mutableCopy(): MutableVector2F
}
