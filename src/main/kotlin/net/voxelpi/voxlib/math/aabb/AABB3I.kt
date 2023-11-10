package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position3I
import net.voxelpi.voxlib.math.vector.Vector3I

public interface AABB3I : AABB3<Int>, Iterable<Position3I> {

    override val min: Position3I

    override val max: Position3I

    override val size: Vector3I

    override fun expandedCopy(amount: Int): AABB3I
}
