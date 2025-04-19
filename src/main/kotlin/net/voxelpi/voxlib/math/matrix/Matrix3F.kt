package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3F

/**
 * A 3x3 matrix using floats.
 * The memory of the matrix is stored in [data] in column major layout.
 */
public interface Matrix3F : Matrix3<Float> {

    /**
     * The data of the matrix.
     */
    public val data: FloatArray

    /**
     * Returns the element in at the given [index] of the matrix.
     */
    public operator fun get(index: Int): Float

    override operator fun plus(matrix: Matrix3<Float>): Matrix3F

    override operator fun minus(matrix: Matrix3<Float>): Matrix3F

    override operator fun times(matrix: Matrix3<Float>): Matrix3F

    override operator fun times(vector: Vector3<Float>): Vector3F

    override operator fun times(value: Float): Matrix3F

    override operator fun div(value: Float): Matrix3F

    override fun copy(): Matrix3F

    override fun mutableCopy(): MutableMatrix3F

    public companion object {

        public fun zero(): Matrix3F {
            return MutableMatrix3F(FloatArray(9) { 0F })
        }

        public fun identity(): Matrix3F {
            return MutableMatrix3F { row, column ->
                if (row == column) 1F else 0F
            }
        }

        public fun translation(translation: Vector3F): Matrix3F {
            return MutableMatrix3F(
                1F, 0F, translation.x,
                0F, 1F, translation.y,
                0F, 0F, 1F
            )
        }

        public fun scale(scale: Vector2F): Matrix3F {
            return MutableMatrix3F(
                scale.x, 0F, 0F,
                0F, scale.y, 0F,
                0F, 0F, 1F
            )
        }

        public fun scaleXY(scale: Float): Matrix3F {
            return MutableMatrix3F(
                scale, 0F, 0F,
                0F, scale, 0F,
                0F, 0F, 1F,
            )
        }
    }
}
