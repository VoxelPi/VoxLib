package net.voxelpi.voxlib.math.quaternion

public interface QuaternionF : Quaternion<Float> {

    override val w: Float

    override val x: Float

    override val y: Float

    override val z: Float

    public val magnitude: Float

    public fun normalized(): QuaternionF

    override fun times(quaternion: Quaternion<Float>): QuaternionF
}
