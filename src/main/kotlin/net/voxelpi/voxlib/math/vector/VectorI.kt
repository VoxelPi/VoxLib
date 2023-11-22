package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionI
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionI

public interface VectorI : Vector<Int> {

    public fun length(): Double

    public fun lengthSquared(): Int

    override fun unaryMinus(): VectorI

    override fun unaryPlus(): VectorI

    override fun plus(other: Vector<Int>): VectorI

    override fun minus(other: Vector<Int>): VectorI

    override fun times(scalar: Int): VectorI

    override fun div(scalar: Int): VectorI

    override fun copy(): VectorI

    override fun mutableCopy(): MutableVectorI

    override fun position(): PositionI

    override fun position(origin: Position<Int>): PositionI

    override fun mutablePosition(): MutablePositionI

    override fun mutablePosition(origin: Position<Int>): MutablePositionI
}
