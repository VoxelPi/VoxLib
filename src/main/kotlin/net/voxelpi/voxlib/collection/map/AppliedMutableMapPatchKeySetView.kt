package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.AppliedMutableSetPatch
import net.voxelpi.voxlib.collection.set.AppliedMutableSetPatchIterator

internal class AppliedMutableMapPatchKeySetView<K>(
    private val appliedPatch: AppliedMutableMapPatchImpl<K, *>,
) : AppliedMutableSetPatch<K> {

    override val base: Set<K>
        get() = appliedPatch.base.keys

    override val patch: MutableMapPatchKeySetView<K>
        get() = appliedPatch.patch.keys

    override val size: Int
        get() = reduce().size

    override fun reduce(): Set<K> {
        return (appliedPatch.base.keys - appliedPatch.patch.removed) + appliedPatch.patch.modified.keys
    }

    override fun isEmpty(): Boolean {
        return reduce().isEmpty()
    }

    override fun contains(element: K): Boolean {
        return element in appliedPatch.patch.keys.added
            || (element in appliedPatch.base.keys && element !in appliedPatch.patch.keys.removed)
    }

    override fun containsAll(elements: Collection<K>): Boolean {
        return elements.all(::contains)
    }

    override fun iterator(): MutableIterator<K> {
        return AppliedMutableSetPatchIterator(this)
    }

    override fun add(element: K): Boolean {
        throw UnsupportedOperationException()
    }

    override fun remove(element: K): Boolean {
        // Check if the value existed in the applied patch.
        val existed = when (element) {
            in appliedPatch.patch.modified -> true
            in appliedPatch.patch.removed -> false
            in appliedPatch.base.keys -> true
            else -> false
        }

        // Remove the element from the patch.
        patch.remove(element)

        // Return if the value existed before the removal.
        return existed
    }

    override fun addAll(elements: Collection<K>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeAll(elements: Collection<K>): Boolean {
        return elements.any(::remove)
    }

    override fun retainAll(elements: Collection<K>): Boolean {
        return removeAll(reduce() - elements.toSet())
    }

    override fun clear() {
        appliedPatch.clear()
    }
}
