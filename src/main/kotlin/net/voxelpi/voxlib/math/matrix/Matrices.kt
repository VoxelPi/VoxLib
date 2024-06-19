package net.voxelpi.voxlib.math.matrix

@Suppress("ktlint:standard:parameter-list-wrapping")
public fun matrix4F(
    m00: Float, m01: Float, m02: Float, m03: Float,
    m10: Float, m11: Float, m12: Float, m13: Float,
    m20: Float, m21: Float, m22: Float, m23: Float,
    m30: Float, m31: Float, m32: Float, m33: Float,
): Matrix4F {
    return MutableMatrix4F(floatArrayOf(m00, m10, m20, m30, m01, m11, m21, m31, m02, m12, m22, m32, m03, m13, m23, m33))
}
