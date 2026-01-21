package net.voxelpi.voxlib.collection.map

import net.voxelpi.voxlib.collection.set.MutableSetPatch

public interface MutableMapPatch<K, V> : MapPatch<K, V> {

    override val keys: MutableSetPatch<K>

    public fun revert(key: K)

    public fun revertAll()

    public fun put(key: K, value: V)

    public fun putAll(from: Map<out K, V>)

    public fun remove(key: K): V?

    override fun copy(): MapPatch<K, V>
}
