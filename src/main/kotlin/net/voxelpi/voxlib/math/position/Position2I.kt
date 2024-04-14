package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.aabb.AABB2
import net.voxelpi.voxlib.math.vector.MutableVector2I
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2I

public interface Position2I : Position2<Int> {

    override fun plus(other: Vector2<Int>): Position2I

    override fun minus(other: Vector2<Int>): Position2I

    override fun minus(other: Position2<Int>): Vector2I

    override fun to(position: Position2<Int>): Vector2I

    override fun relativeTo(position: Position2<Int>): Position2I

    override fun relativeTo(aabb: AABB2<Int>): Position2I

    override fun copy(): Position2I

    override fun mutableCopy(): MutablePosition2I

    override fun vector(): Vector2I

    override fun mutableVector(): MutableVector2I
}
