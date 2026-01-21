package net.voxelpi.voxlib.collection.map

internal data class AppliedMutableMapPatchImpl<K, V>(
    override val base: Map<K, V>,
    override val patch: MutableMapPatchImpl<K, V>,
) : AppliedMutableMapPatch<K, V> {

    override val keys: AppliedMutableMapPatchKeySetView<K> = AppliedMutableMapPatchKeySetView(this)

    override val size: Int
        get() = keys.size

    override val values: AppliedMutableMapPatchValueCollectionView<V> = AppliedMutableMapPatchValueCollectionView(this)

    override val entries: AppliedMutableMapPatchEntrySetView<K, V> = AppliedMutableMapPatchEntrySetView(this)

    override fun put(key: K, value: V): V? {
        // Get the previous value of the key.
        val previousValue = when (key) {
            in patch.keys.added -> patch.modified[key]
            in patch.keys.removed -> null
            in base.keys -> base[key]
            else -> null
        }

        // Put the new value into the map.
        patch.put(key, value)

        // Return the previous value.
        return previousValue
    }

    override fun remove(key: K): V? {
        // Get the previous value of the key.
        val previousValue = when (key) {
            in patch.keys.added -> patch.remove(key)
            in patch.keys.removed -> null
            in base.keys -> base[key]
            else -> null
        }

        // Remove the value from the map.
        patch.remove(key)

        // Return the previous value.
        return previousValue
    }

    override fun putAll(from: Map<out K, V>) {
        patch.putAll(from)
    }

    override fun clear() {
        patch.revertAll()
        base.keys.forEach(patch::remove)
    }

    override fun isEmpty(): Boolean {
        return keys.isEmpty()
    }

    override fun containsKey(key: K): Boolean {
        return key in keys
    }

    override fun containsValue(value: V): Boolean {
        // Check if the value is set in the patch.
        if (patch.modified.containsValue(value)) {
            return true
        }

        // Check if the value is set in the base (without the keys removed by the patch).
        if (base.filter { it.key !in patch.removed }.containsValue(value)) {
            return true
        }

        // Otherwise the value doesn't exist in the map.
        return false
    }

    override fun get(key: K): V? {
        // Return null if the entry is removed by the patch.
        if (key in patch.removed) {
            return null
        }

        // Return patch value if the entry is modified by the patch.
        if (key in patch.modified) {
            return patch.modified[key]
        }

        // Return base value if the entry is not modified by the patch.
        return base[key]
    }

    override fun reduce(): Map<K, V> {
        return base.withPatch(patch)
    }
}
