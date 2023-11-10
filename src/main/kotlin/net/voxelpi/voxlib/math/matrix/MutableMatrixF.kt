package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.MutableVector2F
import net.voxelpi.voxlib.math.vector.MutableVector3F
import net.voxelpi.voxlib.math.vector.MutableVector4F
import net.voxelpi.voxlib.math.vector.MutableVectorF
import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector3F
import net.voxelpi.voxlib.math.vector.Vector4
import net.voxelpi.voxlib.math.vector.Vector4F
import net.voxelpi.voxlib.math.vector.VectorF

public data class MutableMatrixF(
    override val rows: Int,
    override val columns: Int,
    val data: FloatArray,
) : MatrixF, MutableMatrix<Float> {

    public constructor(rows: Int, columns: Int, init: (Int, Int) -> Float) : this(
        rows,
        columns,
        FloatArray(rows * columns) { index ->
            init(index / columns, index % columns)
        }
    )

    override fun get(row: Int, column: Int): Float {
        require(row in 0..<rows)
        require(column in 0..<columns)
        return data[row * columns + column]
    }

    override fun set(row: Int, column: Int, value: Float) {
        require(row in 0..<rows)
        require(column in 0..<columns)
        data[row * columns + column] = value
    }

    override fun set(value: Matrix<Float>) {
        for (row in 0..<rows) {
            for (column in 0..<columns) {
                this[row, column] = value[row, column]
            }
        }
    }

    override fun set(value: Float) {
        for (index in data.indices) {
            data[index] = value
        }
    }

    override fun plusAssign(other: Matrix<Float>) {
        for (row in 0..<rows) {
            for (column in 0..<columns) {
                this[row, column] += other[row, column]
            }
        }
    }

    override fun minusAssign(other: Matrix<Float>) {
        for (row in 0..<rows) {
            for (column in 0..<columns) {
                this[row, column] -= other[row, column]
            }
        }
    }

    override fun timesAssign(scalar: Float) {
        for (index in data.indices) {
            data[index] *= scalar
        }
    }

    override fun divAssign(scalar: Float) {
        for (index in data.indices) {
            data[index] /= scalar
        }
    }

    override fun unaryMinus(): MutableMatrixF {
        return MutableMatrixF(rows, columns) { row, column ->
            -this[row, column]
        }
    }

    override fun unaryPlus(): MutableMatrixF {
        return MutableMatrixF(rows, columns) { row, column ->
            -this[row, column]
        }
    }

    override fun plus(other: Matrix<Float>): MutableMatrixF {
        return MutableMatrixF(rows, columns) { row, column ->
            this[row, column] + other[row, column]
        }
    }

    override fun minus(other: Matrix<Float>): MutableMatrixF {
        return MutableMatrixF(rows, columns) { row, column ->
            this[row, column] - other[row, column]
        }
    }

    override fun times(scalar: Float): MutableMatrixF {
        return MutableMatrixF(rows, columns, FloatArray(data.size) { index -> data[index] * scalar })
    }

    override fun div(scalar: Float): MutableMatrixF {
        return MutableMatrixF(rows, columns, FloatArray(data.size) { index -> data[index] / scalar })
    }

    override fun times(matrix: Matrix<Float>): MutableMatrixF {
        require(this.columns == matrix.rows) { "Incompatible matrices. Can't multiply a $shapeName matrix with a $shapeName matrix" }

        return MutableMatrixF(this.rows, matrix.columns) { row, column ->
            var sum = 0F
            for (k in 0..<this.columns) {
                sum += this[row, k] * matrix[k, column]
            }
            sum
        }
    }

    override fun times(vector: Vector<Float>): VectorF {
        require(this.columns == vector.size) {
            "Incompatible matrices. Can't multiply a $shapeName matrix with a ${vector.size}x1 column vector"
        }

        return MutableVectorF(this.rows) { row ->
            var sum = 0F
            for (k in 0..<this.columns) {
                sum += this[row, k] * vector[k]
            }
            sum
        }
    }

    override fun times(vector: Vector2<Float>): Vector2F {
        require(this.isSquare())
        require(this.columns == 2) { "Incompatible matrices. Can't multiply a $shapeName matrix with a 2x1 column vector" }

        var x = 0F
        var y = 0F
        for (k in 0..<this.columns) {
            x += this[0, k] * vector.x
            y += this[1, k] * vector.y
        }

        return MutableVector2F(x, y)
    }

    override fun times(vector: Vector3<Float>): Vector3F {
        require(this.isSquare())
        require(this.columns == 3) { "Incompatible matrices. Can't multiply a $shapeName matrix with a 3x1 column vector" }

        var x = 0F
        var y = 0F
        var z = 0F
        for (k in 0..<this.columns) {
            x += this[0, k] * vector.x
            y += this[1, k] * vector.y
            z += this[2, k] * vector.z
        }

        return MutableVector3F(x, y, z)
    }

    override fun times(vector: Vector4<Float>): Vector4F {
        require(this.isSquare())
        require(this.columns == 4) { "Incompatible matrices. Can't multiply a $shapeName matrix with a 4x1 column vector" }

        var x = 0F
        var y = 0F
        var z = 0F
        var w = 0F
        for (k in 0..<this.columns) {
            x += this[0, k] * vector.x
            y += this[1, k] * vector.y
            z += this[2, k] * vector.z
            w += this[3, k] * vector.w
        }

        return MutableVector4F(x, y, z, w)
    }

    override fun transpose(): MatrixF {
        return MutableMatrixF(columns, rows) { row, column ->
            this[column, row]
        }
    }

    override fun copy(): MatrixF {
        return MutableMatrixF(rows, columns, data.copyOf())
    }

    override fun mutableCopy(): MutableMatrixF {
        return MutableMatrixF(rows, columns, data.copyOf())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MutableMatrixF

        if (rows != other.rows) return false
        if (columns != other.columns) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rows
        result = 31 * result + columns
        result = 31 * result + data.contentHashCode()
        return result
    }
}
