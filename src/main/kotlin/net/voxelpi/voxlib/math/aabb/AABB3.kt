package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.vector.Vector3

/**
 * An axis aligned bounding box.
 */
public interface AABB3<T> where T : Number, T : Comparable<T> {

    /**
     * The minimum corner of the box.
     */
    public val min: Position3<T>

    /**
     * The maximum corner of the box.
     */
    public val max: Position3<T>

    /**
     * The size of the box.
     */
    public val size: Vector3<T>

    /**
     * The surface of the box.
     */
    public val surface: T

    /**
     * The volume of the box.
     */
    public val volume: T

    /**
     * Checks if the given [position] lies inside the bounding box.
     */
    public operator fun contains(position: Position3<T>): Boolean {
        return position.x in min.x..max.x && position.y in min.y..max.y && position.z in min.z..max.z
    }

    /**
     * Checks if the given [vector] lies inside the bounding box.
     */
    public operator fun contains(vector: Vector3<T>): Boolean {
        return vector.x in min.x..max.x && vector.y in min.y..max.y && vector.z in min.z..max.z
    }

    /**
     * Checks if the bounding box intersects with the given [box].
     */
    public fun intersects(box: AABB3<T>): Boolean {
        val min1 = min
        val max1 = max
        val min2 = box.min
        val max2 = box.max
        return !((min2.x > max1.x || max2.x < min1.x) || (min2.y > max1.y || max2.y < min1.y) || (min2.z > max1.z || max2.z < min1.z))
    }

    /**
     * Returns if the given [position] lies on the boundary of the bounding box.
     */
    @Suppress("ktlint:standard:wrapping", "ktlint:standard:indent")
    public fun isOnBoundary(position: Position3<T>): Boolean {
        return ((position.x == min.x || position.x == max.x)
            && (min.y <= position.y && position.y <= max.y) && (min.z <= position.z && position.z <= max.z))
            || ((position.y == min.y || position.y == max.y)
            && (min.x <= position.x && position.x <= max.x) && (min.z <= position.z && position.z <= max.z))
            || ((position.z == min.z || position.z == max.z)
            && (min.x <= position.x && position.x <= max.x) && (min.y <= position.y && position.y <= max.y))
    }

    /**
     * Returns a copy of this bounding box, that is expanded in every direction by [amount].
     */
    public fun expandedCopy(amount: T): AABB3<T>
}
