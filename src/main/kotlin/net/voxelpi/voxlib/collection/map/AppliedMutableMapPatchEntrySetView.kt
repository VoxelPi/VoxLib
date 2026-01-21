package net.voxelpi.voxlib.collection.map

internal class AppliedMutableMapPatchEntrySetView<K, V>(
    private val appliedPatch: AppliedMutableMapPatchImpl<K, V>,
) : MutableSet<MutableMap.MutableEntry<K, V>> {

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
        TODO("Not yet implemented")
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
        return appliedPatch.clear()
    }
}
