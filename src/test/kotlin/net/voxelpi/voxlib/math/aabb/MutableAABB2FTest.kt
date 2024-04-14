package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.position2F
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MutableAABB2FTest {

    @Test
    fun `check isOnBoundary for points inside the bounding box`() {
        val aabb = aabb2F(0F, 0F, 1F, 1F)
        assertTrue(aabb.isOnBoundary(position2F(0F, 0F)))
        assertTrue(aabb.isOnBoundary(position2F(0F, 1F)))
        assertTrue(aabb.isOnBoundary(position2F(1F, 0F)))
        assertTrue(aabb.isOnBoundary(position2F(1F, 1F)))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box`() {
        val aabb = aabb2F(0F, 0F, 1F, 1F)
        assertFalse(aabb.isOnBoundary(position2F(1F, 2F)))
        assertFalse(aabb.isOnBoundary(position2F(2F, 1F)))
        assertFalse(aabb.isOnBoundary(position2F(2F, 3F)))
    }

    @Test
    fun `check isOnBoundary for points inside the bounding box with tolerance`() {
        val aabb = aabb2F(0F, 0F, 1F, 1F)
        assertTrue(aabb.isOnBoundary(position2F(0F, 0F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position2F(0F, 1F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position2F(1F, 0F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position2F(1F, 1F), 1e-3F))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box with tolerance`() {
        val aabb = aabb2F(0F, 0F, 1F, 1F)
        assertFalse(aabb.isOnBoundary(position2F(1F, 2F), 1e-3F))
        assertFalse(aabb.isOnBoundary(position2F(2F, 1F), 1e-3F))
        assertFalse(aabb.isOnBoundary(position2F(2F, 3F), 1e-3F))
    }
}
