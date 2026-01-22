package net.voxelpi.voxlib.collection.map

import kotlin.test.Test
import kotlin.test.assertEquals

class AppliedMutableMapPatchImplTest {

    @Test
    fun `test applied map patch`() {
        val base = mapOf(
            "test0" to 0,
            "test1" to 2,
            "test2" to 3,
            "test3" to 3,
        )
        val patch = mutableMapPatchOf(
            modified = mapOf(
                "test2" to 2,
                "test4" to 4,
            ),
            removed = setOf("test0")
        )

        val appliedPatch = base.withPatch(patch)

        assertEquals(base.toMutableMap().apply { applyPatch(patch) }, appliedPatch.reduce())
    }

    @Test
    fun `test builder`() {
        val base = mapOf(
            "test0" to 0,
            "test1" to 2,
            "test2" to 3,
            "test3" to 3,
        )
        val patch = base.buildPatch {
            this["test2"] = 2
            this["test4"] = 4
            remove("test0")
        }

        val expected = mapOf(
            "test1" to 2,
            "test2" to 2,
            "test3" to 3,
            "test4" to 4,
        )
        assertEquals(expected, base.toMutableMap().apply { applyPatch(patch) })
    }
}
