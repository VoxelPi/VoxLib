package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MutableVector2FTest {

    @Test
    fun plusAssign() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = MutableVector2F(1F, -2.5F)

        vectorA += vectorB

        assertEquals(3F, vectorA.x)
        assertEquals(0.5F, vectorA.y)
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = MutableVector2F(1F, -2.5F)

        vectorA -= vectorB

        assertEquals(1F, vectorA.x)
        assertEquals(5.5F, vectorA.y)
    }

    @Test
    fun timesAssign() {
        val vector = MutableVector2F(2F, 3F)

        vector *= 0.5F

        assertEquals(1F, vector.x)
        assertEquals(1.5F, vector.y)
    }

    @Test
    fun divAssign() {
        val vector = MutableVector2F(2F, 3F)

        vector /= 0.5F

        assertEquals(4F, vector.x)
        assertEquals(6F, vector.y)
    }

    @Test
    fun setValue() {
        val vector = MutableVector2F(2F, 3F)

        vector.set(2F)

        assertEquals(2F, vector.x)
        assertEquals(2F, vector.y)
    }

    @Test
    fun setVector() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = MutableVector2F(1F, -2.5F)

        vectorA.set(vectorB)

        assertEquals(vectorB.x, vectorA.x)
        assertEquals(vectorB.y, vectorA.y)
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVector2F(2F, -3F)

        val result = -vector

        assertEquals(-2F, result.x)
        assertEquals(3F, result.y)
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVector2F(2F, -3F)

        val result = +vector

        assertEquals(+2F, result.x)
        assertEquals(+(-3F), result.y)
    }

    @Test
    fun plus() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = MutableVector2F(1F, -2.5F)

        val result = vectorA + vectorB

        assertEquals(3F, result.x)
        assertEquals(0.5F, result.y)
    }

    @Test
    fun minus() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = MutableVector2F(1F, -2.5F)

        val result = vectorA - vectorB

        assertEquals(1F, result.x)
        assertEquals(5.5F, result.y)
    }

    @Test
    fun times() {
        val vector = MutableVector2F(2F, 3F)

        val result = vector * 0.5F

        assertEquals(1F, result.x)
        assertEquals(1.5F, result.y)
    }

    @Test
    fun div() {
        val vector = MutableVector2F(2F, 3F)

        val result = vector / 0.5F

        assertEquals(4F, result.x)
        assertEquals(6F, result.y)
    }

    @Test
    fun dot() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = MutableVector2F(1F, -2.5F)

        val result = vectorA dot vectorB

        assertEquals(-5.5F, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = vectorA.copy()

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(vectorA.y, vectorB.y)
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVector2F(2F, 3F)
        val vectorB = vectorA.mutableCopy()
        vectorB.y = 2.5F

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(2.5F, vectorB.y)
    }

    @Test
    fun length() {
        val vector = MutableVector2F(2F, -3F)
        assertEquals(3.6055512F, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVector2F(2F, -3F)
        assertEquals(13F, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVector2F(2F, -3F)
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1F, normalized.length(), 1e-6F)
        assertEquals(vector.x / length, normalized.x, 1e-6F)
        assertEquals(vector.y / length, normalized.y, 1e-6F)
    }

    @Test
    fun normalize() {
        val normalized = MutableVector2F(2F, -3F)
        val length = normalized.length()
        normalized.normalize()
        assertEquals(1F, normalized.length(), 1e-6F)
        assertEquals(2F / length, normalized.x, 1e-6F)
        assertEquals(-3F / length, normalized.y, 1e-6F)
    }
}
