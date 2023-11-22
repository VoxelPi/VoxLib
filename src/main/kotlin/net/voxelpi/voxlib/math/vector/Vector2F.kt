package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2F
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2F

public interface Vector2F : Vector2<Float> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Float

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Float

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector2F

    /**
     * Returns the angle theta of the polar coordinates (r, theta) that correspond to the rectangular coordinates (x, y).
     */
    public fun angle(): Float

    override fun unaryMinus(): Vector2F

    override fun unaryPlus(): Vector2F

    override fun plus(other: Vector2<Float>): Vector2F

    override fun minus(other: Vector2<Float>): Vector2F

    override fun times(scalar: Float): Vector2F

    override fun div(scalar: Float): Vector2F

    override fun copy(): Vector2F

    override fun mutableCopy(): MutableVector2F

    override fun position(): Position2F

    override fun position(origin: Position2<Float>): Position2F

    override fun mutablePosition(): MutablePosition2F

    override fun mutablePosition(origin: Position2<Float>): MutablePosition2F
}
