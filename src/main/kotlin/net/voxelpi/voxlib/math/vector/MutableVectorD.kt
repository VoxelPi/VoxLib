package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePositionD
import net.voxelpi.voxlib.math.position.Position
import net.voxelpi.voxlib.math.position.PositionD
import kotlin.math.pow
import kotlin.math.sqrt

public data class MutableVectorD(val data: DoubleArray) : VectorD, MutableVector<Double> {

    public constructor(size: Int, init: (Int) -> Double) : this(DoubleArray(size, init))

    override fun get(index: Int): Double {
        return data[index]
    }

    override val indices: IntRange
        get() = data.indices

    override val size: Int
        get() = data.size

    override fun set(index: Int, value: Double) {
        data[index] = value
    }

    override fun plusAssign(other: Vector<Double>) {
        for (index in data.indices) {
            this[index] += other[index]
        }
    }

    override fun minusAssign(other: Vector<Double>) {
        for (index in data.indices) {
            this[index] -= other[index]
        }
    }

    override fun timesAssign(scalar: Double) {
        for (index in data.indices) {
            this[index] *= scalar
        }
    }

    override fun divAssign(scalar: Double) {
        for (index in data.indices) {
            this[index] /= scalar
        }
    }

    override fun set(value: Vector<Double>) {
        for (index in data.indices) {
            this[index] = value[index]
        }
    }

    override fun set(value: Double) {
        for (index in data.indices) {
            this[index] = value
        }
    }

    override fun unaryMinus(): MutableVectorD {
        return MutableVectorD(size) { index ->
            -this[index]
        }
    }

    override fun unaryPlus(): MutableVectorD {
        return MutableVectorD(size) { index ->
            +this[index]
        }
    }

    override fun plus(other: Vector<Double>): MutableVectorD {
        return MutableVectorD(size) { index ->
            this[index] + other[index]
        }
    }

    override fun minus(other: Vector<Double>): MutableVectorD {
        return MutableVectorD(size) { index ->
            this[index] - other[index]
        }
    }

    override fun times(scalar: Double): MutableVectorD {
        return MutableVectorD(size) { index ->
            this[index] * scalar
        }
    }

    override fun div(scalar: Double): MutableVectorD {
        return MutableVectorD(size) { index ->
            this[index] / scalar
        }
    }

    override fun dot(other: Vector<Double>): Double {
        require(this.size == other.size) { "The two vectors must have the same length" }

        var sum = 0.0
        for (index in indices) {
            sum += this[index] * other[index]
        }
        return sum
    }

    override fun copy(): VectorD {
        return MutableVectorD(data.copyOf())
    }

    override fun mutableCopy(): MutableVectorD {
        return MutableVectorD(data.copyOf())
    }

    override fun position(): PositionD {
        return MutablePositionD(data)
    }

    override fun position(origin: Position<Double>): PositionD {
        return MutablePositionD(DoubleArray(size) { i -> origin[i] + data[i] })
    }

    override fun mutablePosition(): MutablePositionD {
        return MutablePositionD(data)
    }

    override fun mutablePosition(origin: Position<Double>): MutablePositionD {
        return MutablePositionD(DoubleArray(size) { i -> origin[i] + data[i] })
    }

    override fun length(): Double {
        var sum = 0.0
        for (index in indices) {
            sum += this[index].pow(2)
        }
        return sqrt(sum)
    }

    override fun lengthSquared(): Double {
        var sum = 0.0
        for (index in indices) {
            sum += this[index].pow(2)
        }
        return sum
    }

    override fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    override fun iterator(): Iterator<Double> {
        return data.iterator()
    }

    override fun containsAll(elements: Collection<Double>): Boolean {
        return elements.all { element -> data.any { it == element } }
    }

    override fun contains(element: Double): Boolean {
        return data.any { it == element }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MutableVectorD

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
