package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVectorD
import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.VectorD

public interface PositionD : Position<Double> {

    override fun plus(other: Vector<Double>): PositionD

    override fun minus(other: Vector<Double>): PositionD

    override fun minus(other: Position<Double>): VectorD

    override fun copy(): PositionD

    override fun mutableCopy(): MutablePositionD

    override fun vector(): VectorD

    override fun mutableVector(): MutableVectorD
}
