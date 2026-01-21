package net.voxelpi.voxlib.collection.map

public infix fun <K, V> Map<K, V>.withPatch(patch: MapPatch<K, V>): AppliedMapPatch<K, V> {
    return AppliedMutableMapPatchImpl(this, patch.mutableCopy() as MutableMapPatchImpl)
}

public infix fun <K, V> Map<K, V>.withMutablePatch(patch: MutableMapPatch<K, V>): AppliedMutableMapPatch<K, V> {
    return AppliedMutableMapPatchImpl(this, patch.mutableCopy() as MutableMapPatchImpl)
}

public fun <K, V> MutableMap<K, V>.applyPatch(patch: MapPatch<K, V>) {
    putAll(patch.modified)
    keys.removeAll(patch.removed)
}

public fun <K, V> mapPatchOf(modified: Map<K, V>, removed: Set<K>): MapPatch<K, V> {
    val intermediateModified = modified.toMutableMap()
    val intermediateRemoved = removed.toMutableSet().apply { removeAll(intermediateModified.keys) }
    return MutableMapPatchImpl(intermediateModified, intermediateRemoved)
}

public fun <K, V> mutableMapPatchOf(modified: Map<K, V>, removed: Set<K>): MutableMapPatch<K, V> {
    val intermediateModified = modified.toMutableMap()
    val intermediateRemoved = removed.toMutableSet().apply { removeAll(intermediateModified.keys) }
    return MutableMapPatchImpl(intermediateModified, intermediateRemoved)
}

public fun <K, V> emptyMapPatch(): MapPatch<K, V> {
    return MutableMapPatchImpl(mutableMapOf(), mutableSetOf())
}
