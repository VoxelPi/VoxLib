package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.position2I
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MutableAABB2ITest {

    @Test
    fun `check isOnBoundary for points inside the bounding box`() {
        val aabb = aabb2I(0, 0, 1, 1)
        assertTrue(aabb.isOnBoundary(position2I(0, 0)))
        assertTrue(aabb.isOnBoundary(position2I(0, 1)))
        assertTrue(aabb.isOnBoundary(position2I(1, 0)))
        assertTrue(aabb.isOnBoundary(position2I(1, 1)))
    }

    @Test
    fun `check isOnBoundary for points outside the bounding box`() {
        val aabb = aabb2I(0, 0, 1, 1)
        assertFalse(aabb.isOnBoundary(position2I(1, 2)))
        assertFalse(aabb.isOnBoundary(position2I(2, 1)))
        assertFalse(aabb.isOnBoundary(position2I(2, 3)))
    }
}
