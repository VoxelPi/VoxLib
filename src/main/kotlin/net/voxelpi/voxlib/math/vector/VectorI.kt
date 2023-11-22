package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionI
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionI

public interface VectorI : Vector<Int> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Double

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Int

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): VectorD

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
