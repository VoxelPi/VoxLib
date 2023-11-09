package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector

public interface PositionI : Position<Int> {

    override fun plus(other: Vector<Int>): PositionI

    override fun minus(other: Vector<Int>): PositionI


    override fun copy(): PositionI

    override fun mutableCopy(): MutablePositionI
}
