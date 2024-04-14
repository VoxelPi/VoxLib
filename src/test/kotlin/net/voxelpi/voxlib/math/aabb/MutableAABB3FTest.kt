package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.position3F
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MutableAABB3FTest {

    @Test
    fun `check isOnBoundary for points inside the bounding box`() {
        val aabb = aabb3F(0F, 0F, 0F, 1F, 1F, 1F)
        assertTrue(aabb.isOnBoundary(position3F(0F, 0F, 0F)))
        assertTrue(aabb.isOnBoundary(position3F(0F, 0F, 1F)))
        assertTrue(aabb.isOnBoundary(position3F(0F, 1F, 0F)))
        assertTrue(aabb.isOnBoundary(position3F(0F, 1F, 1F)))
        assertTrue(aabb.isOnBoundary(position3F(1F, 0F, 0F)))
        assertTrue(aabb.isOnBoundary(position3F(1F, 0F, 1F)))
        assertTrue(aabb.isOnBoundary(position3F(1F, 1F, 0F)))
        assertTrue(aabb.isOnBoundary(position3F(1F, 1F, 1F)))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box`() {
        val aabb = aabb3F(0F, 0F, 0F, 1F, 1F, 1F)
        assertFalse(aabb.isOnBoundary(position3F(1F, 2F, 2F)))
        assertFalse(aabb.isOnBoundary(position3F(2F, 1F, 2F)))
        assertFalse(aabb.isOnBoundary(position3F(2F, 2F, 1F)))
        assertFalse(aabb.isOnBoundary(position3F(2F, 3F, 4F)))
    }

    @Test
    fun `check isOnBoundary for points inside the bounding box with tolerance`() {
        val aabb = aabb3F(0F, 0F, 0F, 1F, 1F, 1F)
        assertTrue(aabb.isOnBoundary(position3F(0F, 0F, 0F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(0F, 0F, 1F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(0F, 1F, 0F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(0F, 1F, 1F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(1F, 0F, 0F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(1F, 0F, 1F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(1F, 1F, 0F), 1e-3F))
        assertTrue(aabb.isOnBoundary(position3F(1F, 1F, 1F), 1e-3F))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box with tolerance`() {
        val aabb = aabb3F(0F, 0F, 0F, 1F, 1F, 1F)
        assertFalse(aabb.isOnBoundary(position3F(1F, 2F, 2F), 1e-3F))
        assertFalse(aabb.isOnBoundary(position3F(2F, 1F, 2F), 1e-3F))
        assertFalse(aabb.isOnBoundary(position3F(2F, 2F, 1F), 1e-3F))
        assertFalse(aabb.isOnBoundary(position3F(2F, 3F, 4F), 1e-3F))
    }
}
