package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.Vector

public data class MutablePositionD(val data: DoubleArray) : PositionD, MutablePosition<Double> {

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

    override fun set(value: Position<Double>) {
        for (index in data.indices) {
            this[index] = value[index]
        }
    }

    override fun set(value: Double) {
        for (index in data.indices) {
            this[index] = value
        }
    }


    override fun plus(other: Vector<Double>): MutablePositionD {
        return MutablePositionD(size) { index ->
            this[index] + other[index]
        }
    }

    override fun minus(other: Vector<Double>): MutablePositionD {
        return MutablePositionD(size) { index ->
            this[index] - other[index]
        }
    }


    override fun copy(): PositionD {
        return MutablePositionD(data.copyOf())
    }

    override fun mutableCopy(): MutablePositionD {
        return MutablePositionD(data.copyOf())
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

        other as MutablePositionD

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}