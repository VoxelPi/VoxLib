package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.vector.Vector3

/**
 * An axis aligned bounding box.
 */
public interface AABB3<T> where T : Number, T: Comparable<T> {

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
     * Returns if the given position is on the surface of the bounding box.
     */
    public fun isOnSurface(position: Position3<T>): Boolean

    /**
     * Returns a copy of this bounding box, that is expanded in every direction by [amount].
     */
    public fun expandedCopy(amount: T): AABB3<T>
}
