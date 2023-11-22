package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4I

public interface Position4I : Position4<Int> {

    override fun plus(other: Vector4<Int>): Position4I

    override fun minus(other: Vector4<Int>): Position4I

    override fun minus(other: Position4<Int>): Vector4I

    override fun copy(): Position4I

    override fun mutableCopy(): MutablePosition4I
}
