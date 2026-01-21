package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.SetPatch

public interface MapPatch<K, out V> {

    public val modified: Map<K, V>

    public val removed: Set<K>

    public val keys: SetPatch<K>

    public fun copy(): MapPatch<K, V>
}

public fun <K, V> MapPatch<out K, V>.mutableCopy(): MutableMapPatch<K, V> {
    return MutableMapPatchImpl(modified.toMutableMap(), removed.toMutableSet())
}
