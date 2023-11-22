package net.voxelpi.voxlib.math.position

import net.voxelpi.voxlib.math.vector.MutableVectorF
import net.voxelpi.voxlib.math.vector.Vector
import net.voxelpi.voxlib.math.vector.VectorF

public data class MutablePositionF(val data: FloatArray) : PositionF, MutablePosition<Float> {

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

    override fun set(value: Position<Float>) {
        for (index in data.indices) {
            this[index] = value[index]
        }
    }

    override fun set(value: Float) {
        for (index in data.indices) {
            this[index] = value
        }
    }

    override fun plus(other: Vector<Float>): MutablePositionF {
        return MutablePositionF(size) { index ->
            this[index] + other[index]
        }
    }

    override fun minus(other: Vector<Float>): MutablePositionF {
        return MutablePositionF(size) { index ->
            this[index] - other[index]
        }
    }

    override fun minus(other: Position<Float>): VectorF {
        return MutableVectorF(size) { index ->
            this[index] - other[index]
        }
    }

    override fun to(position: Position<Float>): VectorF {
        return MutableVectorF(size) { index ->
            position[index] - this[index]
        }
    }

    override fun copy(): PositionF {
        return MutablePositionF(data.copyOf())
    }

    override fun mutableCopy(): MutablePositionF {
        return MutablePositionF(data.copyOf())
    }

    override fun vector(): VectorF {
        return MutableVectorF(data.copyOf())
    }

    override fun mutableVector(): MutableVectorF {
        return MutableVectorF(data.copyOf())
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

        other as MutablePositionF

        return data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}
