package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector2

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

    override fun copy(): Position2F {
        return MutablePosition2F(x, y)
    }

    override fun mutableCopy(): MutablePosition2F {
        return MutablePosition2F(x, y)
    }
}
