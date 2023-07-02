//------------------------------------------------------
//question
//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//Input: n = 3
//        Output: [[1,2,3],[8,9,4],[7,6,5]]
//        Example 2:
//
//        Input: n = 1
//        Output: [[1]]
package Arrays.medium;

import java.util.Arrays;

public class spiral_matrix_II {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
            int left = 0;
            int right=n-1;
            int up = 0 ;
            int down = n-1;
            int num =1;

            while (left<=right && up<=down) {
                for (int i = left; i <= right; i++) {
                    matrix[up][i]=num;
                    num++;
                }
                up++;
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = num;
                    num++;
                }
                right--;
                if (up <= down){
                    for (int i = right; i >= left; i--) {
                        matrix[down][i]=num;
                        num++;
                    }
                    down--;
                }
                if(left <= right) {
                    for (int i = down; i >= up; i--) {
                        matrix[i][left]=num;
                        num++;
                    }
                    left++;
                }
            }
            return matrix;
        }
    }
