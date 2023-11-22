package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionD
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionD

public interface VectorD : Vector<Double> {

    public fun length(): Double

    public fun lengthSquared(): Double

    override fun unaryMinus(): VectorD

    override fun unaryPlus(): VectorD

    override fun plus(other: Vector<Double>): VectorD

    override fun minus(other: Vector<Double>): VectorD

    override fun times(scalar: Double): VectorD

    override fun div(scalar: Double): VectorD

    override fun copy(): VectorD

    override fun mutableCopy(): MutableVectorD

    override fun position(): PositionD

    override fun position(origin: Position<Double>): PositionD

    override fun mutablePosition(): MutablePositionD

    override fun mutablePosition(origin: Position<Double>): MutablePositionD
}
