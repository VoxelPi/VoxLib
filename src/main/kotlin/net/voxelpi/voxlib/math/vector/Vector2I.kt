package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2I
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2I

public interface Vector2I : Vector2<Int> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Int

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector2D

    override fun unaryMinus(): Vector2I

    override fun unaryPlus(): Vector2I

    override fun plus(other: Vector2<Int>): Vector2I

    override fun minus(other: Vector2<Int>): Vector2I

    override fun times(scalar: Int): Vector2I

    override fun div(scalar: Int): Vector2I

    override fun copy(): Vector2I

    override fun mutableCopy(): MutableVector2I

    override fun position(): Position2I

    override fun position(origin: Position2<Int>): Position2I

    override fun mutablePosition(): MutablePosition2I

    override fun mutablePosition(origin: Position2<Int>): MutablePosition2I
}
