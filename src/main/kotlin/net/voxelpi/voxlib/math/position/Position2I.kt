package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector2

public interface Position2I : Position2<Int> {

    override fun plus(other: Vector2<Int>): Position2I

    override fun minus(other: Vector2<Int>): Position2I


    override fun copy(): Position2I

    override fun mutableCopy(): MutablePosition2I
}
