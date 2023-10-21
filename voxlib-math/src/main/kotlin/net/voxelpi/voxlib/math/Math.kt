package net.voxelpi.voxlib.math

import net.voxelpi.voxlib.math.vector.Vector2D
import net.voxelpi.voxlib.math.vector.Vector3D
import kotlin.math.pow

/**
 * Calculates ceil(a/b) as an integer.
 * This function can be used to calculate the number of pages required to display a collection
 * with a fixed number of entries per page.
 */
fun ceilIntDiv(dividend: Int, divisor: Int): Int {
    return dividend / divisor + if (dividend % divisor > 0) 1 else 0 // (num + divisor - 1) / divisor;
}

/**
 * Linearly interpolates between the points [a] and [b] by [t].
 */
fun interpolateLinear(a: Double, b: Double, t: Double): Double {
    return a + (b - a) * t
}

/**
 * Linearly interpolates between the points [a] and [b] by [t].
 */
fun interpolateLinear(a: Vector2D, b: Vector2D, t: Double): Vector2D {
    return a + (b - a) * t
}

/**
 * Linearly interpolates between the points [a] and [b] by [t].
 */
fun interpolateLinear(a: Vector3D, b: Vector3D, t: Double): Vector3D {
    return a + (b - a) * t
}

/**
 * Exponentially interpolates between the points [a] and [b] by [t].
 */
fun interpolateExponential(a: Double, b: Double, t: Double): Double {
    return a.pow(1 - t) * b.pow(t)
}
