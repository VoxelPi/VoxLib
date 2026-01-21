package net.voxelpi.voxlib.collection.set

internal class MutableSetPatchImpl<E>(
    private val _added: MutableSet<E>,
    private val _removed: MutableSet<E>,
) : MutableSetPatch<E> {

    override val added: Set<E>
        get() = _added

    override val removed: Set<E>
        get() = _removed

    override fun revert(entry: E) {
        _added.remove(entry)
        _removed.remove(entry)
    }

    override fun revertAll() {
        _added.clear()
        _removed.clear()
    }

    override fun add(element: E) {
        _removed.remove(element)
        _added.add(element)
    }

    override fun remove(element: E) {
        _added.remove(element)
        _removed.add(element)
    }

    override fun addAll(elements: Collection<E>) {
        _removed.removeAll(elements.toSet())
        _added.addAll(elements)
    }

    override fun removeAll(elements: Collection<E>) {
        _added.removeAll(elements.toSet())
        _removed.addAll(elements)
    }

    override fun copy(): SetPatch<E> {
        return MutableSetPatchImpl(_added.toMutableSet(), _added.toMutableSet())
    }
}
