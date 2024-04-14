package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.MutablePosition2F
import net.voxelpi.voxlib.math.position.Position2
import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.vector2F
import kotlin.math.abs
import kotlin.math.min

public data class MutableAABB2F(
    override var min: MutablePosition2F,
    override var max: MutablePosition2F,
) : AABB2F, MutableAABB2<Float> {

    override val size: Vector2F
        get() = vector2F(max.x - min.x, max.y - min.y)

    override val surface: Float
        get() = (max.x - min.x) * (max.y - min.y)

    override fun expand(amount: Float) {
        min.x -= amount
        min.y -= amount
        max.x += amount
        max.y += amount
    }

    override fun expandedCopy(amount: Float): MutableAABB2F {
        return MutableAABB2F(min - vector2F(amount, amount), max + vector2F(amount, amount))
    }

    override fun isOnBoundary(position: Position2<Float>, tolerance: Float): Boolean {
        return min(abs(position.x - min.x), abs(position.x - max.x)) < tolerance && (min.y <= position.y && position.y <= max.y)
            || min(abs(position.y - min.y), abs(position.y - max.y)) < tolerance && (min.x <= position.x && position.x <= max.x)
    }
}
