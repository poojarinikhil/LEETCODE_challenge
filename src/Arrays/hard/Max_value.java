//You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
//
//        Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
//
//        It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
//
//
//
//        Example 1:
//
//        Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//        Output: 4
//        Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
//        No other pairs satisfy the condition, so we return the max of 4 and 1.
//        Example 2:
//
//        Input: points = [[0,0],[3,0],[9,2]], k = 3
//        Output: 3
//        Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
package Arrays.hard;

public class Max_value {
    public static void main(String[] args) {
        System.out.println(findMaxValueOfEquation(new int[][]{{1,3},{2,0},{5,10},{6,-10}},1));
    }
    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max = -10*100000000;
        int value = -10*100000000;
        // int value = 0;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                int mod = Math.abs(points[i][0] - points[j][0]);
                if(mod<=k){
                    value = points[i][1] + points[j][1] + mod;
                }
                if(value>max){
                    max = value;
                }
            }
        }
        return max;
    }
}
//this value code doesnt satisfy all the condition because of more time taken this almost a solution
//code is self explanatory