package net.voxelpi.voxlib.math.quaternion

import net.voxelpi.voxlib.math.vector.Vector3F
import kotlin.math.cos
import kotlin.math.sin

public fun quaternionF(): QuaternionF {
    return MutableQuaternionF(1F, 0F, 0F, 0F)
}

public fun quaternionF(w: Float, x: Float, y: Float, z: Float): QuaternionF {
    return MutableQuaternionF(w, x, y, z)
}

public fun quaternionF(angle: Float, axis: Vector3F): QuaternionF {
    return MutableQuaternionF(
        cos(angle / 2F),
        axis.x * sin(angle / 2F),
        axis.y * sin(angle / 2F),
        axis.z * sin(angle / 2F),
    )
}

public fun mutableQuaternionF(): MutableQuaternionF {
    return MutableQuaternionF(1F, 0F, 0F, 0F)
}

public fun mutableQuaternionF(w: Float, x: Float, y: Float, z: Float): MutableQuaternionF {
    return MutableQuaternionF(w, x, y, z)
}

public fun mutableQuaternionF(angle: Float, axis: Vector3F): MutableQuaternionF {
    return MutableQuaternionF(cos(angle / 2F), axis.x * sin(angle / 2F), axis.y * sin(angle / 2F), axis.z * sin(angle / 2F))
}
