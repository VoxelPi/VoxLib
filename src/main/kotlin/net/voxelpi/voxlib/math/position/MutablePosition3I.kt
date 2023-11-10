package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector3

public data class MutablePosition3I(
    override var x: Int,
    override var y: Int,
    override var z: Int,
) : Position3I, MutablePosition3<Int> {

    override fun plusAssign(other: Vector3<Int>) {
        x += other.x
        y += other.y
        z += other.z
    }

    override fun minusAssign(other: Vector3<Int>) {
        x -= other.x
        y -= other.y
        z -= other.z
    }

    override fun set(value: Position3<Int>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Int) {
        x = value
        y = value
        z = value
    }

    override fun plus(other: Vector3<Int>): MutablePosition3I {
        return MutablePosition3I(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Int>): MutablePosition3I {
        return MutablePosition3I(x - other.x, y - other.y, z - other.z)
    }

    override fun copy(): Position3I {
        return MutablePosition3I(x, y, z)
    }

    override fun mutableCopy(): MutablePosition3I {
        return MutablePosition3I(x, y, z)
    }
}
