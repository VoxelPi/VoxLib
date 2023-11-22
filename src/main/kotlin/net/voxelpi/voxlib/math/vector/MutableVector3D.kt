package net.voxelpi.voxlib.math.vector

import net.voxelpi.voxlib.math.position.MutablePosition3D
import net.voxelpi.voxlib.math.position.Position3
import net.voxelpi.voxlib.math.position.Position3D
import net.voxelpi.voxlib.math.position.mutablePosition3D
import net.voxelpi.voxlib.math.position.position3D
import kotlin.math.cbrt
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

public data class MutableVector3D(
    override var x: Double,
    override var y: Double,
    override var z: Double,
) : Vector3D, MutableVector3<Double> {

    override fun plusAssign(other: Vector3<Double>) {
        x += other.x
        y += other.y
        z += other.z
    }

    override fun minusAssign(other: Vector3<Double>) {
        x -= other.x
        y -= other.y
        z -= other.z
    }

    override fun timesAssign(scalar: Double) {
        x *= scalar
        y *= scalar
        z *= scalar
    }

    override fun divAssign(scalar: Double) {
        x /= scalar
        y /= scalar
        z /= scalar
    }

    override fun set(value: Vector3<Double>) {
        x = value.x
        y = value.y
        z = value.z
    }

    override fun set(value: Double) {
        x = value
        y = value
        z = value
    }

    override fun unaryMinus(): MutableVector3D {
        return MutableVector3D(-x, -y, -z)
    }

    override fun unaryPlus(): MutableVector3D {
        return MutableVector3D(+x, +y, +z)
    }

    override fun plus(other: Vector3<Double>): MutableVector3D {
        return MutableVector3D(x + other.x, y + other.y, z + other.z)
    }

    override fun minus(other: Vector3<Double>): MutableVector3D {
        return MutableVector3D(x - other.x, y - other.y, z - other.z)
    }

    override fun times(scalar: Double): MutableVector3D {
        return MutableVector3D(x * scalar, y * scalar, z * scalar)
    }

    override fun div(scalar: Double): MutableVector3D {
        return MutableVector3D(x / scalar, y / scalar, z / scalar)
    }

    override fun dot(other: Vector3<Double>): Double {
        return x * other.x + y * other.y + z * other.z
    }

    override fun copy(): Vector3D {
        return MutableVector3D(x, y, z)
    }

    override fun mutableCopy(): MutableVector3D {
        return MutableVector3D(x, y, z)
    }

    override fun position(): Position3D {
        return position3D(x, y, z)
    }

    override fun position(origin: Position3<Double>): Position3D {
        return position3D(origin.x + x, origin.y + y, origin.z + z)
    }

    override fun mutablePosition(): MutablePosition3D {
        return mutablePosition3D(x, y, z)
    }

    override fun mutablePosition(origin: Position3<Double>): MutablePosition3D {
        return mutablePosition3D(origin.x + x, origin.y + y, origin.z + z)
    }

    override fun length(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    override fun lengthSquared(): Double {
        return x * x + y * y + z * z
    }

    override fun normalized(): Vector3D {
        return this / length()
    }

    /**
     * Scales the vector by 1 divided by its own length.
     */
    public fun normalize(): MutableVector3D {
        this /= length()
        return this
    }

    public companion object {

        /**
         * Returns a new vector with the given components.
         */
        public fun vector(x: Double, y: Double, z: Double): MutableVector3D {
            return MutableVector3D(x, y, z)
        }

        /**
         * Returns a new vector where each component is equal to [value].
         */
        public fun value(value: Double): MutableVector3D {
            return MutableVector3D(value, value, value)
        }

        /**
         * Generates a random vector.
         */
        public fun random(): MutableVector3D {
            return MutableVector3D(
                Random.nextDouble(),
                Random.nextDouble(),
                Random.nextDouble(),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Double, until: Double): MutableVector3D {
            return MutableVector3D(
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
                Random.nextDouble(from, until),
            )
        }

        /**
         * Generates a random vector where each component lies in the specified range.
         */
        public fun random(from: Vector3<Double>, until: Vector3<Double>): MutableVector3D {
            return MutableVector3D(
                Random.nextDouble(from.x, until.x),
                Random.nextDouble(from.y, until.y),
                Random.nextDouble(from.z, until.z),
            )
        }

        /**
         * Generates a random vector with a length less than the specified [radius].
         */
        public fun randomInsideSphere(radius: Double = 1.0): MutableVector3D {
            return randomOnSphere(radius) * cbrt(Random.nextDouble())
        }

        /**
         * Generates a random vector with a length equal to the specified [radius].
         */
        public fun randomOnSphere(radius: Double = 1.0): MutableVector3D {
            val random = java.util.Random()
            var x = 0.0
            var y = 0.0
            var z = 0.0
            var magnitude = 0.0
            while (magnitude < 1e-8) {
                x = random.nextGaussian()
                y = random.nextGaussian()
                z = random.nextGaussian()
                magnitude = sqrt(x.pow(2) + y.pow(2) + z.pow(2))
            }
            return (mutableVector3D(x, y, z) / magnitude) * radius
        }
    }
}
