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
