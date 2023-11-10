package net.voxelpi.voxlib.math.matrix

/**
 * A generic mutable mxn matrix.
 */
public interface MutableMatrix<T : Number> : Matrix<T> {

    /**
     * Sets the element in the [row] row and [column] column of the matrix to the given [value].
     */
    public operator fun set(row: Int, column: Int, value: T)

    public operator fun plusAssign(other: Matrix<T>)

    public operator fun minusAssign(other: Matrix<T>)

    public operator fun timesAssign(scalar: T)

    public operator fun divAssign(scalar: T)

    /**
     * Sets all elements of the matrix to corresponding elements of [value].
     */
    public fun set(value: Matrix<T>)

    /**
     * Sets all elements of the matrix to [value].
     */
    public fun set(value: T)
}
