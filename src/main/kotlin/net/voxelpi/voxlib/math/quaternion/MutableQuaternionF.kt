package net.voxelpi.voxlib.math.quaternion

import kotlin.math.sqrt

public data class MutableQuaternionF(
    override var w: Float,
    override var x: Float,
    override var y: Float,
    override var z: Float,
) : QuaternionF, MutableQuaternion<Float> {

    override val magnitude: Float
        get() = sqrt(w * w + x * x + y * y + z * z)

    override fun normalized(): MutableQuaternionF {
        val magnitude = magnitude
        return MutableQuaternionF(w / magnitude, x / magnitude, y / magnitude, z / magnitude)
    }

    public fun normalize() {
        val magnitude = magnitude
        w /= magnitude
        x /= magnitude
        y /= magnitude
        z /= magnitude
    }

    override fun times(quaternion: Quaternion<Float>): MutableQuaternionF {
        return MutableQuaternionF(
            this.w * quaternion.w - this.x * quaternion.x - this.y * quaternion.y - this.z * quaternion.z,
            this.w * quaternion.x + this.x * quaternion.w + this.y * quaternion.z - this.z * quaternion.y,
            this.w * quaternion.y - this.x * quaternion.z + this.y * quaternion.w + this.z * quaternion.x,
            this.w * quaternion.z + this.x * quaternion.y - this.y * quaternion.x + this.z * quaternion.w
        )
    }
}
