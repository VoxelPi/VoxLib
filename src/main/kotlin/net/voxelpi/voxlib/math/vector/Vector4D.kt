package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition4D
import net.voxelpi.voxlib.math.position.Position4
import net.voxelpi.voxlib.math.position.Position4D

public interface Vector4D : Vector4<Double> {

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
    public fun normalized(): Vector4D

    override fun unaryMinus(): Vector4D

    override fun unaryPlus(): Vector4D

    override fun plus(other: Vector4<Double>): Vector4D

    override fun minus(other: Vector4<Double>): Vector4D

    override fun times(scalar: Double): Vector4D

    override fun div(scalar: Double): Vector4D

    override fun copy(): Vector4D

    override fun mutableCopy(): MutableVector4D

    override fun position(): Position4D

    override fun position(origin: Position4<Double>): Position4D

    override fun mutablePosition(): MutablePosition4D

    override fun mutablePosition(origin: Position4<Double>): MutablePosition4D
}
