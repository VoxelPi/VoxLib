package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4

public interface Position4D : Position4<Double> {

    override fun plus(other: Vector4<Double>): Position4D

    override fun minus(other: Vector4<Double>): Position4D


    override fun copy(): Position4D

    override fun mutableCopy(): MutablePosition4D
}
