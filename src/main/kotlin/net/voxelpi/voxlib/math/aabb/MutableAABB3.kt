package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition3

/**
 * A mutable axis aligned bounding box.
 */
public interface MutableAABB3<T> : AABB3<T> where T : Number, T : Comparable<T> {

    override val min: MutablePosition3<T>

    override val max: MutablePosition3<T>

    /**
     * Expands this bounding box in every direction by [amount].
     */
    public fun expand(amount: T)
}
