package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.position2D
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MutableAABB2DTest {

    @Test
    fun `check isOnBoundary for points inside the bounding box`() {
        val aabb = aabb2D(0.0, 0.0, 1.0, 1.0)
        assertTrue(aabb.isOnBoundary(position2D(0.0, 0.0)))
        assertTrue(aabb.isOnBoundary(position2D(0.0, 1.0)))
        assertTrue(aabb.isOnBoundary(position2D(1.0, 0.0)))
        assertTrue(aabb.isOnBoundary(position2D(1.0, 1.0)))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box`() {
        val aabb = aabb2D(0.0, 0.0, 1.0, 1.0)
        assertFalse(aabb.isOnBoundary(position2D(1.0, 2.0)))
        assertFalse(aabb.isOnBoundary(position2D(2.0, 1.0)))
        assertFalse(aabb.isOnBoundary(position2D(2.0, 3.0)))
    }

    @Test
    fun `check isOnBoundary for points inside the bounding box with tolerance`() {
        val aabb = aabb2D(0.0, 0.0, 1.0, 1.0)
        assertTrue(aabb.isOnBoundary(position2D(0.0, 0.0), 1e-3))
        assertTrue(aabb.isOnBoundary(position2D(0.0, 1.0), 1e-3))
        assertTrue(aabb.isOnBoundary(position2D(1.0, 0.0), 1e-3))
        assertTrue(aabb.isOnBoundary(position2D(1.0, 1.0), 1e-3))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box with tolerance`() {
        val aabb = aabb2D(0.0, 0.0, 1.0, 1.0)
        assertFalse(aabb.isOnBoundary(position2D(1.0, 2.0), 1e-3))
        assertFalse(aabb.isOnBoundary(position2D(2.0, 1.0), 1e-3))
        assertFalse(aabb.isOnBoundary(position2D(2.0, 3.0), 1e-3))
    }
}
