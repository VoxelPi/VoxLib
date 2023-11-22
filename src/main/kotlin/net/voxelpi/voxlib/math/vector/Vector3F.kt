package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3F
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3F

public interface Vector3F : Vector3<Float> {

    public fun length(): Float

    public fun lengthSquared(): Float

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
