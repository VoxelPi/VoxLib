package net.voxelpi.voxlib.math.matrix

import net.voxelpi.voxlib.math.vector.Vector4

/**
 * A 4x4 matrix.
 */
public interface Matrix4<T> where T : Number, T : Comparable<T> {

    /**
     * Returns the element in the [row] row and [column] column of the matrix.
     */
    public operator fun get(row: Int, column: Int): T

    public operator fun plus(matrix: Matrix4<T>): Matrix4<T>

    public operator fun minus(matrix: Matrix4<T>): Matrix4<T>

    public operator fun times(matrix: Matrix4<T>): Matrix4<T>

    public operator fun times(vector: Vector4<T>): Vector4<T>

    public operator fun times(value: T): Matrix4<T>

    public operator fun div(value: T): Matrix4<T>

    public fun copy(): Matrix4<T>

    public fun mutableCopy(): MutableMatrix4<T>
}
