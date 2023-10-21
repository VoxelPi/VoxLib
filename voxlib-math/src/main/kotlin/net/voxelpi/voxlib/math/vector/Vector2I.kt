package net.voxelpi.voxlib.math.vector

interface Vector2I : Vector2<Int> {

    fun length(): Double

    fun lengthSquared(): Int


    override fun unaryMinus(): Vector2I

    override fun unaryPlus(): Vector2I

    override fun plus(other: Vector2<Int>): Vector2I

    override fun minus(other: Vector2<Int>): Vector2I

    override fun times(scalar: Int): Vector2I

    override fun div(scalar: Int): Vector2I


    override fun copy(): Vector2I

    override fun mutableCopy(): MutableVector2I
}
