package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition2F
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2F

public interface Vector2F : Vector2<Float> {

    public fun length(): Float

    public fun lengthSquared(): Float

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
