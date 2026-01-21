package net.voxelpi.voxlib.collection.map

internal class AppliedMutableMapPatchValueCollectionView<V>(
    private val appliedPatch: AppliedMutableMapPatchImpl<*, V>,
) : MutableCollection<V> {

    override val size: Int
        get() = appliedPatch.size

    override fun isEmpty(): Boolean {
        return appliedPatch.isEmpty()
    }

    override fun contains(element: V): Boolean {
        return appliedPatch.reduce().values.contains(element)
    }

    override fun containsAll(elements: Collection<V>): Boolean {
        return appliedPatch.reduce().values.containsAll(elements)
    }

    override fun iterator(): MutableIterator<V> {
        TODO("Not yet implemented")
    }

    override fun add(element: V): Boolean {
        throw UnsupportedOperationException()
    }

    override fun remove(element: V): Boolean {
        val state = appliedPatch.reduce()
        val existingEntry = state.entries.find { it.value == element } ?: return false
        appliedPatch.remove(existingEntry.key)
        return true
    }

    override fun addAll(elements: Collection<V>): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeAll(elements: Collection<V>): Boolean {
        val state = appliedPatch.reduce()
        val keysToRemove = state.entries.filter { it.value == elements }.map(Map.Entry<*, V>::key).toSet()
        return appliedPatch.keys.removeAll(keysToRemove)
    }

    override fun retainAll(elements: Collection<V>): Boolean {
        val state = appliedPatch.reduce()
        val keysToRetain = state.entries.filter { it.value == elements }.map(Map.Entry<*, V>::key).toSet()
        return appliedPatch.keys.retainAll(keysToRetain)
    }

    override fun clear() {
        appliedPatch.clear()
    }
}
