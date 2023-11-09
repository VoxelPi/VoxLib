package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4

public data class MutablePosition4I(
    override var x: Int,
    override var y: Int,
    override var z: Int,
    override var w: Int,
): Position4I, MutablePosition4<Int> {

    override fun plusAssign(other: Vector4<Int>) {
        x += other.x
        y += other.y
        z += other.z
        w += other.w
    }

    override fun minusAssign(other: Vector4<Int>) {
        x -= other.x
        y -= other.y
        z -= other.z
        w -= other.w
    }

    override fun set(value: Position4<Int>) {
        x = value.x
        y = value.y
        z = value.z
        w = value.w
    }

    override fun set(value: Int) {
        x = value
        y = value
        z = value
        w = value
    }


    override fun plus(other: Vector4<Int>): MutablePosition4I {
        return MutablePosition4I(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    override fun minus(other: Vector4<Int>): MutablePosition4I {
        return MutablePosition4I(x - other.x, y - other.y, z - other.z, w - other.w)
    }


    override fun copy(): Position4I {
        return MutablePosition4I(x, y, z, w)
    }

    override fun mutableCopy(): MutablePosition4I {
        return MutablePosition4I(x, y, z, w)
    }
}
