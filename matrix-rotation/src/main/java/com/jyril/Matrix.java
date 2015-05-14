package com.jyril;

import com.google.common.base.Preconditions;

/**
 * Write a function to rotate an NxN matrix by 90 degrees.
 * You should rotate it in place, meaning you can't use another matrix to perform the rotation,
 * but instead you have to use the same given structure.
 * <p>
 * The solution only keeps 2 temp elements in memory to rotate the matrix in place,
 * rotting inner square borders.
 * Created by jyril81 on 13.05.2015.
 */

public class Matrix {

    private int[][] internalMatrix;

    //to help with output formatting
    private int largestElementSize = 0;

    private Matrix(int[][] internalMatrix, int largestElementSize) {
        this.internalMatrix = internalMatrix;
        this.largestElementSize = largestElementSize;
    }

    public static Matrix createMatrix(int[][] internalMatrix) {
        int largestElementSize = 0;
        for (int[] row : internalMatrix) {
            Preconditions.checkArgument(internalMatrix.length == row.length);
            for (int element : row) {
                int elemSize = String.valueOf(element).length();
                largestElementSize = elemSize > largestElementSize ? elemSize : largestElementSize;
            }
        }
        return new Matrix(internalMatrix, largestElementSize);
    }


    public int[][] rotate90() {
        int rotatingSquareBordersCount = getRotatingSquareBordersCount();

        int rotatingSquareLength = internalMatrix.length;
        int startRowIndex = 0;
        int startColIndex = 0;

        //start from outside and move to inside until all square borders rotated
        for (int i = 0; i < rotatingSquareBordersCount; i++) {
            rotateSquareBorder90(startRowIndex, startColIndex, rotatingSquareLength);

            //switch to inner squareborder
            rotatingSquareLength = rotatingSquareLength - 2;
            //reset new topleft point
            startRowIndex = startRowIndex + 1;
            startColIndex = startColIndex + 1;
        }
        return internalMatrix;
    }

    public void display() {
        for (int[] row : internalMatrix) {
            //display one row
            for (int elem : row) {
                //display elem in a row
                String elemStr = String.valueOf(elem);
                int nrPrecedingSpacePads = largestElementSize - elemStr.length();
                String precesdingSpacePads = "";
                for (int i = 0; i < nrPrecedingSpacePads; i++) {
                    precesdingSpacePads += " ";
                }
                System.out.print(precesdingSpacePads + elemStr + " ");
            }
            //got to next row
            System.out.println();
        }
    }

    int getRotatingSquareBordersCount() {
        return internalMatrix.length / 2;
    }

    private void rotateSquareBorder90(int startRowIndex, int startColIndex, int rotatingSquareLength) {
        int nrOfMoves = rotatingSquareLength - 1;

        for (int i = 0; i < nrOfMoves; i++) {
            rotateSquareBorderByOneUnit(startRowIndex, startColIndex, rotatingSquareLength);
        }
    }

    private void rotateSquareBorderByOneUnit(int startRowIndex, int startColIndex, int rotatingSquareLength) {
        //rotate to right one element at a time saving the one to be overwritten first
        //stop when reached given startRowIndex and startColIndex

        //top row to right starting from second element
        int nextTmp;
        int prevTmp = internalMatrix[startRowIndex][startColIndex];
        for (int i = 1; i < rotatingSquareLength; i++) {
            nextTmp = internalMatrix[startRowIndex][startColIndex + i];
            internalMatrix[startRowIndex][startColIndex + i] = prevTmp;
            prevTmp = nextTmp;
        }

        //right column down starting from second element
        //set colindex to rightmost
        startColIndex = startColIndex + rotatingSquareLength - 1;
        for (int i = 1; i < rotatingSquareLength; i++) {
            nextTmp = internalMatrix[startRowIndex + i][startColIndex];
            internalMatrix[startRowIndex + i][startColIndex] = prevTmp;
            prevTmp = nextTmp;
        }

        //bottom row to left starting from second element
        //set rowindex to bottom one
        startRowIndex = startRowIndex + rotatingSquareLength - 1;
        for (int i = 1; i < rotatingSquareLength; i++) {
            nextTmp = internalMatrix[startRowIndex][startColIndex - i];
            internalMatrix[startRowIndex][startColIndex - i] = prevTmp;
            prevTmp = nextTmp;
        }

        //left column to up starting from second element
        //set colindex leftmost
        startColIndex = startColIndex - rotatingSquareLength + 1;
        for (int i = 1; i < rotatingSquareLength; i++) {
            nextTmp = internalMatrix[startRowIndex - i][startColIndex];
            internalMatrix[startRowIndex - i][startColIndex] = prevTmp;
            prevTmp = nextTmp;
        }
    }
}
