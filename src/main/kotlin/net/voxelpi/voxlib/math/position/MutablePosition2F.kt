package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector2F
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.vector2F

public data class MutablePosition2F(
    override var x: Float,
    override var y: Float,
) : Position2F, MutablePosition2<Float> {

    override fun plusAssign(other: Vector2<Float>) {
        x += other.x
        y += other.y
    }

    override fun minusAssign(other: Vector2<Float>) {
        x -= other.x
        y -= other.y
    }

    override fun set(value: Position2<Float>) {
        x = value.x
        y = value.y
    }

    override fun set(value: Float) {
        x = value
        y = value
    }

    override fun plus(other: Vector2<Float>): MutablePosition2F {
        return MutablePosition2F(x + other.x, y + other.y)
    }

    override fun minus(other: Vector2<Float>): MutablePosition2F {
        return MutablePosition2F(x - other.x, y - other.y)
    }

    override fun minus(other: Position2<Float>): Vector2F {
        return vector2F(x - other.x, y - other.y)
    }

    override fun to(position: Position2<Float>): Vector2F {
        return vector2F(position.x - x, position.y - y)
    }

    override fun copy(): Position2F {
        return MutablePosition2F(x, y)
    }

    override fun mutableCopy(): MutablePosition2F {
        return MutablePosition2F(x, y)
    }

    override fun vector(): Vector2F {
        return MutableVector2F(x, y)
    }

    override fun mutableVector(): MutableVector2F {
        return MutableVector2F(x, y)
    }
}
