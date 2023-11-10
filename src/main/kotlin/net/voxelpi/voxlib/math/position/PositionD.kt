package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector

public interface PositionD : Position<Double> {

    override fun plus(other: Vector<Double>): PositionD

    override fun minus(other: Vector<Double>): PositionD

    override fun copy(): PositionD

    override fun mutableCopy(): MutablePositionD
}
