package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int down  = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> result = new ArrayList<>();
        while (left<=right && up<=down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);

            }
            up++;
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);

            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);

            }
            down--;
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);

            }
            left++;
        }
        return result;
    }
}
