package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position2F
import net.voxelpi.voxlib.math.vector.Vector2F

public interface AABB2F : AABB2<Float> {

    override val min: Position2F

    override val max: Position2F

    override val size: Vector2F

    override fun expandedCopy(amount: Float): AABB2F
}
