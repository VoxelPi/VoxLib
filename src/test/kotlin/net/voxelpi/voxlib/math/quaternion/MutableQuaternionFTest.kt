package net.voxelpi.voxlib.math.quaternion

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MutableQuaternionFTest {

    @Test
    @DisplayName("Should return a unit quaternion")
    fun `check unit quaternion`() {
        val quaternion = quaternionF()
        kotlin.test.assertEquals(1F, quaternion.w, 1e-9F)
        kotlin.test.assertEquals(0F, quaternion.x, 1e-9F)
        kotlin.test.assertEquals(0F, quaternion.y, 1e-9F)
        kotlin.test.assertEquals(0F, quaternion.z, 1e-9F)
    }

    @Test
    @DisplayName("Should be equal")
    fun `check equals`() {
        val quaternionA = quaternionF(1F, 2F, 3F, 4F)
        val quaternionB = quaternionF(1F, 2F, 3F, 4F)
        kotlin.test.assertEquals(quaternionA, quaternionB)
    }

    @Test
    @DisplayName("Should not be equal")
    fun `check not equals`() {
        val quaternionA = quaternionF(1F, 2F, 3F, 4F)
        val quaternionB = quaternionF(4F, 3F, 2F, 1F)
        kotlin.test.assertNotEquals(quaternionA, quaternionB)
    }

    @Test
    @DisplayName("Should multiply correctly")
    fun `check multiplication`() {
        val quaternionA = quaternionF(1F, 2F, 3F, 4F)
        val quaternionB = quaternionF(4F, 3F, 2F, 1F)
        val quaternionResult = quaternionF(-12F, 6F, 24F, 12F)
        kotlin.test.assertEquals(quaternionResult, quaternionA * quaternionB)
    }

    @Test
    @DisplayName("Should be unit quaternion")
    fun `check normalization`() {
        val quaternion = mutableQuaternionF(1F, 2F, 3F, 4F)
        quaternion.normalize()
        kotlin.test.assertEquals(1F, quaternion.magnitude, 1e-6F)
    }
}
