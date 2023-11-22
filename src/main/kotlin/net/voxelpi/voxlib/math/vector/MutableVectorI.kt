package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionI
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionI
import kotlin.math.sqrt

public data class MutableVectorI(val data: IntArray) : VectorI, MutableVector<Int> {

    public constructor(size: Int, init: (Int) -> Int) : this(IntArray(size, init))

    override fun get(index: Int): Int {
        return data[index]
    }

    override val indices: IntRange
        get() = data.indices

    override val size: Int
        get() = data.size

    override fun set(index: Int, value: Int) {
        data[index] = value
    }

    override fun plusAssign(other: Vector<Int>) {
        for (index in data.indices) {
            this[index] += other[index]
        }
    }

    override fun minusAssign(other: Vector<Int>) {
        for (index in data.indices) {
            this[index] -= other[index]
        }
    }

    override fun timesAssign(scalar: Int) {
        for (index in data.indices) {
            this[index] *= scalar
        }
    }

    override fun divAssign(scalar: Int) {
        for (index in data.indices) {
            this[index] /= scalar
        }
    }

    override fun set(value: Vector<Int>) {
        for (index in data.indices) {
            this[index] = value[index]
        }
    }

    override fun set(value: Int) {
        for (index in data.indices) {
            this[index] = value
        }
    }

    override fun unaryMinus(): MutableVectorI {
        return MutableVectorI(size) { index ->
            -this[index]
        }
    }

    override fun unaryPlus(): MutableVectorI {
        return MutableVectorI(size) { index ->
            +this[index]
        }
    }

    override fun plus(other: Vector<Int>): MutableVectorI {
        return MutableVectorI(size) { index ->
            this[index] + other[index]
        }
    }

    override fun minus(other: Vector<Int>): MutableVectorI {
        return MutableVectorI(size) { index ->
            this[index] - other[index]
        }
    }

    override fun times(scalar: Int): MutableVectorI {
        return MutableVectorI(size) { index ->
            this[index] * scalar
        }
    }

    override fun div(scalar: Int): MutableVectorI {
        return MutableVectorI(size) { index ->
            this[index] / scalar
        }
    }

    override fun dot(other: Vector<Int>): Int {
        require(this.size == other.size) { "The two vectors must have the same length" }

        var sum = 0
        for (index in indices) {
            sum += this[index] * other[index]
        }
        return sum
    }

    override fun copy(): VectorI {
        return MutableVectorI(data.copyOf())
    }

    override fun mutableCopy(): MutableVectorI {
        return MutableVectorI(data.copyOf())
    }

    override fun position(): PositionI {
        return MutablePositionI(data)
    }

    override fun position(origin: Position<Int>): PositionI {
        return MutablePositionI(IntArray(size) { i -> origin[i] + data[i] })
    }

    override fun mutablePosition(): MutablePositionI {
        return MutablePositionI(data)
    }

    override fun mutablePosition(origin: Position<Int>): MutablePositionI {
        return MutablePositionI(IntArray(size) { i -> origin[i] + data[i] })
    }

    override fun length(): Double {
        var sum = 0
        for (index in indices) {
            sum += this[index] * this[index]
        }
        return sqrt(sum.toDouble())
    }

    override fun lengthSquared(): Int {
        var sum = 0
        for (index in indices) {
            sum += this[index] * this[index]
        }
        return sum
    }

    override fun normalized(): VectorD {
        return this.toDouble() / length()
    }

    override fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    override fun iterator(): Iterator<Int> {
        return data.iterator()
    }

    override fun containsAll(elements: Collection<Int>): Boolean {
        return elements.all { element -> data.any { it == element } }
    }

    override fun contains(element: Int): Boolean {
        return data.any { it == element }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MutableVectorI

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
