package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector3

public interface Position3D : Position3<Double> {

    override fun plus(other: Vector3<Double>): Position3D

    override fun minus(other: Vector3<Double>): Position3D

    override fun copy(): Position3D

    override fun mutableCopy(): MutablePosition3D
}
