package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.aabb.AABB2
import net.voxelpi.voxlib.math.vector.MutableVector2D
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2D
import net.voxelpi.voxlib.math.vector.vector2D

public data class MutablePosition2D(
    override var x: Double,
    override var y: Double,
) : Position2D, MutablePosition2<Double> {

    override fun plusAssign(other: Vector2<Double>) {
        x += other.x
        y += other.y
    }

    override fun minusAssign(other: Vector2<Double>) {
        x -= other.x
        y -= other.y
    }

    override fun set(value: Position2<Double>) {
        x = value.x
        y = value.y
    }

    override fun set(value: Double) {
        x = value
        y = value
    }

    override fun plus(other: Vector2<Double>): MutablePosition2D {
        return MutablePosition2D(x + other.x, y + other.y)
    }

    override fun minus(other: Vector2<Double>): MutablePosition2D {
        return MutablePosition2D(x - other.x, y - other.y)
    }

    override fun minus(other: Position2<Double>): Vector2D {
        return vector2D(x - other.x, y - other.y)
    }

    override fun to(position: Position2<Double>): Vector2D {
        return vector2D(position.x - x, position.y - y)
    }

    override fun relativeTo(position: Position2<Double>): Position2D {
        return position2D(x - position.x, y - position.y)
    }

    override fun relativeTo(aabb: AABB2<Double>): Position2D {
        return position2D(x - aabb.min.x, y - aabb.min.y)
    }

    override fun copy(): Position2D {
        return MutablePosition2D(x, y)
    }

    override fun mutableCopy(): MutablePosition2D {
        return MutablePosition2D(x, y)
    }

    override fun vector(): Vector2D {
        return MutableVector2D(x, y)
    }

    override fun mutableVector(): MutableVector2D {
        return MutableVector2D(x, y)
    }
}
