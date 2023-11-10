package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4

public data class MutablePosition4F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
    override var w: Float,
) : Position4F, MutablePosition4<Float> {

    override fun plusAssign(other: Vector4<Float>) {
        x += other.x
        y += other.y
        z += other.z
        w += other.w
    }

    override fun minusAssign(other: Vector4<Float>) {
        x -= other.x
        y -= other.y
        z -= other.z
        w -= other.w
    }

    override fun set(value: Position4<Float>) {
        x = value.x
        y = value.y
        z = value.z
        w = value.w
    }

    override fun set(value: Float) {
        x = value
        y = value
        z = value
        w = value
    }

    override fun plus(other: Vector4<Float>): MutablePosition4F {
        return MutablePosition4F(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    override fun minus(other: Vector4<Float>): MutablePosition4F {
        return MutablePosition4F(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    override fun copy(): Position4F {
        return MutablePosition4F(x, y, z, w)
    }

    override fun mutableCopy(): MutablePosition4F {
        return MutablePosition4F(x, y, z, w)
    }
}
