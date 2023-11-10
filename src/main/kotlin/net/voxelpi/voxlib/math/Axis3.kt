package net.voxelpi.voxlib.math

import net.voxelpi.voxlib.math.vector.Vector3I
import net.voxelpi.voxlib.math.vector.vector3I

public enum class Axis3(
    public val vector: Vector3I,
) {
    X(vector3I(1, 0, 0)),
    Y(vector3I(0, 1, 0)),
    Z(vector3I(0, 0, 1)),
}
