package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MutableVector3ITest {

    @Test
    fun plusAssign() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = MutableVector3I(1, -2, 3)

        vectorA += vectorB

        assertEquals(3, vectorA.x)
        assertEquals(1, vectorA.y)
        assertEquals(2, vectorA.z)
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = MutableVector3I(1, -2, 3)

        vectorA -= vectorB

        assertEquals(1, vectorA.x)
        assertEquals(5, vectorA.y)
        assertEquals(-4, vectorA.z)
    }

    @Test
    fun timesAssign() {
        val vector = MutableVector3I(2, 3, -1)

        vector *= 2

        assertEquals(4, vector.x)
        assertEquals(6, vector.y)
        assertEquals(-2, vector.z)
    }

    @Test
    fun divAssign() {
        val vector = MutableVector3I(2, 3, -5)

        vector /= 2

        assertEquals(1, vector.x)
        assertEquals(1, vector.y)
        assertEquals(-2, vector.z)
    }

    @Test
    fun setValue() {
        val vector = MutableVector3I(2, 3, -1)

        vector.set(2)

        assertEquals(2, vector.x)
        assertEquals(2, vector.y)
        assertEquals(2, vector.z)
    }

    @Test
    fun setVector() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = MutableVector3I(1, -2, 3)

        vectorA.set(vectorB)

        assertEquals(vectorB.x, vectorA.x)
        assertEquals(vectorB.y, vectorA.y)
        assertEquals(vectorB.z, vectorA.z)
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVector3I(2, 3, -1)

        val result = -vector

        assertEquals(-2, result.x)
        assertEquals(-3, result.y)
        assertEquals(1, result.z)
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVector3I(2, 3, -1)

        val result = +vector

        assertEquals(+2, result.x)
        assertEquals(+3, result.y)
        assertEquals(+(-1), result.z)
    }

    @Test
    fun plus() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = MutableVector3I(1, -2, 3)

        val result = vectorA + vectorB

        assertEquals(3, result.x)
        assertEquals(1, result.y)
        assertEquals(2, result.z)
    }

    @Test
    fun minus() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = MutableVector3I(1, -2, 3)

        val result = vectorA - vectorB

        assertEquals(1, result.x)
        assertEquals(5, result.y)
        assertEquals(-4, result.z)
    }

    @Test
    fun times() {
        val vector = MutableVector3I(2, 3, -1)

        val result = vector * 2

        assertEquals(4, result.x)
        assertEquals(6, result.y)
        assertEquals(-2, result.z)
    }

    @Test
    fun div() {
        val vector = MutableVector3I(2, 3, -5)

        val result = vector / 2

        assertEquals(1, result.x)
        assertEquals(1, result.y)
        assertEquals(-2, result.z)
    }

    @Test
    fun dot() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = MutableVector3I(1, -2, 3)

        val result = vectorA dot vectorB

        assertEquals(-7, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = vectorA.copy()

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(vectorA.y, vectorB.y)
        assertEquals(vectorA.z, vectorB.z)
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVector3I(2, 3, -1)
        val vectorB = vectorA.mutableCopy()
        vectorB.y = 2

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(2, vectorB.y)
        assertEquals(vectorA.z, vectorB.z)
    }

    @Test
    fun length() {
        val vector = MutableVector3I(2, 3, -1)
        assertEquals(3.7416573867739413, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVector3I(2, 3, -1)
        assertEquals(14, vector.lengthSquared())
    }
}
