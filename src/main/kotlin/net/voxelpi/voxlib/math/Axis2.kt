package net.voxelpi.voxlib.math

import net.voxelpi.voxlib.math.vector.Vector2I
import net.voxelpi.voxlib.math.vector.vector2I

public enum class Axis2(
    public val vector: Vector2I,
) {
    X(vector2I(1, 0)),
    Y(vector2I(0, 1)),
}
