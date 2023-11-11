package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.MutableVector4F
import net.voxelpi.voxlib.math.vector.Vector4

public data class MutableMatrix4F(
    override val data: FloatArray = FloatArray(16) { 0F },
) : Matrix4F, MutableMatrix4<Float> {

    init {
        require(data.size == 16) { "Data array has to be exactly 16 elements long." }
    }

    public constructor(init: (row: Int, column: Int) -> Float) : this(
        FloatArray(16) { index ->
            init(index and 0b11, (index shr 2) and 0b11)
        }
    )

    @Suppress("ktlint:standard:parameter-list-wrapping")
    public constructor(
        m00: Float, m01: Float, m02: Float, m03: Float,
        m10: Float, m11: Float, m12: Float, m13: Float,
        m20: Float, m21: Float, m22: Float, m23: Float,
        m30: Float, m31: Float, m32: Float, m33: Float,
    ) : this(floatArrayOf(m00, m10, m20, m30, m01, m11, m21, m31, m02, m12, m22, m32, m03, m13, m23, m33))

    override fun get(row: Int, column: Int): Float {
        return data[row + 4 * column]
    }

    override fun get(index: Int): Float {
        return data[index]
    }

    override fun set(row: Int, column: Int, value: Float) {
        data[row + 4 * column] = value
    }

    public fun set(index: Int, value: Float) {
        data[index] = value
    }

    override fun set(value: Matrix4<Float>) {
        require(value is Matrix4F)
        value.data.copyInto(data)
    }

    override fun set(value: Float) {
        for (i in data.indices) {
            data[i] = value
        }
    }

    override fun plusAssign(matrix: Matrix4<Float>) {
        require(matrix is Matrix4F)
        for (i in data.indices) {
            data[i] += matrix[i]
        }
    }

    override fun minusAssign(matrix: Matrix4<Float>) {
        require(matrix is Matrix4F)
        for (i in data.indices) {
            data[i] -= matrix[i]
        }
    }

    override fun timesAssign(value: Float) {
        for (i in data.indices) {
            data[i] *= value
        }
    }

    override fun divAssign(value: Float) {
        for (i in data.indices) {
            data[i] /= value
        }
    }

    override fun plus(matrix: Matrix4<Float>): MutableMatrix4F {
        require(matrix is Matrix4F)
        return MutableMatrix4F(
            FloatArray(16) { i ->
                data[i] + matrix[i]
            }
        )
    }

    override fun minus(matrix: Matrix4<Float>): MutableMatrix4F {
        require(matrix is Matrix4F)
        return MutableMatrix4F(
            FloatArray(16) { i ->
                data[i] - matrix[i]
            }
        )
    }

    override fun times(matrix: Matrix4<Float>): MutableMatrix4F {
        @Suppress("ktlint:standard:max-line-length")
        return MutableMatrix4F(
            FloatArray(16) { index ->
                val row = index and 0b11
                val column = (index shr 2) and 0b11
                this[row, 0] * matrix[0, column] + this[row, 1] * matrix[1, column] + this[row, 2] * matrix[2, column] + this[row, 3] * matrix[3, column]
            }
        )
    }

    override fun times(vector: Vector4<Float>): MutableVector4F {
        return MutableVector4F(
            this[0, 0] * vector.x + this[0, 1] * vector.y + this[0, 2] * vector.z + this[0, 3] * vector.w,
            this[1, 0] * vector.x + this[1, 1] * vector.y + this[1, 2] * vector.z + this[1, 3] * vector.w,
            this[2, 0] * vector.x + this[2, 1] * vector.y + this[2, 2] * vector.z + this[2, 3] * vector.w,
            this[3, 0] * vector.x + this[3, 1] * vector.y + this[3, 2] * vector.z + this[3, 3] * vector.w,
        )
    }

    override fun times(value: Float): MutableMatrix4F {
        return MutableMatrix4F(
            FloatArray(16) { i ->
                data[i] * value
            }
        )
    }

    override fun div(value: Float): Matrix4F {
        return MutableMatrix4F(
            FloatArray(16) { i ->
                data[i] / value
            }
        )
    }

    override fun copy(): Matrix4F {
        return MutableMatrix4F(data.copyOf())
    }

    override fun mutableCopy(): MutableMatrix4F {
        return MutableMatrix4F(data.copyOf())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MutableMatrix4F

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
