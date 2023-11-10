package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector2

public interface Position2D : Position2<Double> {

    override fun plus(other: Vector2<Double>): Position2D

    override fun minus(other: Vector2<Double>): Position2D

    override fun copy(): Position2D

    override fun mutableCopy(): MutablePosition2D
}
