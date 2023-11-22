package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MutableVector2DTest {

    @Test
    fun plusAssign() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = MutableVector2D(1.0, -2.5)

        vectorA += vectorB

        assertEquals(3.0, vectorA.x)
        assertEquals(0.5, vectorA.y)
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = MutableVector2D(1.0, -2.5)

        vectorA -= vectorB

        assertEquals(1.0, vectorA.x)
        assertEquals(5.5, vectorA.y)
    }

    @Test
    fun timesAssign() {
        val vector = MutableVector2D(2.0, 3.0)

        vector *= 0.5

        assertEquals(1.0, vector.x)
        assertEquals(1.5, vector.y)
    }

    @Test
    fun divAssign() {
        val vector = MutableVector2D(2.0, 3.0)

        vector /= 0.5

        assertEquals(4.0, vector.x)
        assertEquals(6.0, vector.y)
    }

    @Test
    fun setValue() {
        val vector = MutableVector2D(2.0, 3.0)

        vector.set(2.0)

        assertEquals(2.0, vector.x)
        assertEquals(2.0, vector.y)
    }

    @Test
    fun setVector() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = MutableVector2D(1.0, -2.5)

        vectorA.set(vectorB)

        assertEquals(vectorB.x, vectorA.x)
        assertEquals(vectorB.y, vectorA.y)
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVector2D(2.0, -3.0)

        val result = -vector

        assertEquals(-2.0, result.x)
        assertEquals(3.0, result.y)
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVector2D(2.0, -3.0)

        val result = +vector

        assertEquals(+2.0, result.x)
        assertEquals(+(-3.0), result.y)
    }

    @Test
    fun plus() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = MutableVector2D(1.0, -2.5)

        val result = vectorA + vectorB

        assertEquals(3.0, result.x)
        assertEquals(0.5, result.y)
    }

    @Test
    fun minus() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = MutableVector2D(1.0, -2.5)

        val result = vectorA - vectorB

        assertEquals(1.0, result.x)
        assertEquals(5.5, result.y)
    }

    @Test
    fun times() {
        val vector = MutableVector2D(2.0, 3.0)

        val result = vector * 0.5

        assertEquals(1.0, result.x)
        assertEquals(1.5, result.y)
    }

    @Test
    fun div() {
        val vector = MutableVector2D(2.0, 3.0)

        val result = vector / 0.5

        assertEquals(4.0, result.x)
        assertEquals(6.0, result.y)
    }

    @Test
    fun dot() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = MutableVector2D(1.0, -2.5)

        val result = vectorA dot vectorB

        assertEquals(-5.5, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = vectorA.copy()

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(vectorA.y, vectorB.y)
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVector2D(2.0, 3.0)
        val vectorB = vectorA.mutableCopy()
        vectorB.y = 2.5

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(2.5, vectorB.y)
    }

    @Test
    fun length() {
        val vector = MutableVector2D(2.0, -3.0)
        assertEquals(3.605551275463989, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVector2D(2.0, -3.0)
        assertEquals(13.0, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVector2D(2.0, -3.0)
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1.0, normalized.length())
        assertEquals(vector.x / length, normalized.x)
        assertEquals(vector.y / length, normalized.y)
    }

    @Test
    fun normalize() {
        val normalized = MutableVector2D(2.0, -3.0)
        val length = normalized.length()
        normalized.normalize()
        assertEquals(1.0, normalized.length())
        assertEquals(2.0 / length, normalized.x)
        assertEquals(-3.0 / length, normalized.y)
    }
}
