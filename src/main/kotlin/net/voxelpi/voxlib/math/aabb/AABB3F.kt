package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3F
import net.voxelpi.voxlib.math.vector.Vector3F

public interface AABB3F : AABB3<Float> {

    override val min: Position3F

    override val max: Position3F

    override val size: Vector3F

    override fun expandedCopy(amount: Float): AABB3F

    /**
     * Returns if the given [position] lies on the boundary of the bounding box, or is less than [tolerance] away from it.
     */
    public fun isOnBoundary(position: Position3<Float>, tolerance: Float): Boolean
}
