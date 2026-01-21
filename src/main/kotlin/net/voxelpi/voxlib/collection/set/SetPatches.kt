package net.voxelpi.voxlib.collection.set

public infix fun <E> Set<E>.withPatch(patch: SetPatch<E>): AppliedSetPatch<E> {
    return AppliedMutableSetPatchImpl(this, patch.mutableCopy())
}

public infix fun <E> Set<E>.withMutablePatch(patch: MutableSetPatch<E>): AppliedMutableSetPatch<E> {
    return AppliedMutableSetPatchImpl(this, patch.mutableCopy())
}

public fun <T> MutableSet<T>.applyPatch(patch: SetPatch<T>) {
    addAll(patch.added)
    removeAll(patch.removed)
}

public fun <E> setPatchOf(added: Set<E>, removed: Set<E>): SetPatch<E> {
    val intermediateAdded = added.toMutableSet()
    val intermediateRemoved = removed.toMutableSet().apply { removeAll(intermediateAdded) }
    return MutableSetPatchImpl(intermediateAdded, intermediateRemoved)
}

public fun <E> mutableSetPatchOf(added: Set<E>, removed: Set<E>): MutableSetPatch<E> {
    val intermediateAdded = added.toMutableSet()
    val intermediateRemoved = removed.toMutableSet().apply { removeAll(intermediateAdded) }
    return MutableSetPatchImpl(intermediateAdded, intermediateRemoved)
}

public fun <E> emptySetPatch(): SetPatch<E> {
    return MutableSetPatchImpl(mutableSetOf(), mutableSetOf())
}
