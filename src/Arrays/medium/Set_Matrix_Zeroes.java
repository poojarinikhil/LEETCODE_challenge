//---------------------------------------------------------------
//question
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//        You must do it in place.
//
//
//
//        Example 1:
//
//
//        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        Output: [[1,0,1],[0,0,0],[1,0,1]]
//        Example 2:
//
//
//        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
package Arrays.medium;

import java.util.Arrays;

public class Set_Matrix_Zeroes {
    public static void main(String[] args) {
        int[][] matrix= {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j] == 0){
                    for (int k = 0; k < m; k++) {
                        arr[k][j]= 0;
                    }
                    for (int l = 0; l < n; l++) {
                        arr[i][l]= 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
