package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4I
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4I

public interface Vector4I : Vector4<Int> {

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
    public fun normalized(): Vector4D

    override fun unaryMinus(): Vector4I

    override fun unaryPlus(): Vector4I

    override fun plus(other: Vector4<Int>): Vector4I

    override fun minus(other: Vector4<Int>): Vector4I

    override fun times(scalar: Int): Vector4I

    override fun div(scalar: Int): Vector4I

    override fun copy(): Vector4I

    override fun mutableCopy(): MutableVector4I

    override fun position(): Position4I

    override fun position(origin: Position4<Int>): Position4I

    override fun mutablePosition(): MutablePosition4I

    override fun mutablePosition(origin: Position4<Int>): MutablePosition4I
}
