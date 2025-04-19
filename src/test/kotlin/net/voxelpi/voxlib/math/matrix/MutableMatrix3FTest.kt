package net.voxelpi.voxlib.math.matrix

import org.junit.jupiter.api.Test

class MutableMatrix3FTest {

    @Test
    fun `check 3x3 matrix`() {
        val matrix = matrix3F(
            1f, 2f, 3f,
            4f, 5f, 6f,
            7f, 8f, 9f,
        )

        assert(matrix[0, 0] == 1f)
        assert(matrix[0, 1] == 2f)
        assert(matrix[0, 2] == 3f)
        assert(matrix[1, 0] == 4f)
        assert(matrix[1, 1] == 5f)
        assert(matrix[1, 2] == 6f)
        assert(matrix[2, 0] == 7f)
        assert(matrix[2, 1] == 8f)
        assert(matrix[2, 2] == 9f)
    }
}
