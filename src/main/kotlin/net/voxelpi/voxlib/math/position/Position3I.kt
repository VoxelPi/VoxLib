package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector3

public interface Position3I : Position3<Int> {

    override fun plus(other: Vector3<Int>): Position3I

    override fun minus(other: Vector3<Int>): Position3I


    override fun copy(): Position3I

    override fun mutableCopy(): MutablePosition3I
}
