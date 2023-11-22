package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVectorI
import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.VectorI

public interface PositionI : Position<Int> {

    override fun plus(other: Vector<Int>): PositionI

    override fun minus(other: Vector<Int>): PositionI

    override fun minus(other: Position<Int>): VectorI

    override fun copy(): PositionI

    override fun mutableCopy(): MutablePositionI

    override fun vector(): VectorI

    override fun mutableVector(): MutableVectorI
}
