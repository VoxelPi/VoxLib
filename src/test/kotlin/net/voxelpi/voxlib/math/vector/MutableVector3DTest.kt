package net.voxelpi.voxlib.math.vector

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MutableVector3DTest {

    @Test
    fun plusAssign() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = MutableVector3D(1.0, -2.5, 3.0)

        vectorA += vectorB

        assertEquals(3.0, vectorA.x)
        assertEquals(0.5, vectorA.y)
        assertEquals(2.0, vectorA.z)
    }

    @Test
    fun minusAssign() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = MutableVector3D(1.0, -2.5, 3.0)

        vectorA -= vectorB

        assertEquals(1.0, vectorA.x)
        assertEquals(5.5, vectorA.y)
        assertEquals(-4.0, vectorA.z)
    }

    @Test
    fun timesAssign() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        vector *= 0.5

        assertEquals(1.0, vector.x)
        assertEquals(1.5, vector.y)
        assertEquals(-0.5, vector.z)
    }

    @Test
    fun divAssign() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        vector /= 0.5

        assertEquals(4.0, vector.x)
        assertEquals(6.0, vector.y)
        assertEquals(-2.0, vector.z)
    }

    @Test
    fun setValue() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        vector.set(2.0)

        assertEquals(2.0, vector.x)
        assertEquals(2.0, vector.y)
        assertEquals(2.0, vector.z)
    }

    @Test
    fun setVector() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = MutableVector3D(1.0, -2.5, 3.0)

        vectorA.set(vectorB)

        assertEquals(vectorB.x, vectorA.x)
        assertEquals(vectorB.y, vectorA.y)
        assertEquals(vectorB.z, vectorA.z)
    }

    @Test
    operator fun unaryMinus() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        val result = -vector

        assertEquals(-2.0, result.x)
        assertEquals(-3.0, result.y)
        assertEquals(1.0, result.z)
    }

    @Test
    operator fun unaryPlus() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        val result = +vector

        assertEquals(+2.0, result.x)
        assertEquals(+3.0, result.y)
        assertEquals(+(-1.0), result.z)
    }

    @Test
    fun plus() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = MutableVector3D(1.0, -2.5, 3.0)

        val result = vectorA + vectorB

        assertEquals(3.0, result.x)
        assertEquals(0.5, result.y)
        assertEquals(2.0, result.z)
    }

    @Test
    fun minus() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = MutableVector3D(1.0, -2.5, 3.0)

        val result = vectorA - vectorB

        assertEquals(1.0, result.x)
        assertEquals(5.5, result.y)
        assertEquals(-4.0, result.z)
    }

    @Test
    fun times() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        val result = vector * 0.5

        assertEquals(1.0, result.x)
        assertEquals(1.5, result.y)
        assertEquals(-0.5, result.z)
    }

    @Test
    fun div() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)

        val result = vector / 0.5

        assertEquals(4.0, result.x)
        assertEquals(6.0, result.y)
        assertEquals(-2.0, result.z)
    }

    @Test
    fun dot() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = MutableVector3D(1.0, -2.5, 3.0)

        val result = vectorA dot vectorB

        assertEquals(-8.5, result)
    }

    @Test
    fun copy() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = vectorA.copy()

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(vectorA.y, vectorB.y)
        assertEquals(vectorA.z, vectorB.z)
    }

    @Test
    fun mutableCopy() {
        val vectorA = MutableVector3D(2.0, 3.0, -1.0)
        val vectorB = vectorA.mutableCopy()
        vectorB.y = 2.5

        assertEquals(vectorA.x, vectorB.x)
        assertEquals(2.5, vectorB.y)
        assertEquals(vectorA.z, vectorB.z)
    }

    @Test
    fun length() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)
        assertEquals(3.7416573867739413, vector.length())
    }

    @Test
    fun lengthSquared() {
        val vector = MutableVector3D(2.0, 3.0, -1.0)
        assertEquals(14.0, vector.lengthSquared())
    }

    @Test
    fun normalized() {
        val vector = MutableVector3D(2.0, -3.0, -1.0)
        val length = vector.length()
        val normalized = vector.normalized()
        assertEquals(1.0, normalized.length())
        assertEquals(vector.x / length, normalized.x)
        assertEquals(vector.y / length, normalized.y)
        assertEquals(vector.z / length, normalized.z)
    }

    @Test
    fun normalize() {
        val normalized = MutableVector3D(2.0, -3.0, -1.0)
        val length = normalized.length()
        normalized.normalize()
        assertEquals(1.0, normalized.length())
        assertEquals(2.0 / length, normalized.x)
        assertEquals(-3.0 / length, normalized.y)
        assertEquals(-1.0 / length, normalized.z)
    }
}
