package net.voxelpi.voxlib.math.quaternion

public interface MutableQuaternion<T> : Quaternion<T> where T : Number, T : Comparable<T> {

    override var w: T

    override var x: T

    override var y: T

    override var z: T
}
