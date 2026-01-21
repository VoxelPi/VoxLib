package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.MutableSetPatch
import net.voxelpi.voxlib.collection.set.MutableSetPatchImpl
import net.voxelpi.voxlib.collection.set.SetPatch

internal class MutableMapPatchKeySetView<K>(
    private val patch: MutableMapPatchImpl<K, *>,
) : MutableSetPatch<K> {

    override val added: Set<K>
        get() = patch.modified.keys

    override val removed: Set<K>
        get() = patch.removed

    override fun revert(entry: K) {
        patch.revert(entry)
    }

    override fun revertAll() {
        patch.revertAll()
    }

    override fun add(element: K) {
        throw UnsupportedOperationException()
    }

    override fun remove(element: K) {
        patch.remove(element)
    }

    override fun addAll(elements: Collection<K>) {
        throw UnsupportedOperationException()
    }

    override fun removeAll(elements: Collection<K>) {
        elements.forEach(patch::remove)
    }

    override fun copy(): SetPatch<K> {
        return MutableSetPatchImpl(patch.modified.keys.toMutableSet(), patch.removed.toMutableSet())
    }
}
