package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.aabb.AABB2
import net.voxelpi.voxlib.math.vector.MutableVector2I
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2I
import net.voxelpi.voxlib.math.vector.vector2I

public data class MutablePosition2I(
    override var x: Int,
    override var y: Int,
) : Position2I, MutablePosition2<Int> {

    override fun plusAssign(other: Vector2<Int>) {
        x += other.x
        y += other.y
    }

    override fun minusAssign(other: Vector2<Int>) {
        x -= other.x
        y -= other.y
    }

    override fun set(value: Position2<Int>) {
        x = value.x
        y = value.y
    }

    override fun set(value: Int) {
        x = value
        y = value
    }

    override fun plus(other: Vector2<Int>): MutablePosition2I {
        return MutablePosition2I(x + other.x, y + other.y)
    }

    override fun minus(other: Vector2<Int>): MutablePosition2I {
        return MutablePosition2I(x - other.x, y - other.y)
    }

    override fun minus(other: Position2<Int>): Vector2I {
        return vector2I(x - other.x, y - other.y)
    }

    override fun to(position: Position2<Int>): Vector2I {
        return vector2I(position.x - x, position.y - y)
    }

    override fun relativeTo(position: Position2<Int>): Position2I {
        return position2I(x - position.x, y - position.y)
    }

    override fun relativeTo(aabb: AABB2<Int>): Position2I {
        return position2I(x - aabb.min.x, y - aabb.min.y)
    }

    override fun copy(): Position2I {
        return MutablePosition2I(x, y)
    }

    override fun mutableCopy(): MutablePosition2I {
        return MutablePosition2I(x, y)
    }

    override fun vector(): Vector2I {
        return MutableVector2I(x, y)
    }

    override fun mutableVector(): MutableVector2I {
        return MutableVector2I(x, y)
    }
}
