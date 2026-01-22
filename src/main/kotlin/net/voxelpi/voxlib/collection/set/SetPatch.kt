package net.voxelpi.voxlib.collection.set

public interface SetPatch<out E> {

    public val added: Set<E>

    public val removed: Set<E>

    public fun copy(): SetPatch<E>
}

public fun <E> SetPatch<E>.mutableCopy(): MutableSetPatch<E> {
    return MutableSetPatchImpl(added.toMutableSet(), removed.toMutableSet())
}
