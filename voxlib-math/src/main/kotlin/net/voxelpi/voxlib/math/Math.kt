package net.voxelpi.voxlib.math

/**
 * Calculates ceil(a/b) as an integer.
 * This function can be used to calculate the number of pages required to display a collection
 * with a fixed number of entries per page.
 */
fun ceilIntDiv(dividend: Int, divisor: Int): Int {
    return dividend / divisor + if (dividend % divisor > 0) 1 else 0 // (num + divisor - 1) / divisor;
}
