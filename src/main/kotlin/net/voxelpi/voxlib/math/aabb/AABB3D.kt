package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3D
import net.voxelpi.voxlib.math.vector.Vector3D

public interface AABB3D : AABB3<Double> {

    override val min: Position3D

    override val max: Position3D

    override val size: Vector3D

    override fun expandedCopy(amount: Double): AABB3D

    /**
     * Returns if the given [position] lies on the boundary of the bounding box, or is less than [tolerance] away from it.
     */
    public fun isOnBoundary(position: Position3<Double>, tolerance: Double): Boolean
}
