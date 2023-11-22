package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.VectorF

public interface PositionF : Position<Float> {

    override fun plus(other: Vector<Float>): PositionF

    override fun minus(other: Vector<Float>): PositionF

    override fun minus(other: Position<Float>): VectorF

    override fun copy(): PositionF

    override fun mutableCopy(): MutablePositionF
}
