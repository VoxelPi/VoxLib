package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector3I
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3I

public interface Position3I : Position3<Int> {

    override fun plus(other: Vector3<Int>): Position3I

    override fun minus(other: Vector3<Int>): Position3I

    override fun minus(other: Position3<Int>): Vector3I

    override fun to(position: Position3<Int>): Vector3I

    override fun copy(): Position3I

    override fun mutableCopy(): MutablePosition3I

    override fun vector(): Vector3I

    override fun mutableVector(): MutableVector3I
}
