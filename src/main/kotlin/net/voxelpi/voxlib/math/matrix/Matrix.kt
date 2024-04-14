package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.Vector2
import net.voxelpi.voxlib.math.vector.Vector3
import net.voxelpi.voxlib.math.vector.Vector4

/**
 * A nxm matrix.
 */
public interface Matrix<T> where T : Number, T : Comparable<T> {

    /**
     * The number of rows of the matrix.
     */
    public val rows: Int

    /**
     * The number of columns of the matrix.
     */
    public val columns: Int

    /**
     * The shape of the matrix.
     */
    public val shape: Pair<Int, Int>
        get() = Pair(rows, columns)

    /**
     * The name of the shape of the matrix.
     */
    public val shapeName: String
        get() = "${rows}x${columns}"

    /**
     * Returns the element in the [row] row and [column] column of the matrix.
     */
    public operator fun get(row: Int, column: Int): T

    public operator fun unaryMinus(): Matrix<T>

    public operator fun unaryPlus(): Matrix<T>

    public operator fun plus(other: Matrix<T>): Matrix<T>

    public operator fun minus(other: Matrix<T>): Matrix<T>

    public operator fun times(scalar: T): Matrix<T>

    public operator fun div(scalar: T): Matrix<T>

    public operator fun times(matrix: Matrix<T>): Matrix<T>

    public operator fun times(vector: Vector<T>): Vector<T>

    public operator fun times(vector: Vector2<T>): Vector2<T>

    public operator fun times(vector: Vector3<T>): Vector3<T>

    public operator fun times(vector: Vector4<T>): Vector4<T>

    /**
     * Calculates the transpose matrix.
     */
    public fun transpose(): Matrix<T>

    /**
     * Creates an immutable copy of the matrix.
     */
    public fun copy(): Matrix<T>

    /**
     * Creates a mutable copy of the matrix.
     */
    public fun mutableCopy(): MutableMatrix<T>

    /**
     * Checks if the matrix is square.
     */
    public fun isSquare(): Boolean {
        return rows == columns
    }

    /**
     * Checks if the matrix is symmetric. (A^T = A)
     */
    public fun isSymmetric(): Boolean {
        if (!isSquare()) {
            return false
        }

        (1..<3).toList()

        for (row in 0..<(rows - 1)) {
            for (column in (row + 1)..<columns) {
                if (this[row, column] != this[column, row]) {
                    return false
                }
            }
        }

        return true
    }

    /**
     * Checks if the matrix is skew symmetric. (A^T = -A)
     */
    public fun isSkewSymmetric(): Boolean {
        if (!isSquare()) {
            return false
        }

        for (row in 0..<(rows - 1)) {
            for (column in (row + 1)..<columns) {
                if (this[row, column] != this[column, row]) {
                    return false
                }
            }
        }

        return true
    }
}
