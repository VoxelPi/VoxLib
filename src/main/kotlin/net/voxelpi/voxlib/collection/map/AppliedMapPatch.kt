package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.AppliedSetPatch

public interface AppliedMapPatch<K, V> : Map<K, V> {

    override val keys: AppliedSetPatch<K>

    public val base: Map<K, V>

    public val patch: MapPatch<K, V>

    public fun reduce(): Map<K, V>
}
