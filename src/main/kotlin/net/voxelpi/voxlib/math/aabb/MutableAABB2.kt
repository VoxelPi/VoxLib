package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition2

/**
 * A mutable axis aligned bounding box.
 */
public interface MutableAABB2<T> : AABB2<T> where T : Number, T : Comparable<T> {

    override val min: MutablePosition2<T>

    override val max: MutablePosition2<T>

    /**
     * Expands this bounding box in every direction by [amount].
     */
    public fun expand(amount: T)
}
