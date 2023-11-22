package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector2D
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2D

public interface Position2D : Position2<Double> {

    override fun plus(other: Vector2<Double>): Position2D

    override fun minus(other: Vector2<Double>): Position2D

    override fun minus(other: Position2<Double>): Vector2D

    override fun copy(): Position2D

    override fun mutableCopy(): MutablePosition2D

    override fun vector(): Vector2D

    override fun mutableVector(): MutableVector2D
}
