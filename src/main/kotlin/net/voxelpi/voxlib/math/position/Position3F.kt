package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector3

public interface Position3F : Position3<Float> {

    override fun plus(other: Vector3<Float>): Position3F

    override fun minus(other: Vector3<Float>): Position3F


    override fun copy(): Position3F

    override fun mutableCopy(): MutablePosition3F
}
