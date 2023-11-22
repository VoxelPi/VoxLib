package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector3D
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3D

public interface Position3D : Position3<Double> {

    override fun plus(other: Vector3<Double>): Position3D

    override fun minus(other: Vector3<Double>): Position3D

    override fun minus(other: Position3<Double>): Vector3D

    override fun to(position: Position3<Double>): Vector3D

    override fun copy(): Position3D

    override fun mutableCopy(): MutablePosition3D

    override fun vector(): Vector3D

    override fun mutableVector(): MutableVector3D
}
