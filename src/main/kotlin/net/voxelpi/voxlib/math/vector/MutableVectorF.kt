package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionF
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionF
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVectorF(val data: FloatArray) : VectorF, MutableVector<Float> {

    public constructor(size: Int, init: (Int) -> Float) : this(FloatArray(size, init))

    override fun get(index: Int): Float {
        return data[index]
    }

    override val indices: IntRange
        get() = data.indices

    override val size: Int
        get() = data.size

    override fun set(index: Int, value: Float) {
        data[index] = value
    }

    override fun plusAssign(other: Vector<Float>) {
        for (index in data.indices) {
            this[index] += other[index]
        }
    }

    override fun minusAssign(other: Vector<Float>) {
        for (index in data.indices) {
            this[index] -= other[index]
        }
    }

    override fun timesAssign(scalar: Float) {
        for (index in data.indices) {
            this[index] *= scalar
        }
    }

    override fun divAssign(scalar: Float) {
        for (index in data.indices) {
            this[index] /= scalar
        }
    }

    override fun set(value: Vector<Float>) {
        for (index in data.indices) {
            this[index] = value[index]
        }
    }

    override fun set(value: Float) {
        for (index in data.indices) {
            this[index] = value
        }
    }

    override fun unaryMinus(): MutableVectorF {
        return MutableVectorF(size) { index ->
            -this[index]
        }
    }

    override fun unaryPlus(): MutableVectorF {
        return MutableVectorF(size) { index ->
            +this[index]
        }
    }

    override fun plus(other: Vector<Float>): MutableVectorF {
        return MutableVectorF(size) { index ->
            this[index] + other[index]
        }
    }

    override fun minus(other: Vector<Float>): MutableVectorF {
        return MutableVectorF(size) { index ->
            this[index] - other[index]
        }
    }

    override fun times(scalar: Float): MutableVectorF {
        return MutableVectorF(size) { index ->
            this[index] * scalar
        }
    }

    override fun div(scalar: Float): MutableVectorF {
        return MutableVectorF(size) { index ->
            this[index] / scalar
        }
    }

    override fun dot(other: Vector<Float>): Float {
        require(this.size == other.size) { "The two vectors must have the same length" }

        var sum = 0F
        for (index in indices) {
            sum += this[index] * other[index]
        }
        return sum
    }

    override fun copy(): VectorF {
        return MutableVectorF(data.copyOf())
    }

    override fun mutableCopy(): MutableVectorF {
        return MutableVectorF(data.copyOf())
    }

    override fun position(): PositionF {
        return MutablePositionF(data)
    }

    override fun position(origin: Position<Float>): PositionF {
        return MutablePositionF(FloatArray(size) { i -> origin[i] + data[i] })
    }

    override fun mutablePosition(): MutablePositionF {
        return MutablePositionF(data)
    }

    override fun mutablePosition(origin: Position<Float>): MutablePositionF {
        return MutablePositionF(FloatArray(size) { i -> origin[i] + data[i] })
    }

    override fun length(): Float {
        var sum = 0F
        for (index in indices) {
            sum += this[index].pow(2)
        }
        return sqrt(sum)
    }

    override fun lengthSquared(): Float {
        var sum = 0F
        for (index in indices) {
            sum += this[index].pow(2)
        }
        return sum
    }

    override fun normalized(): VectorF {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVectorF {
        this /= length()
        return this
    }

    override fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    override fun iterator(): Iterator<Float> {
        return data.iterator()
    }

    override fun containsAll(elements: Collection<Float>): Boolean {
        return elements.all { element -> data.any { it == element } }
    }

    override fun contains(element: Float): Boolean {
        return data.any { it == element }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MutableVectorF

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(vararg data: Float): MutableVectorF {
            return MutableVectorF(data)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(size: Int, value: Float): MutableVectorF {
            return MutableVectorF(size) { value }
        }

        /**
         * Generates a random vector.
         */
        public fun random(size: Int): MutableVectorF {
            return MutableVectorF(size) {
                Random.nextFloat()
            }
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(size: Int, from: Float, until: Float): MutableVectorF {
            return MutableVectorF(size) {
                Random.nextFloat() * (until - from) + from
            }
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(size: Int, from: Vector<Float>, until: Vector<Float>): MutableVectorF {
            return MutableVectorF(size) { i ->
                Random.nextFloat() * (until[i] - from[i]) + from[i]
            }
        }
    }
}
