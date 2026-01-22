package net.voxelpi.voxlib.collection.set

internal class AppliedMutableSetPatchImpl<E>(
    override val base: Set<E>,
    private val _patch: MutableSetPatch<E>,
) : AppliedMutableSetPatch<E> {

    override val patch: SetPatch<E>
        get() = _patch

    override fun reduce(): Set<E> {
        return (base + patch.added) - patch.removed
    }

    override val size: Int
        get() = reduce().size

    override fun isEmpty(): Boolean {
        return patch.added.isEmpty() && (base - patch.removed).isEmpty()
    }

    override fun contains(element: E): Boolean {
        if (element in patch.added) {
            return true
        }
        if (element in patch.removed) {
            return false
        }
        return element in base
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        return reduce().containsAll(elements)
    }

    override fun iterator(): MutableIterator<E> {
        return AppliedMutableSetPatchIterator(this)
    }

    override fun add(element: E): Boolean {
        val exists = contains(element)
        if (exists) {
            return false
        }

        _patch.add(element)
        return true
    }

    override fun remove(element: E): Boolean {
        val exists = contains(element)
        if (exists) {
            return false
        }

        _patch.remove(element)
        return true
    }

    override fun addAll(elements: Collection<E>): Boolean {
        val newElements = (elements.toSet() - reduce())
        if (newElements.isEmpty()) {
            return false
        }

        _patch.addAll(elements)
        return true
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        val existingElements = elements.toSet().intersect(reduce())
        if (existingElements.isEmpty()) {
            return false
        }

        _patch.removeAll(elements)
        return true
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        val toRemove = reduce() - elements.toSet()
        if (toRemove.isEmpty()) {
            return false
        }

        _patch.removeAll(elements)
        return true
    }

    override fun clear() {
        _patch.revertAll()
        _patch.removeAll(base)
    }
}
