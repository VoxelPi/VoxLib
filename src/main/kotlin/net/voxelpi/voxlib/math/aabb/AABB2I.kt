package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position2I
import net.voxelpi.voxlib.math.vector.Vector2I

public interface AABB2I : AABB2<Int>, Iterable<Position2I> {

    override val min: Position2I

    override val max: Position2I

    override val size: Vector2I

    override fun expandedCopy(amount: Int): AABB2I
}
