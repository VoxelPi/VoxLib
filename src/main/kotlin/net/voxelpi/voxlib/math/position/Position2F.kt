package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector2

public interface Position2F : Position2<Float> {

    override fun plus(other: Vector2<Float>): Position2F

    override fun minus(other: Vector2<Float>): Position2F


    override fun copy(): Position2F

    override fun mutableCopy(): MutablePosition2F
}
