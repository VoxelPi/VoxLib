package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3F
import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4F
import net.voxelpi.voxlib.math.vector.VectorF

public interface MatrixF : Matrix<Float> {

    override fun unaryMinus(): MatrixF

    override fun unaryPlus(): MatrixF

    override fun plus(other: Matrix<Float>): MatrixF

    override fun minus(other: Matrix<Float>): MatrixF

    override fun times(scalar: Float): MatrixF

    override fun div(scalar: Float): MatrixF

    override fun times(matrix: Matrix<Float>): MatrixF

    override fun times(vector: Vector<Float>): VectorF

    override fun times(vector: Vector2<Float>): Vector2F

    override fun times(vector: Vector3<Float>): Vector3F

    override fun times(vector: Vector4<Float>): Vector4F

    override fun transpose(): MatrixF


    override fun copy(): MatrixF

    override fun mutableCopy(): MutableMatrixF
}
