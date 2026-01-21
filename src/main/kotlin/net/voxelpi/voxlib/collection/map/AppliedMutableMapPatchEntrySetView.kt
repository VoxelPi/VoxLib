package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.AppliedMutableSetPatch
import net.voxelpi.voxlib.collection.set.AppliedMutableSetPatchIterator
import net.voxelpi.voxlib.collection.set.MutableSetPatchImpl
import net.voxelpi.voxlib.collection.set.SetPatch

internal class AppliedMutableMapPatchEntrySetView<K, V>(
    private val appliedPatch: AppliedMutableMapPatchImpl<K, V>,
) : AppliedMutableSetPatch<MutableMap.MutableEntry<K, V>> {

    override val base: Set<MutableMap.MutableEntry<K, V>>
        get() = appliedPatch.base.keys.map { MutableEntryView(appliedPatch, it) }.toSet()

    override val patch: SetPatch<MutableMap.MutableEntry<K, V>>
        get() {
            return MutableSetPatchImpl(
                appliedPatch.patch.modified.keys.map { MutableEntryView(appliedPatch, it) }.toMutableSet(),
                appliedPatch.patch.removed.map {
                    @Suppress("UNCHECKED_CAST")
                    CachedMutableEntryView(appliedPatch, it, appliedPatch.base[it] as V)
                }.toMutableSet(),
            )
        }

    override fun reduce(): Set<MutableMap.MutableEntry<K, V>> {
        return appliedPatch.keys.reduce().map { MutableEntryView(appliedPatch, it) }.toSet()
    }

    override val size: Int
        get() = appliedPatch.size

    override fun isEmpty(): Boolean {
        return appliedPatch.isEmpty()
    }

    override fun contains(element: MutableMap.MutableEntry<K, V>): Boolean {
        return appliedPatch.reduce().entries.contains(element)
    }

    override fun containsAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        return appliedPatch.reduce().entries.containsAll(elements)
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<K, V>> {
        return AppliedMutableSetPatchIterator(this)
    }

    override fun add(element: MutableMap.MutableEntry<K, V>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun remove(element: MutableMap.MutableEntry<K, V>): Boolean {
        // Check if the element key is present in the applied patch map, otherwise return false.
        if (element.key !in appliedPatch.keys) {
            return false
        }

        // Check if the existing value matches the given value, otherwise return false.
        val existingValue = appliedPatch[element.key]
        if (existingValue != element.value) {
            return false
        }

        // Remove the element.
        appliedPatch.remove(element.key)
        return true
    }

    override fun addAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        // Get the existing state.
        val existingState = appliedPatch.reduce()

        // Find all keys that are present in elements and whose values match with that in elements.
        val keysToRemove = existingState.keys.filter { key ->
            elements.any { it.key == key && it.value == existingState[key] }
        }.toSet()

        // Remove selected keys.
        return appliedPatch.keys.removeAll(keysToRemove)
    }

    override fun retainAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        // Get the existing state.
        val existingState = appliedPatch.reduce()

        // Find all keys that are present in elements and whose values match with that in elements.
        val keysToRetain = existingState.keys.filter { key ->
            elements.any { it.key == key && it.value == existingState[key] }
        }.toSet()

        // Retain selected keys.
        return appliedPatch.keys.retainAll(keysToRetain)
    }

    override fun clear() {
        appliedPatch.clear()
    }

    private class MutableEntryView<K, V>(
        private val appliedPatch: AppliedMutableMapPatchImpl<K, V>,
        override val key: K,
    ) : MutableMap.MutableEntry<K, V> {

        override fun setValue(newValue: V): V {
            @Suppress("UNCHECKED_CAST")
            return appliedPatch.put(key, value) as V
        }

        override val value: V
            get() {
                @Suppress("UNCHECKED_CAST")
                return appliedPatch[key] as V
            }
    }

    private class CachedMutableEntryView<K, V>(
        private val appliedPatch: AppliedMutableMapPatchImpl<K, V>,
        override val key: K,
        private val previousValue: V,
    ) : MutableMap.MutableEntry<K, V> {

        override fun setValue(newValue: V): V {
            @Suppress("UNCHECKED_CAST")
            return appliedPatch.put(key, value) as V
        }

        override val value: V
            get() {
                if (key !in appliedPatch) {
                    return previousValue
                }

                @Suppress("UNCHECKED_CAST")
                return appliedPatch[key] as V
            }
    }
}
