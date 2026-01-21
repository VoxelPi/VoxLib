package net.voxelpi.voxlib.collection.map

internal data class MutableMapPatchImpl<K, V>(
    private val _modified: MutableMap<K, V>,
    private val _removed: MutableSet<K>,
) : MutableMapPatch<K, V> {

    override val modified: Map<K, V>
        get() = _modified

    override val removed: Set<K>
        get() = _removed

    override val keys: MutableMapPatchKeySetView<K> = MutableMapPatchKeySetView(this)

    override fun revert(key: K) {
        _removed.remove(key)
        _modified.remove(key)
    }

    override fun revertAll() {
        _removed.clear()
        _modified.clear()
    }

    override fun put(key: K, value: V) {
        _removed.remove(key)
        _modified[key] = value
    }

    override fun putAll(from: Map<out K, V>) {
        _removed.addAll(from.keys)
        _modified.putAll(from)
    }

    override fun remove(key: K): V? {
        val value = _modified.remove(key)
        _removed.add(key)
        return value
    }

    override fun copy(): MapPatch<K, V> {
        return MutableMapPatchImpl(_modified.toMutableMap(), _removed.toMutableSet())
    }
}
