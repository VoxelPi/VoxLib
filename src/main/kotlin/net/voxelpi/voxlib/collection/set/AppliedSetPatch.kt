package net.voxelpi.voxlib.collection.set

public interface AppliedSetPatch<out E> : Set<E> {

    public val base: Set<E>

    public val patch: SetPatch<E>

    public fun reduce(): Set<E>
}
