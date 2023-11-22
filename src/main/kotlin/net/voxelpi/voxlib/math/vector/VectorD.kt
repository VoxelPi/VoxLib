package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionD
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionD

public interface VectorD : Vector<Double> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Double

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): VectorD

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
