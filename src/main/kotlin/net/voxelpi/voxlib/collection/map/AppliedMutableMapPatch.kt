package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.AppliedMutableSetPatch

public interface AppliedMutableMapPatch<K, V> : AppliedMapPatch<K, V>, MutableMap<K, V> {

    override val size: Int
        get() = keys.size

    override val keys: AppliedMutableSetPatch<K>
}
