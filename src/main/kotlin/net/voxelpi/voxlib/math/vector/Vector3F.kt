package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3F
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3F

public interface Vector3F : Vector3<Float> {

    /**
     * Returns the Euclidean norm of the vector.
     */
    public fun length(): Float

    /**
     * Returns the square of the Euclidean norm of the vector.
     */
    public fun lengthSquared(): Float

    /**
     * Returns a copy of the vector that is scaled by 1 divided by the length of the vector.
     */
    public fun normalized(): Vector3F

    override fun unaryMinus(): Vector3F

    override fun unaryPlus(): Vector3F

    override fun plus(other: Vector3<Float>): Vector3F

    override fun minus(other: Vector3<Float>): Vector3F

    override fun times(scalar: Float): Vector3F

    override fun div(scalar: Float): Vector3F

    override fun copy(): Vector3F

    override fun mutableCopy(): MutableVector3F

    override fun position(): Position3F

    override fun position(origin: Position3<Float>): Position3F

    override fun mutablePosition(): MutablePosition3F

    override fun mutablePosition(origin: Position3<Float>): MutablePosition3F
}
