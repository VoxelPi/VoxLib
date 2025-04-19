package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.MutableVector3F
import net.voxelpi.voxlib.math.vector.Vector3

/**
 * A mutable 3x3 matrix using floats.
 * The memory of the matrix is stored in [data] in column major layout.
 */
public data class MutableMatrix3F(
    override val data: FloatArray = FloatArray(9) { 0F },
) : Matrix3F, MutableMatrix3<Float> {

    init {
        require(data.size == 9) { "Data array has to be exactly 9 elements long." }
    }

    public constructor(init: (row: Int, column: Int) -> Float) : this(
        FloatArray(9) { index ->
            init(index and 0b11, (index shr 2) and 0b11)
        }
    )

    @Suppress("ktlint:standard:parameter-list-wrapping")
    public constructor(
        m00: Float, m01: Float, m02: Float,
        m10: Float, m11: Float, m12: Float,
        m20: Float, m21: Float, m22: Float,
    ) : this(floatArrayOf(m00, m10, m20, m01, m11, m21, m02, m12, m22))

    override fun get(row: Int, column: Int): Float {
        return data[row + 3 * column]
    }

    override fun get(index: Int): Float {
        return data[index]
    }

    override fun set(row: Int, column: Int, value: Float) {
        data[row + 3 * column] = value
    }

    public fun set(index: Int, value: Float) {
        data[index] = value
    }

    override fun set(value: Matrix3<Float>) {
        require(value is Matrix3F)
        value.data.copyInto(data)
    }

    override fun set(value: Float) {
        for (i in data.indices) {
            data[i] = value
        }
    }

    override fun plusAssign(matrix: Matrix3<Float>) {
        require(matrix is Matrix3F)
        for (i in data.indices) {
            data[i] += matrix[i]
        }
    }

    override fun minusAssign(matrix: Matrix3<Float>) {
        require(matrix is Matrix3F)
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

    override fun plus(matrix: Matrix3<Float>): MutableMatrix3F {
        require(matrix is Matrix3F)
        return MutableMatrix3F(
            FloatArray(9) { i ->
                data[i] + matrix[i]
            }
        )
    }

    override fun minus(matrix: Matrix3<Float>): MutableMatrix3F {
        require(matrix is Matrix3F)
        return MutableMatrix3F(
            FloatArray(9) { i ->
                data[i] - matrix[i]
            }
        )
    }

    override fun times(matrix: Matrix3<Float>): MutableMatrix3F {
        @Suppress("ktlint:standard:max-line-length")
        return MutableMatrix3F(
            FloatArray(9) { index ->
                val row = index and 0b11
                val column = (index shr 2) and 0b11
                this[row, 0] * matrix[0, column] + this[row, 1] * matrix[1, column] + this[row, 2] * matrix[2, column] + this[row, 3] * matrix[3, column]
            }
        )
    }

    override fun times(vector: Vector3<Float>): MutableVector3F {
        return MutableVector3F(
            this[0, 0] * vector.x + this[0, 1] * vector.y + this[0, 2] * vector.z,
            this[1, 0] * vector.x + this[1, 1] * vector.y + this[1, 2] * vector.z,
            this[2, 0] * vector.x + this[2, 1] * vector.y + this[2, 2] * vector.z,
        )
    }

    override fun times(value: Float): MutableMatrix3F {
        return MutableMatrix3F(
            FloatArray(9) { i ->
                data[i] * value
            }
        )
    }

    override fun div(value: Float): Matrix3F {
        return MutableMatrix3F(
            FloatArray(9) { i ->
                data[i] / value
            }
        )
    }

    override fun copy(): Matrix3F {
        return MutableMatrix3F(data.copyOf())
    }

    override fun mutableCopy(): MutableMatrix3F {
        return MutableMatrix3F(data.copyOf())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MutableMatrix3F

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
