package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector3

public data class MutablePosition3F(
    override var x: Float,
    override var y: Float,
    override var z: Float,
): Position3F, MutablePosition3<Float> {

    override fun plusAssign(other: Vector3<Float>) {
        x += other.x
        y += other.y
        z += other.z
    }

    override fun minusAssign(other: Vector3<Float>) {
        x -= other.x
        y -= other.y
        z -= other.z
    }

    override fun set(value: Position3<Float>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Float) {
        x = value
        y = value
        z = value
    }


    override fun plus(other: Vector3<Float>): MutablePosition3F {
        return MutablePosition3F(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Float>): MutablePosition3F {
        return MutablePosition3F(x - other.x, y - other.y, z - other.z)
    }


    override fun copy(): Position3F {
        return MutablePosition3F(x, y, z)
    }

    override fun mutableCopy(): MutablePosition3F {
        return MutablePosition3F(x, y, z)
    }
}
