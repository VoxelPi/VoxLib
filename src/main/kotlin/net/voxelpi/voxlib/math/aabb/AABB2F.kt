package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2F
import net.voxelpi.voxlib.math.vector.Vector2F

public interface AABB2F : AABB2<Float> {

    override val min: Position2F

    override val max: Position2F

    override val size: Vector2F

    override fun expandedCopy(amount: Float): AABB2F

    /**
     * Returns if the given [position] lies on the boundary of the bounding box, or is less than [tolerance] away from it.
     */
    public fun isOnBoundary(position: Position2<Float>, tolerance: Float): Boolean
}
