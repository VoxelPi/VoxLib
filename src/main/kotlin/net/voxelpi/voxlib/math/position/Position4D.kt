package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4D

public interface Position4D : Position4<Double> {

    override fun plus(other: Vector4<Double>): Position4D

    override fun minus(other: Vector4<Double>): Position4D

    override fun minus(other: Position4<Double>): Vector4D

    override fun copy(): Position4D

    override fun mutableCopy(): MutablePosition4D
}
