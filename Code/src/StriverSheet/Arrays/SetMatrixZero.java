package StriverSheet.Arrays;

import java.util.Scanner;
//Link: https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {

    public static void main(String[] args) {
//        int m = 3, n = 3;
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        SetMatrixZero q = new SetMatrixZero();
        q.setZeroes(matrix);
    }
    public void print(int[][] matrix) {
        for(int[] i: matrix) {
            for(int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)  col0 = 0;
            for(int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        }
        print(matrix);

        for(int i = matrix.length-1; i >= 0; i--) {
            for(int j = matrix[0].length-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }

        }
        print(matrix);

    }

}
