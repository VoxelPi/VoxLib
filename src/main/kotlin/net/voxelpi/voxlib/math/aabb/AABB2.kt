package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.vector.Vector2

/**
 * An axis aligned bounding box.
 */
public interface AABB2<T> where T : Number, T : Comparable<T> {

    /**
     * The minimum corner of the box.
     */
    public val min: Position2<T>

    /**
     * The maximum corner of the box.
     */
    public val max: Position2<T>

    /**
     * The size of the box.
     */
    public val size: Vector2<T>

    /**
     * The surface of the box.
     */
    public val surface: T

    /**
     * Checks if the given [position] lies inside the bounding box.
     */
    public operator fun contains(position: Position2<T>): Boolean {
        return position.x in min.x..max.x && position.y in min.y..max.y
    }

    /**
     * Checks if the given [vector] lies inside the bounding box.
     */
    public operator fun contains(vector: Vector2<T>): Boolean {
        return vector.x in min.x..max.x && vector.y in min.y..max.y
    }

    /**
     * Checks if the bounding box intersects with the given [box].
     */
    public fun intersects(box: AABB2<T>): Boolean {
        val min1 = min
        val max1 = max
        val min2 = box.min
        val max2 = box.max
        return !((min2.x > max1.x || max2.x < min1.x) || (min2.y > max1.y || max2.y < min1.y))
    }

    /**
     * Returns if the given [position] lies on the boundary of the bounding box.
     */
    public fun isOnBoundary(position: Position2<T>): Boolean

    /**
     * Returns a copy of this bounding box, that is expanded in every direction by [amount].
     */
    public fun expandedCopy(amount: T): AABB2<T>
}
