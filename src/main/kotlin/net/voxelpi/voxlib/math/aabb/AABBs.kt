package net.voxelpi.voxlib.math.aabb

import net.voxelpi.voxlib.math.position.Position2D
import net.voxelpi.voxlib.math.position.Position2F
import net.voxelpi.voxlib.math.position.Position2I
import net.voxelpi.voxlib.math.position.Position3D
import net.voxelpi.voxlib.math.position.Position3F
import net.voxelpi.voxlib.math.position.Position3I
import net.voxelpi.voxlib.math.vector.Vector2D
import net.voxelpi.voxlib.math.vector.Vector2F
import net.voxelpi.voxlib.math.vector.Vector2I
import net.voxelpi.voxlib.math.vector.Vector3D
import net.voxelpi.voxlib.math.vector.Vector3F
import net.voxelpi.voxlib.math.vector.Vector3I
import net.voxelpi.voxlib.math.vector.vector2I
import net.voxelpi.voxlib.math.vector.vector3I

public fun aabb2D(min: Position2D, max: Position2D): AABB2D {
    return MutableAABB2D(min.mutableCopy(), max.mutableCopy())
}

public fun aabb2D(position: Position2D, size: Vector2D): AABB2D {
    return MutableAABB2D(position.mutableCopy(), (position + size).mutableCopy())
}

public fun mutableAABB2D(min: Position2D, max: Position2D): MutableAABB2D {
    return MutableAABB2D(min.mutableCopy(), max.mutableCopy())
}

public fun mutableAABB2D(position: Position2D, size: Vector2D): MutableAABB2D {
    return MutableAABB2D(position.mutableCopy(), (position + size).mutableCopy())
}

public fun aabb2F(min: Position2F, max: Position2F): AABB2F {
    return MutableAABB2F(min.mutableCopy(), max.mutableCopy())
}

public fun aabb2F(position: Position2F, size: Vector2F): AABB2F {
    return MutableAABB2F(position.mutableCopy(), (position + size).mutableCopy())
}

public fun mutableAABB2F(min: Position2F, max: Position2F): MutableAABB2F {
    return MutableAABB2F(min.mutableCopy(), max.mutableCopy())
}

public fun mutableAABB2F(position: Position2F, size: Vector2F): MutableAABB2F {
    return MutableAABB2F(position.mutableCopy(), (position + size).mutableCopy())
}

public fun aabb2I(min: Position2I, max: Position2I): AABB2I {
    return MutableAABB2I(min.mutableCopy(), max.mutableCopy())
}

public fun aabb2I(position: Position2I, size: Vector2I): AABB2I {
    return MutableAABB2I(position.mutableCopy(), (position + size - vector2I(1, 1)).mutableCopy())
}

public fun mutableAABB2I(min: Position2I, max: Position2I): MutableAABB2I {
    return MutableAABB2I(min.mutableCopy(), max.mutableCopy())
}

public fun mutableAABB2I(position: Position2I, size: Vector2I): MutableAABB2I {
    return MutableAABB2I(position.mutableCopy(), (position + size - vector2I(1, 1)).mutableCopy())
}

public fun aabb3D(min: Position3D, max: Position3D): AABB3D {
    return MutableAABB3D(min.mutableCopy(), max.mutableCopy())
}

public fun aabb3D(position: Position3D, size: Vector3D): AABB3D {
    return MutableAABB3D(position.mutableCopy(), (position + size).mutableCopy())
}

public fun mutableAABB3D(min: Position3D, max: Position3D): MutableAABB3D {
    return MutableAABB3D(min.mutableCopy(), max.mutableCopy())
}

public fun mutableAABB3D(position: Position3D, size: Vector3D): MutableAABB3D {
    return MutableAABB3D(position.mutableCopy(), (position + size).mutableCopy())
}

public fun aabb3F(min: Position3F, max: Position3F): AABB3F {
    return MutableAABB3F(min.mutableCopy(), max.mutableCopy())
}

public fun aabb3F(position: Position3F, size: Vector3F): AABB3F {
    return MutableAABB3F(position.mutableCopy(), (position + size).mutableCopy())
}

public fun mutableAABB3F(min: Position3F, max: Position3F): MutableAABB3F {
    return MutableAABB3F(min.mutableCopy(), max.mutableCopy())
}

public fun mutableAABB3F(position: Position3F, size: Vector3F): MutableAABB3F {
    return MutableAABB3F(position.mutableCopy(), (position + size).mutableCopy())
}

public fun aabb3I(min: Position3I, max: Position3I): AABB3I {
    return MutableAABB3I(min.mutableCopy(), max.mutableCopy())
}

public fun aabb3I(position: Position3I, size: Vector3I): AABB3I {
    return MutableAABB3I(position.mutableCopy(), (position + size - vector3I(1, 1, 1)).mutableCopy())
}

public fun mutableAABB3I(min: Position3I, max: Position3I): MutableAABB3I {
    return MutableAABB3I(min.mutableCopy(), max.mutableCopy())
}

public fun mutableAABB3I(position: Position3I, size: Vector3I): MutableAABB3I {
    return MutableAABB3I(position.mutableCopy(), (position + size - vector3I(1, 1, 1)).mutableCopy())
}
