package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVector4
import net.voxelpi.voxlib.math.vector.Vector4

/**
 * A position in a 4 dimensional space.
 */
public interface Position4<T : Number> {

    public val x: T

    public val y: T

    public val z: T

    public val w: T

    public operator fun component1(): T = x

    public operator fun component2(): T = y

    public operator fun component3(): T = z

    public operator fun component4(): T = z

    public operator fun plus(other: Vector4<T>): Position4<T>

    public operator fun minus(other: Vector4<T>): Position4<T>

    public operator fun minus(other: Position4<T>): Vector4<T>

    /**
     * Creates an immutable copy of the position.
     */
    public fun copy(): Position4<T>

    /**
     * Creates a mutable copy of the position.
     */
    public fun mutableCopy(): MutablePosition4<T>

    /**
     * Returns the offset from the origin as vector.
     */
    public fun vector(): Vector4<T>

    /**
     * Returns the offset from the origin as mutable vector.
     */
    public fun mutableVector(): MutableVector4<T>

    /**
     * Returns the value of this position as a Position4D, which may involve rounding.
     */
    public fun toDouble(): Position4D {
        return MutablePosition4D(x.toDouble(), y.toDouble(), z.toDouble(), w.toDouble())
    }

    /**
     * Returns the value of this position as a Position4F, which may involve rounding.
     */
    public fun toFloat(): Position4F {
        return MutablePosition4F(x.toFloat(), y.toFloat(), z.toFloat(), z.toFloat())
    }

    /**
     * Returns the value of this position as a Position4I, which may involve rounding or truncation.
     */
    public fun toInt(): Position4I {
        return MutablePosition4I(x.toInt(), y.toInt(), z.toInt(), w.toInt())
    }
}
