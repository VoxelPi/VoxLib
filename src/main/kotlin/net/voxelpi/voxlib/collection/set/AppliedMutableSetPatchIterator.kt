package net.voxelpi.voxlib.collection.set

internal class AppliedMutableSetPatchIterator<out E>(
    val appliedPatch: AppliedMutableSetPatch<out E>,
) : MutableIterator<E> {

    val baseIterator = appliedPatch.base.iterator()
    val patchIterator = appliedPatch.patch.added.iterator()

    private var last: E? = null
    private var hasLast = false

    private var peek: Result<E>? = null
    private var hasPeek = false

    override fun remove() {
        check(hasLast) { "Call next() before removing element from the iterator." }

        @Suppress("UNCHECKED_CAST")
        appliedPatch.remove(last as E)
        hasLast = false
    }

    override fun next(): E {
        // Get the next element
        peekNext()

        // Return the next element.
        val result = peek!!
        hasPeek = false
        peek = null
        return result.getOrThrow()
    }

    override fun hasNext(): Boolean {
        peekNext()
        return peek!!.isSuccess
    }

    private fun peekNext() {
        // Don't do anything if already peeked.
        if (hasPeek) {
            return
        }

        // First try to get an element from the base.
        while (baseIterator.hasNext()) {
            // Get the next element in the base set.
            val next = baseIterator.next()

            // Only use it, if it is not present in the patches removed set, otherwise go to the next element.
            if (next !in appliedPatch.patch.removed) {
                peek = Result.success(next)
                hasPeek = true
                return
            }
        }

        // Use the next element of the patch iterator.
        peek = runCatching { patchIterator.next() }
        hasPeek = true
    }
}
