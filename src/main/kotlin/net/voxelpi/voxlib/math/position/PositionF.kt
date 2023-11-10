package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector

public interface PositionF : Position<Float> {

    override fun plus(other: Vector<Float>): PositionF

    override fun minus(other: Vector<Float>): PositionF

    override fun copy(): PositionF

    override fun mutableCopy(): MutablePositionF
}
