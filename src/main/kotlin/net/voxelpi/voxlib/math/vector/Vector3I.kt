package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3I
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3I

public interface Vector3I : Vector3<Int> {

    public fun length(): Double

    public fun lengthSquared(): Int

    override fun unaryMinus(): Vector3I

    override fun unaryPlus(): Vector3I

    override fun plus(other: Vector3<Int>): Vector3I

    override fun minus(other: Vector3<Int>): Vector3I

    override fun times(scalar: Int): Vector3I

    override fun div(scalar: Int): Vector3I

    override fun copy(): Vector3I

    override fun mutableCopy(): MutableVector3I

    override fun position(): Position3I

    override fun position(origin: Position3<Int>): Position3I

    override fun mutablePosition(): MutablePosition3I

    override fun mutablePosition(origin: Position3<Int>): MutablePosition3I
}
