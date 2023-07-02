package Arrays.medium;

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
            if (up <= down){
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);

                }
            down--;
            }
            if(left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);

                }
                left++;
            }
        }
        return result;
    }
}
//-----------------------------------------------------
//Explanation
//first we declare the the four variables up down left right to count
//the columns and rows which are transversed and also we can assign
//the end condition of when the matrix is fully tranversed
//Now we create the for loop for which direction we have to move and
//which column or row we have tranverse will be incremented
//in for loop i will be from where to where you are moving and as for loop
//is ended it will increment or decrement the row or the column it as tranversed
//if state is used to check up and left is less then down and right