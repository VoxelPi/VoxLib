package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class MutableVectorFTest {

    @Test
    fun get() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        assertEquals(2F, vector[0])
        assertEquals(3F, vector[1])
        assertEquals(-1F, vector[2])

        assertThrows<IndexOutOfBoundsException> { vector[-1] }
        assertThrows<IndexOutOfBoundsException> { vector[3] }
    }

    @Test
    fun set() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        vector[1] = -4.5F

        assertEquals(2F, vector[0])
        assertEquals(-4.5F, vector[1])
        assertEquals(-1F, vector[2])
    }

    @Test
    fun getIndices() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        assertEquals(IntRange(0, 2), vector.indices)
    }

    @Test
    fun getSize() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        assertEquals(3, vector.size)
    }

    @Test
    fun plusAssign() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = MutableVectorF(floatArrayOf(1F, -2.5F, 3F))

        vectorA += vectorB

        assertEquals(3F, vectorA[0])
        assertEquals(0.5F, vectorA[1])
        assertEquals(2F, vectorA[2])
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = MutableVectorF(floatArrayOf(1F, -2.5F, 3F))

        vectorA -= vectorB

        assertEquals(1F, vectorA[0])
        assertEquals(5.5F, vectorA[1])
        assertEquals(-4F, vectorA[2])
    }

    @Test
    fun timesAssign() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        vector *= 0.5F

        assertEquals(1F, vector[0])
        assertEquals(1.5F, vector[1])
        assertEquals(-0.5F, vector[2])
    }

    @Test
    fun divAssign() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        vector /= 0.5F

        assertEquals(4F, vector[0])
        assertEquals(6F, vector[1])
        assertEquals(-2F, vector[2])
    }

    @Test
    fun setValue() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        vector.set(2F)

        assertEquals(2F, vector[0])
        assertEquals(2F, vector[1])
        assertEquals(2F, vector[2])
    }

    @Test
    fun setVector() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = MutableVectorF(floatArrayOf(1F, -2.5F, 3F))

        vectorA.set(vectorB)

        assertEquals(vectorB[0], vectorA[0])
        assertEquals(vectorB[1], vectorA[1])
        assertEquals(vectorB[2], vectorA[2])
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        val result = -vector

        assertEquals(-2F, result[0])
        assertEquals(-3F, result[1])
        assertEquals(1F, result[2])
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        val result = +vector

        assertEquals(+2F, result[0])
        assertEquals(+3F, result[1])
        assertEquals(+(-1F), result[2])
    }

    @Test
    fun plus() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = MutableVectorF(floatArrayOf(1F, -2.5F, 3F))

        val result = vectorA + vectorB

        assertEquals(3F, result[0])
        assertEquals(0.5F, result[1])
        assertEquals(2F, result[2])
    }

    @Test
    fun minus() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = MutableVectorF(floatArrayOf(1F, -2.5F, 3F))

        val result = vectorA - vectorB

        assertEquals(1F, result[0])
        assertEquals(5.5F, result[1])
        assertEquals(-4F, result[2])
    }

    @Test
    fun times() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        val result = vector * 0.5F

        assertEquals(1F, result[0])
        assertEquals(1.5F, result[1])
        assertEquals(-0.5F, result[2])
    }

    @Test
    fun div() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))

        val result = vector / 0.5F

        assertEquals(4F, result[0])
        assertEquals(6F, result[1])
        assertEquals(-2F, result[2])
    }

    @Test
    fun dot() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = MutableVectorF(floatArrayOf(1F, -2.5F, 3F))

        val result = vectorA dot vectorB

        assertEquals(-8.5F, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = vectorA.copy()

        assertEquals(vectorA[0], vectorB[0])
        assertEquals(vectorA[1], vectorB[1])
        assertEquals(vectorA[2], vectorB[2])
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val vectorB = vectorA.mutableCopy()
        vectorB[1] = 2.5F

        assertEquals(vectorA[0], vectorB[0])
        assertEquals(2.5F, vectorB[1])
        assertEquals(vectorA[2], vectorB[2])
    }

    @Test
    fun length() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        assertEquals(3.7416575F, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        assertEquals(14F, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVectorF(floatArrayOf(2F, 3F, -1F))
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1F, normalized.length(), 1e-6F)
        for (i in vector.data.indices) {
            assertEquals(vector[i] / length, normalized[i], 1e-6F)
        }
    }

    @Test
    fun normalize() {
        val data = floatArrayOf(2F, 3F, -1F)
        val normalized = MutableVectorF(data.copyOf())
        val length = normalized.length()
        normalized.normalize()
        assertEquals(1F, normalized.length(), 1e-6F)
        for (i in data.indices) {
            assertEquals(data[i] / length, normalized[i], 1e-6F)
        }
    }
}
