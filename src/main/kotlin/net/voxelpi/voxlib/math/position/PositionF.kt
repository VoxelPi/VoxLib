package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVectorF
import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.VectorF

public interface PositionF : Position<Float> {

    override fun plus(other: Vector<Float>): PositionF

    override fun minus(other: Vector<Float>): PositionF

    override fun minus(other: Position<Float>): VectorF

    override fun to(position: Position<Float>): VectorF

    override fun relativeTo(position: Position<Float>): PositionF

    override fun copy(): PositionF

    override fun mutableCopy(): MutablePositionF

    override fun vector(): VectorF

    override fun mutableVector(): MutableVectorF
}
