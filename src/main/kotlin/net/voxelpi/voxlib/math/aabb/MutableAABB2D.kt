package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition2D
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.vector.Vector2D
import net.voxelpi.voxlib.math.vector.vector2D
import kotlin.math.abs
import kotlin.math.min

public data class MutableAABB2D(
    override var min: MutablePosition2D,
    override var max: MutablePosition2D,
) : AABB2D, MutableAABB2<Double> {

    override val size: Vector2D
        get() = vector2D(max.x - min.x, max.y - min.y)

    override val surface: Double
        get() = (max.x - min.x) * (max.y - min.y)

    override fun expand(amount: Double) {
        min.x -= amount
        min.y -= amount
        max.x += amount
        max.y += amount
    }

    override fun expandedCopy(amount: Double): MutableAABB2D {
        return MutableAABB2D(min - vector2D(amount, amount), max + vector2D(amount, amount))
    }

    override fun isOnBoundary(position: Position2<Double>, tolerance: Double): Boolean {
        return min(abs(position.x - min.x), abs(position.x - max.x)) < tolerance && (min.y <= position.y && position.y <= max.y)
            || min(abs(position.y - min.y), abs(position.y - max.y)) < tolerance && (min.x <= position.x && position.x <= max.x)
    }
}
