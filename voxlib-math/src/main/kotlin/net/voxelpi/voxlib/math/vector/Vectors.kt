package net.voxelpi.voxlib.math.vector

fun vector(vararg data: Double): Vector<Double> {
    return MutableVectorD(data)
}

fun mutableVector(vararg data: Double): MutableVector<Double> {
    return MutableVectorD(data)
}

fun vector2D(x: Double, y: Double): Vector2D {
    return MutableVector2D(x, y)
}

fun mutableVector2D(x: Double, y: Double): MutableVector2D {
    return MutableVector2D(x, y)
}

fun vector3D(x: Double, y: Double, z: Double): Vector3D {
    return MutableVector3D(x, y, z)
}

fun mutableVector3D(x: Double, y: Double, z: Double): MutableVector3D {
    return MutableVector3D(x, y, z)
}
fun vector(vararg data: Int): Vector<Int> {
    return MutableVectorI(data)
}

fun mutableVector(vararg data: Int): MutableVector<Int> {
    return MutableVectorI(data)
}

fun vector2I(x: Int, y: Int): Vector2I {
    return MutableVector2I(x, y)
}

fun mutableVector2I(x: Int, y: Int): MutableVector2I {
    return MutableVector2I(x, y)
}

fun vector3I(x: Int, y: Int, z: Int): Vector3I {
    return MutableVector3I(x, y, z)
}

fun mutableVector3I(x: Int, y: Int, z: Int): MutableVector3I {
    return MutableVector3I(x, y, z)
}
