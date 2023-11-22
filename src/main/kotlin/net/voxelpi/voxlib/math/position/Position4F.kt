package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4F

public interface Position4F : Position4<Float> {

    override fun plus(other: Vector4<Float>): Position4F

    override fun minus(other: Vector4<Float>): Position4F

    override fun minus(other: Position4<Float>): Vector4F

    override fun copy(): Position4F

    override fun mutableCopy(): MutablePosition4F
}
