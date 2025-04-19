package net.voxelpi.voxlib.math.matrix

/**
 * A mutable 3x3 matrix.
 */
public interface MutableMatrix3<T> : Matrix3<T> where T : Number, T : Comparable<T> {

    /**
     * Sets the element in the [row] row and [column] column of the matrix to the given [value].
     */
    public operator fun set(row: Int, column: Int, value: T)

    /**
     * Sets all elements of the matrix to corresponding elements of [value].
     */
    public fun set(value: Matrix3<T>)

    /**
     * Sets all elements of the matrix to [value].
     */
    public fun set(value: T)

    public operator fun plusAssign(matrix: Matrix3<T>)

    public operator fun minusAssign(matrix: Matrix3<T>)

    public operator fun timesAssign(value: T)

    public operator fun divAssign(value: T)
}
