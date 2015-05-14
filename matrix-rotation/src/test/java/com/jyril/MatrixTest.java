package com.jyril;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Write a function to rotate an NxN matrix by 90 degrees.
 * You should rotate it in place, meaning you can't use another matrix to perform the rotation,
 * but instead you have to use the same given structure.
 * Created by jyril81 on 13.05.2015.
 */
public class MatrixTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testRotate90Empty() throws Exception {
        int[][] internalMatrix = new int[][]{};
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        System.out.println("Before: ");
        matrix.display();

        int[][] rotated90 = matrix.rotate90();

        assertArrayEquals(internalMatrix, rotated90);
        System.out.println("After: ");
        matrix.display();
    }

    @Test
    public void testRotate90Size1() throws Exception {
        int[][] internalMatrix = new int[][]{
                {1}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        System.out.println("Before: ");
        matrix.display();

        int[][] rotated90 = matrix.rotate90();

        assertArrayEquals(internalMatrix, rotated90);
        System.out.println("After: ");
        matrix.display();
    }

    @Test
    public void testRotate90Size2() throws Exception {
        int[][] internalMatrix = new int[][]{
                {1, 2},
                {3, 4}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        System.out.println("Before: ");
        matrix.display();
        int[][] expectedResult = new int[][]{
                {3, 1},
                {4, 2}
        };

        int[][] rotate90 = matrix.rotate90();

        assertArrayEquals(expectedResult, rotate90);
        System.out.println("After: ");
        matrix.display();
    }

    @Test
    public void testRotate90Size3() throws Exception {
        int[][] internalMatrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        System.out.println("Before: ");
        matrix.display();
        int[][] expectedResult = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        int[][] rotate90 = matrix.rotate90();

        assertArrayEquals(expectedResult, rotate90);
        System.out.println("After: ");
        matrix.display();
    }

    @Test
    public void testRotate90Size4() throws Exception {
        int[][] internalMatrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        System.out.println("Before: ");
        matrix.display();
        int[][] expectedResult = new int[][]{
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };

        int[][] rotate90 = matrix.rotate90();

        assertArrayEquals(expectedResult, rotate90);
        System.out.println("After: ");
        matrix.display();
    }

    @Test
    public void testRotate90Size5() throws Exception {
        int[][] internalMatrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        System.out.println("Before: ");
        matrix.display();
        int[][] expectedResult = new int[][]{
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5}
        };

        int[][] rotate90 = matrix.rotate90();

        assertArrayEquals(expectedResult, rotate90);
        System.out.println("After: ");
        matrix.display();
    }


    @Test
    public void testCreateMatrix() {
        int[][] internalMatrix = new int[][]{
                {1, 2},
                {325, 4}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertNotNull(matrix);
    }

    @Test
    public void testCreateEmptyMatrix() {
        int[][] internalMatrix = new int[][]{};
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertNotNull(matrix);
    }

    @Test
    public void testCreateMatrixWithSize1() {
        int[][] internalMatrix = new int[][]{
                {1}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertNotNull(matrix);
    }

    @Test
    public void testCreateMatrixThrowsWhenNotSquare() {
        int[][] internalMatrix = new int[][]{
                {1, 2, 3},
                {3, 4}
        };
        expectedException.expect(IllegalArgumentException.class);
        Matrix.createMatrix(internalMatrix);
    }

    @Test
    public void testGetRotatingSquareBordersCountForEvenSizedMatrix() {
        int[][] internalMatrix = new int[][]{
                {1, 2, 3, 4},
                {325, 4, 12, 5},
                {3, 53, 234, 9},
                {94, 22, 3, 9}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertEquals(2, matrix.getRotatingSquareBordersCount());
    }

    @Test
    public void testGetRotatingSquareBordersCountForOddSizedMatrix() {
        int[][] internalMatrix = new int[][]{
                {1, 2, 3},
                {325, 4, 12},
                {3, 53, 234}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertEquals(1, matrix.getRotatingSquareBordersCount());
    }

    @Test
    public void testGetRotatingSquareBordersCountForEmptyMatrix() {
        int[][] internalMatrix = new int[][]{};
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertEquals(0, matrix.getRotatingSquareBordersCount());
    }

    @Test
    public void testGetRotatingSquareBordersCountForMatrixWithSize1() {
        int[][] internalMatrix = new int[][]{
                {27}
        };
        Matrix matrix = Matrix.createMatrix(internalMatrix);
        assertEquals(0, matrix.getRotatingSquareBordersCount());
    }
}
