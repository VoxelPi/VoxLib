package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2D
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2D

public interface Vector2D : Vector2<Double> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Double

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector2D

    override fun unaryMinus(): Vector2D

    override fun unaryPlus(): Vector2D

    override fun plus(other: Vector2<Double>): Vector2D

    override fun minus(other: Vector2<Double>): Vector2D

    override fun times(scalar: Double): Vector2D

    override fun div(scalar: Double): Vector2D

    override fun copy(): Vector2D

    override fun mutableCopy(): MutableVector2D

    override fun position(): Position2D

    override fun position(origin: Position2<Double>): Position2D

    override fun mutablePosition(): MutablePosition2D

    override fun mutablePosition(origin: Position2<Double>): MutablePosition2D
}
