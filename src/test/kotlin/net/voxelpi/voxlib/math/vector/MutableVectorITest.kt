package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class MutableVectorITest {

    @Test
    fun get() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        assertEquals(2, vector[0])
        assertEquals(3, vector[1])
        assertEquals(-1, vector[2])

        assertThrows<IndexOutOfBoundsException> { vector[-1] }
        assertThrows<IndexOutOfBoundsException> { vector[3] }
    }

    @Test
    fun set() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        vector[1] = -4

        assertEquals(2, vector[0])
        assertEquals(-4, vector[1])
        assertEquals(-1, vector[2])
    }

    @Test
    fun getIndices() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        assertEquals(IntRange(0, 2), vector.indices)
    }

    @Test
    fun getSize() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        assertEquals(3, vector.size)
    }

    @Test
    fun plusAssign() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = MutableVectorI(intArrayOf(1, -2, 3))

        vectorA += vectorB

        assertEquals(3, vectorA[0])
        assertEquals(1, vectorA[1])
        assertEquals(2, vectorA[2])
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = MutableVectorI(intArrayOf(1, -2, 3))

        vectorA -= vectorB

        assertEquals(1, vectorA[0])
        assertEquals(5, vectorA[1])
        assertEquals(-4, vectorA[2])
    }

    @Test
    fun timesAssign() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        vector *= 2

        assertEquals(4, vector[0])
        assertEquals(6, vector[1])
        assertEquals(-2, vector[2])
    }

    @Test
    fun divAssign() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        vector /= 2

        assertEquals(1, vector[0])
        assertEquals(1, vector[1])
        assertEquals(0, vector[2])
    }

    @Test
    fun setValue() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        vector.set(2)

        assertEquals(2, vector[0])
        assertEquals(2, vector[1])
        assertEquals(2, vector[2])
    }

    @Test
    fun setVector() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = MutableVectorI(intArrayOf(1, -2, 3))

        vectorA.set(vectorB)

        assertEquals(vectorB[0], vectorA[0])
        assertEquals(vectorB[1], vectorA[1])
        assertEquals(vectorB[2], vectorA[2])
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        val result = -vector

        assertEquals(-2, result[0])
        assertEquals(-3, result[1])
        assertEquals(1, result[2])
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        val result = +vector

        assertEquals(+2, result[0])
        assertEquals(+3, result[1])
        assertEquals(+(-1), result[2])
    }

    @Test
    fun plus() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = MutableVectorI(intArrayOf(1, -2, 3))

        val result = vectorA + vectorB

        assertEquals(3, result[0])
        assertEquals(1, result[1])
        assertEquals(2, result[2])
    }

    @Test
    fun minus() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = MutableVectorI(intArrayOf(1, -2, 3))

        val result = vectorA - vectorB

        assertEquals(1, result[0])
        assertEquals(5, result[1])
        assertEquals(-4, result[2])
    }

    @Test
    fun times() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))

        val result = vector * 2

        assertEquals(4, result[0])
        assertEquals(6, result[1])
        assertEquals(-2, result[2])
    }

    @Test
    fun div() {
        val vector = MutableVectorI(intArrayOf(2, 3, -5))

        val result = vector / 2

        assertEquals(1, result[0])
        assertEquals(1, result[1])
        assertEquals(-2, result[2])
    }

    @Test
    fun dot() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = MutableVectorI(intArrayOf(1, -2, 3))

        val result = vectorA dot vectorB

        assertEquals(-7, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = vectorA.copy()

        assertEquals(vectorA[0], vectorB[0])
        assertEquals(vectorA[1], vectorB[1])
        assertEquals(vectorA[2], vectorB[2])
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVectorI(intArrayOf(2, 3, -1))
        val vectorB = vectorA.mutableCopy()
        vectorB[1] = 2

        assertEquals(vectorA[0], vectorB[0])
        assertEquals(2, vectorB[1])
        assertEquals(vectorA[2], vectorB[2])
    }

    @Test
    fun length() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))
        assertEquals(3.7416573867739413, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))
        assertEquals(14, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVectorI(intArrayOf(2, 3, -1))
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1.0, normalized.length())
        for (i in vector.data.indices) {
            assertEquals(vector[i] / length, normalized[i])
        }
    }
}
