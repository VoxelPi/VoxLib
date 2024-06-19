package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.quaternion.QuaternionF
import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.Vector3F
import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4F
import kotlin.math.tan

/**
 * A 4x4 matrix using floats.
 * The memory of the matrix is stored in [data] in column major layout.
 */
public interface Matrix4F : Matrix4<Float> {

    /**
     * The data of the matrix.
     */
    public val data: FloatArray

    /**
     * Returns the element in at the given [index] of the matrix.
     */
    public operator fun get(index: Int): Float

    override operator fun plus(matrix: Matrix4<Float>): Matrix4F

    override operator fun minus(matrix: Matrix4<Float>): Matrix4F

    override operator fun times(matrix: Matrix4<Float>): Matrix4F

    override operator fun times(vector: Vector4<Float>): Vector4F

    override operator fun times(value: Float): Matrix4F

    override operator fun div(value: Float): Matrix4F

    override fun copy(): Matrix4F

    override fun mutableCopy(): MutableMatrix4F

    public companion object {

        public fun zero(): Matrix4F {
            return MutableMatrix4F(FloatArray(16) { 0F })
        }

        public fun identity(): Matrix4F {
            return MutableMatrix4F { row, column ->
                if (row == column) 1F else 0F
            }
        }

        public fun translationXYZ(translation: Vector3F): Matrix4F {
            return MutableMatrix4F(
                1F, 0F, 0F, translation.x,
                0F, 1F, 0F, translation.y,
                0F, 0F, 1F, translation.z,
                0F, 0F, 0F, 1F
            )
        }

        public fun translationXY(translation: Vector2F): Matrix4F {
            return MutableMatrix4F(
                1F, 0F, 0F, translation.x,
                0F, 1F, 0F, translation.y,
                0F, 0F, 1F, 0F,
                0F, 0F, 0F, 1F
            )
        }

        public fun scaleXYZ(scale: Vector3F): Matrix4F {
            return MutableMatrix4F(
                scale.x, 0F, 0F, 0F,
                0F, scale.y, 0F, 0F,
                0F, 0F, scale.z, 0F,
                0F, 0F, 0F, 1F
            )
        }

        public fun scaleXYZ(scale: Float): Matrix4F {
            return MutableMatrix4F(
                scale, 0F, 0F, 0F,
                0F, scale, 0F, 0F,
                0F, 0F, scale, 0F,
                0F, 0F, 0F, 1F
            )
        }

        public fun scaleXY(scale: Vector2F): Matrix4F {
            return MutableMatrix4F(
                scale.x, 0F, 0F, 0F,
                0F, scale.y, 0F, 0F,
                0F, 0F, 1F, 0F,
                0F, 0F, 0F, 1F
            )
        }

        public fun scaleXY(scale: Float): Matrix4F {
            return MutableMatrix4F(
                scale, 0F, 0F, 0F,
                0F, scale, 0F, 0F,
                0F, 0F, 1F, 0F,
                0F, 0F, 0F, 1F
            )
        }

        public fun rotation(quaternion: QuaternionF): Matrix4F {
            val x = quaternion.x
            val y = quaternion.y
            val z = quaternion.z
            val w = quaternion.w

            @Suppress("ktlint:standard:no-multi-spaces")
            return matrix4F(
                1 - 2 * y * y - 2 * z * z, 2 * x * y - 2 * w * z,     2 * x * z + 2 * w * y,     0F,
                2 * x * y + 2 * w * z,     1 - 2 * x * x - 2 * z * z, 2 * y * z - 2 * w * x,     0F,
                2 * x * z - 2 * w * y,     2 * y * z + 2 * w * x,     1 - 2 * x * x - 2 * y * y, 0F,
                0F,                        0F,                        0F,                        1F
            )
        }

        public fun orthographicProjection2D(
            left: Float,
            right: Float,
            bottom: Float,
            top: Float,
            zNear: Float = 1F,
            zFar: Float = -1F,
        ): Matrix4F {
            @Suppress("ktlint:standard:no-multi-spaces")
            return MutableMatrix4F(
                2F / (right - left), 0F,                   0F,                  (right + left) / (left - right),
                0F,                  2F / (top - bottom),  0F,                  (top + bottom) / (bottom - top),
                0F,                  0F,                   2F / (zFar - zNear), (zNear + zFar) / (zNear - zFar),
                0F,                  0F,                   0F,                  1F
            )
        }

        public fun orthographicProjectionInv2D(
            left: Float,
            right: Float,
            bottom: Float,
            top: Float,
            zNear: Float = 1F,
            zFar: Float = -1F,
        ): Matrix4F {
            @Suppress("ktlint:standard:no-multi-spaces")
            return MutableMatrix4F(
                (right - left) / 2F, 0F,                   0F,                  -(right + left) / (left - right),
                0F,                  (top - bottom) / 2F,  0F,                  -(top + bottom) / (bottom - top),
                0F,                  0F,                   (zFar - zNear) / 2F, -(zNear + zFar) / (zNear - zFar),
                0F,                  0F,                   0F,                  1F
            )
        }

        public fun perspectiveProjection(fov: Float, aspectRatio: Float, zNear: Float, zFar: Float): Matrix4F {
            val matrix = MutableMatrix4F()
            val h = tan(fov * 0.5F)
            matrix[0, 0] = 1F / (h * aspectRatio)
            matrix[1, 1] = 1F / h
            matrix[2, 2] = (zFar + zNear) / (zNear - zFar)
            matrix[2, 3] = (zFar + zFar) * zNear / (zNear - zFar)
            matrix[3, 2] = -1F
            return matrix
        }
    }
}
