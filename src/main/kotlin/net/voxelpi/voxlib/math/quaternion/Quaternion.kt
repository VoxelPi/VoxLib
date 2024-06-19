package net.voxelpi.voxlib.math.quaternion

public interface Quaternion<T> where T : Number, T : Comparable<T> {

    public val w: T

    public val x: T

    public val y: T

    public val z: T

    public operator fun times(quaternion: Quaternion<T>): Quaternion<T>
}
