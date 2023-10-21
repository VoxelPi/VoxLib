package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MutableVector3FTest {

    @Test
    fun plusAssign() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = MutableVector3F(1F, -2.5F, 3F)

        vectorA += vectorB

        assertEquals(3F, vectorA.x)
        assertEquals(0.5F, vectorA.y)
        assertEquals(2F, vectorA.z)
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = MutableVector3F(1F, -2.5F, 3F)

        vectorA -= vectorB

        assertEquals(1F, vectorA.x)
        assertEquals(5.5F, vectorA.y)
        assertEquals(-4F, vectorA.z)
    }

    @Test
    fun timesAssign() {
        val vector = MutableVector3F(2F, 3F, -1F)

        vector *= 0.5F

        assertEquals(1F, vector.x)
        assertEquals(1.5F, vector.y)
        assertEquals(-0.5F, vector.z)
    }

    @Test
    fun divAssign() {
        val vector = MutableVector3F(2F, 3F, -1F)

        vector /= 0.5F

        assertEquals(4F, vector.x)
        assertEquals(6F, vector.y)
        assertEquals(-2F, vector.z)
    }

    @Test
    fun setValue() {
        val vector = MutableVector3F(2F, 3F, -1F)

        vector.set(2F)

        assertEquals(2F, vector.x)
        assertEquals(2F, vector.y)
        assertEquals(2F, vector.z)
    }

    @Test
    fun setVector() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = MutableVector3F(1F, -2.5F, 3F)

        vectorA.set(vectorB)

        assertEquals(vectorB.x, vectorA.x)
        assertEquals(vectorB.y, vectorA.y)
        assertEquals(vectorB.z, vectorA.z)
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVector3F(2F, 3F, -1F)

        val result = -vector

        assertEquals(-2F, result.x)
        assertEquals(-3F, result.y)
        assertEquals(1F, result.z)
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVector3F(2F, 3F, -1F)

        val result = +vector

        assertEquals(+2F, result.x)
        assertEquals(+3F, result.y)
        assertEquals(+(-1F), result.z)
    }

    @Test
    fun plus() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = MutableVector3F(1F, -2.5F, 3F)

        val result = vectorA + vectorB

        assertEquals(3F, result.x)
        assertEquals(0.5F, result.y)
        assertEquals(2F, result.z)
    }

    @Test
    fun minus() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = MutableVector3F(1F, -2.5F, 3F)

        val result = vectorA - vectorB

        assertEquals(1F, result.x)
        assertEquals(5.5F, result.y)
        assertEquals(-4F, result.z)
    }

    @Test
    fun times() {
        val vector = MutableVector3F(2F, 3F, -1F)

        val result = vector * 0.5F

        assertEquals(1F, result.x)
        assertEquals(1.5F, result.y)
        assertEquals(-0.5F, result.z)
    }

    @Test
    fun div() {
        val vector = MutableVector3F(2F, 3F, -1F)

        val result = vector / 0.5F

        assertEquals(4F, result.x)
        assertEquals(6F, result.y)
        assertEquals(-2F, result.z)
    }

    @Test
    fun dot() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = MutableVector3F(1F, -2.5F, 3F)

        val result = vectorA dot vectorB

        assertEquals(-8.5F, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = vectorA.copy()

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(vectorA.y, vectorB.y)
        assertEquals(vectorA.z, vectorB.z)
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVector3F(2F, 3F, -1F)
        val vectorB = vectorA.mutableCopy()
        vectorB.y = 2.5F

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(2.5F, vectorB.y)
        assertEquals(vectorA.z, vectorB.z)
    }

    @Test
    fun length() {
        val vector = MutableVector3F(2F, 3F, -1F)
        assertEquals(3.7416575F, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVector3F(2F, 3F, -1F)
        assertEquals(14F, vector.lengthSquared())
    }
}
