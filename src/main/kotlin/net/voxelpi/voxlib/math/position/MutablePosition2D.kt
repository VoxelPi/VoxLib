package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector2

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

    override fun copy(): Position2D {
        return MutablePosition2D(x, y)
    }

    override fun mutableCopy(): MutablePosition2D {
        return MutablePosition2D(x, y)
    }
}
