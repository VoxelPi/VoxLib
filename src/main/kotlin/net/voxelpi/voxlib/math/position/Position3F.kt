package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector3F
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3F

public interface Position3F : Position3<Float> {

    override fun plus(other: Vector3<Float>): Position3F

    override fun minus(other: Vector3<Float>): Position3F

    override fun minus(other: Position3<Float>): Vector3F

    override fun copy(): Position3F

    override fun mutableCopy(): MutablePosition3F

    override fun vector(): Vector3F

    override fun mutableVector(): MutableVector3F
}
