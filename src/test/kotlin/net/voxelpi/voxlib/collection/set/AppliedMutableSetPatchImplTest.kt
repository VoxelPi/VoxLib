package net.voxelpi.voxlib.collection.set

import kotlin.test.Test
import kotlin.test.assertEquals

class AppliedMutableSetPatchImplTest {

    @Test
    fun `test applied set patch`() {
        val base = setOf(2, 24, 3)
        val patch = mutableSetPatchOf(added = setOf(3, 4, 5), removed = setOf(24, 25))

        val appliedPatch = base.withPatch(patch)

        assertEquals(base.toMutableSet().apply { applyPatch(patch) }, appliedPatch.reduce())
    }
}
