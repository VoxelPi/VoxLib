package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVectorI
import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.VectorI

public data class MutablePositionI(val data: IntArray) : PositionI, MutablePosition<Int> {

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

    override fun set(value: Position<Int>) {
        for (index in data.indices) {
            this[index] = value[index]
        }
    }

    override fun set(value: Int) {
        for (index in data.indices) {
            this[index] = value
        }
    }

    override fun plus(other: Vector<Int>): MutablePositionI {
        return MutablePositionI(size) { index ->
            this[index] + other[index]
        }
    }

    override fun minus(other: Vector<Int>): MutablePositionI {
        return MutablePositionI(size) { index ->
            this[index] - other[index]
        }
    }

    override fun minus(other: Position<Int>): VectorI {
        return MutableVectorI(size) { index ->
            this[index] - other[index]
        }
    }

    override fun copy(): PositionI {
        return MutablePositionI(data.copyOf())
    }

    override fun mutableCopy(): MutablePositionI {
        return MutablePositionI(data.copyOf())
    }

    override fun vector(): VectorI {
        return MutableVectorI(data.copyOf())
    }

    override fun mutableVector(): MutableVectorI {
        return MutableVectorI(data.copyOf())
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

        other as MutablePositionI

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
