package net.voxelpi.voxlib.collection.set

public interface MutableSetPatch<E> : SetPatch<E> {

    public fun revert(entry: E)

    public fun revertAll()

    public fun add(element: E)

    public fun remove(element: E)

    public fun addAll(elements: Collection<E>)

    public fun removeAll(elements: Collection<E>)
}
