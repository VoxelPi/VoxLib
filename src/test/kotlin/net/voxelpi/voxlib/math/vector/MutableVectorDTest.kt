package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class MutableVectorDTest {

    @Test
    fun get() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        assertEquals(2.0, vector[0])
        assertEquals(3.0, vector[1])
        assertEquals(-1.0, vector[2])

        assertThrows<IndexOutOfBoundsException> { vector[-1] }
        assertThrows<IndexOutOfBoundsException> { vector[3] }
    }

    @Test
    fun set() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        vector[1] = -4.5

        assertEquals(2.0, vector[0])
        assertEquals(-4.5, vector[1])
        assertEquals(-1.0, vector[2])
    }

    @Test
    fun getIndices() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        assertEquals(IntRange(0, 2), vector.indices)
    }

    @Test
    fun getSize() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        assertEquals(3, vector.size)
    }

    @Test
    fun plusAssign() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = MutableVectorD(doubleArrayOf(1.0, -2.5, 3.0))

        vectorA += vectorB

        assertEquals(3.0, vectorA[0])
        assertEquals(0.5, vectorA[1])
        assertEquals(2.0, vectorA[2])
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = MutableVectorD(doubleArrayOf(1.0, -2.5, 3.0))

        vectorA -= vectorB

        assertEquals(1.0, vectorA[0])
        assertEquals(5.5, vectorA[1])
        assertEquals(-4.0, vectorA[2])
    }

    @Test
    fun timesAssign() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        vector *= 0.5

        assertEquals(1.0, vector[0])
        assertEquals(1.5, vector[1])
        assertEquals(-0.5, vector[2])
    }

    @Test
    fun divAssign() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        vector /= 0.5

        assertEquals(4.0, vector[0])
        assertEquals(6.0, vector[1])
        assertEquals(-2.0, vector[2])
    }

    @Test
    fun setValue() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        vector.set(2.0)

        assertEquals(2.0, vector[0])
        assertEquals(2.0, vector[1])
        assertEquals(2.0, vector[2])
    }

    @Test
    fun setVector() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = MutableVectorD(doubleArrayOf(1.0, -2.5, 3.0))

        vectorA.set(vectorB)

        assertEquals(vectorB[0], vectorA[0])
        assertEquals(vectorB[1], vectorA[1])
        assertEquals(vectorB[2], vectorA[2])
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        val result = -vector

        assertEquals(-2.0, result[0])
        assertEquals(-3.0, result[1])
        assertEquals(1.0, result[2])
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        val result = +vector

        assertEquals(+2.0, result[0])
        assertEquals(+3.0, result[1])
        assertEquals(+(-1.0), result[2])
    }

    @Test
    fun plus() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = MutableVectorD(doubleArrayOf(1.0, -2.5, 3.0))

        val result = vectorA + vectorB

        assertEquals(3.0, result[0])
        assertEquals(0.5, result[1])
        assertEquals(2.0, result[2])
    }

    @Test
    fun minus() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = MutableVectorD(doubleArrayOf(1.0, -2.5, 3.0))

        val result = vectorA - vectorB

        assertEquals(1.0, result[0])
        assertEquals(5.5, result[1])
        assertEquals(-4.0, result[2])
    }

    @Test
    fun times() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        val result = vector * 0.5

        assertEquals(1.0, result[0])
        assertEquals(1.5, result[1])
        assertEquals(-0.5, result[2])
    }

    @Test
    fun div() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))

        val result = vector / 0.5

        assertEquals(4.0, result[0])
        assertEquals(6.0, result[1])
        assertEquals(-2.0, result[2])
    }

    @Test
    fun dot() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = MutableVectorD(doubleArrayOf(1.0, -2.5, 3.0))

        val result = vectorA dot vectorB

        assertEquals(-8.5, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = vectorA.copy()

        assertEquals(vectorA[0], vectorB[0])
        assertEquals(vectorA[1], vectorB[1])
        assertEquals(vectorA[2], vectorB[2])
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val vectorB = vectorA.mutableCopy()
        vectorB[1] = 2.5

        assertEquals(vectorA[0], vectorB[0])
        assertEquals(2.5, vectorB[1])
        assertEquals(vectorA[2], vectorB[2])
    }

    @Test
    fun length() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        assertEquals(3.7416573867739413, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        assertEquals(14.0, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVectorD(doubleArrayOf(2.0, 3.0, -1.0))
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1.0, normalized.length())
        for (i in vector.data.indices) {
            assertEquals(vector[i] / length, normalized[i])
        }
    }

    @Test
    fun normalize() {
        val data = doubleArrayOf(2.0, 3.0, -1.0)
        val normalized = MutableVectorD(data.copyOf())
        val length = normalized.length()
        normalized.normalize()
        assertEquals(1.0, normalized.length())
        for (i in data.indices) {
            assertEquals(data[i] / length, normalized[i])
        }
    }
}
