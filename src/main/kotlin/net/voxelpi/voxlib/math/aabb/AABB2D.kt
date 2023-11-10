package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.position.Position2D
import net.voxelpi.voxlib.math.vector.Vector2D

public interface AABB2D : AABB2<Double> {

    override val min: Position2D

    override val max: Position2D

    override val size: Vector2D

    override fun expandedCopy(amount: Double): AABB2D

    /**
     * Returns if the given [position] lies on the boundary of the bounding box, or is less than [tolerance] away from it.
     */
    public fun isOnBoundary(position: Position2<Double>, tolerance: Double): Boolean
}
