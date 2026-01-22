package net.voxelpi.voxlib.collection.set

public infix fun <E> Set<E>.withPatch(patch: SetPatch<E>): AppliedSetPatch<E> {
    return AppliedMutableSetPatchImpl(this, patch.mutableCopy())
}

public infix fun <E> Set<E>.withMutablePatch(patch: MutableSetPatch<E>): AppliedMutableSetPatch<E> {
    return AppliedMutableSetPatchImpl(this, patch)
}

public fun <E> Set<E>.buildPatch(action: AppliedMutableSetPatch<E>.() -> Unit): SetPatch<E> {
    return buildMutablePatch(action)
}

public fun <E> Set<E>.buildMutablePatch(action: AppliedMutableSetPatch<E>.() -> Unit): MutableSetPatch<E> {
    val patch = mutableSetPatchOf<E>(mutableSetOf(), mutableSetOf())
    val appliedPatch = withMutablePatch(patch)
    appliedPatch.action()
    return patch
}

public fun <E> MutableSet<E>.applyPatch(patch: SetPatch<E>) {
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
