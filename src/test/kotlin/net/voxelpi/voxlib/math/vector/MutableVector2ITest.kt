package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MutableVector2ITest {

    @Test
    fun plusAssign() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = MutableVector2I(1, -2)

        vectorA += vectorB

        assertEquals(3, vectorA.x)
        assertEquals(1, vectorA.y)
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = MutableVector2I(1, -2)

        vectorA -= vectorB

        assertEquals(1, vectorA.x)
        assertEquals(5, vectorA.y)
    }

    @Test
    fun timesAssign() {
        val vector = MutableVector2I(2, 3)

        vector *= 2

        assertEquals(4, vector.x)
        assertEquals(6, vector.y)
    }

    @Test
    fun divAssign() {
        val vector = MutableVector2I(2, 5)

        vector /= 2

        assertEquals(1, vector.x)
        assertEquals(2, vector.y)
    }

    @Test
    fun setValue() {
        val vector = MutableVector2I(2, 3)

        vector.set(2)

        assertEquals(2, vector.x)
        assertEquals(2, vector.y)
    }

    @Test
    fun setVector() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = MutableVector2I(1, -2)

        vectorA.set(vectorB)

        assertEquals(vectorB.x, vectorA.x)
        assertEquals(vectorB.y, vectorA.y)
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVector2I(2, -3)

        val result = -vector

        assertEquals(-2, result.x)
        assertEquals(3, result.y)
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVector2I(2, -3)

        val result = +vector

        assertEquals(+2, result.x)
        assertEquals(+(-3), result.y)
    }

    @Test
    fun plus() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = MutableVector2I(1, -2)

        val result = vectorA + vectorB

        assertEquals(3, result.x)
        assertEquals(1, result.y)
    }

    @Test
    fun minus() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = MutableVector2I(1, -2)

        val result = vectorA - vectorB

        assertEquals(1, result.x)
        assertEquals(5, result.y)
    }

    @Test
    fun times() {
        val vector = MutableVector2I(2, 3)

        val result = vector * 2

        assertEquals(4, result.x)
        assertEquals(6, result.y)
    }

    @Test
    fun div() {
        val vector = MutableVector2I(2, 5)

        val result = vector / 2

        assertEquals(1, result.x)
        assertEquals(2, result.y)
    }

    @Test
    fun dot() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = MutableVector2I(1, -2)

        val result = vectorA dot vectorB

        assertEquals(-4, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = vectorA.copy()

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(vectorA.y, vectorB.y)
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVector2I(2, 3)
        val vectorB = vectorA.mutableCopy()
        vectorB.y = 2

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(2, vectorB.y)
    }

    @Test
    fun length() {
        val vector = MutableVector2I(2, -3)
        assertEquals(3.605551275463989, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVector2I(2, -3)
        assertEquals(13, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVector2I(2, -3)
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1.0, normalized.length())
        assertEquals(vector.x / length, normalized.x)
        assertEquals(vector.y / length, normalized.y)
    }
}
