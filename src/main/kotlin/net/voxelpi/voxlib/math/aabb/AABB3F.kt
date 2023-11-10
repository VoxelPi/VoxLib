package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position3F
import net.voxelpi.voxlib.math.vector.Vector3F

public interface AABB3F : AABB3<Float> {

    override val min: Position3F

    override val max: Position3F

    override val size: Vector3F

    override fun expandedCopy(amount: Float): AABB3F
}
