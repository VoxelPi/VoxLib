package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.Vector3

/**
 * A 3x3 matrix.
 */
public interface Matrix3<T> where T : Number, T : Comparable<T> {

    /**
     * Returns the element in the [row] row and [column] column of the matrix.
     */
    public operator fun get(row: Int, column: Int): T

    public operator fun plus(matrix: Matrix3<T>): Matrix3<T>

    public operator fun minus(matrix: Matrix3<T>): Matrix3<T>

    public operator fun times(matrix: Matrix3<T>): Matrix3<T>

    public operator fun times(vector: Vector3<T>): Vector3<T>

    public operator fun times(value: T): Matrix3<T>

    public operator fun div(value: T): Matrix3<T>

    public fun copy(): Matrix3<T>

    public fun mutableCopy(): MutableMatrix3<T>
}
