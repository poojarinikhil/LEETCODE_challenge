//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
//        Example 2:
//
//        Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.
package Arrays_question.medium;
import java.util.*;
import java.util.ArrayList;

public class House_Robber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{4,1,2,7,5,3,1}));
    }
    public static int rob(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 1; j <nums.length ; j++) {
            int sum=0;
            int sum2=0;
            for(int i=0; i<nums.length;i++){
                sum+=nums[i];
                if(i+j<nums.length) {
                    i=i+j;
                }
                else {
                    break;
                }
            }
            list.add(sum);
            for(int i=1; i<nums.length;i++){
                sum2+=nums[i];
                if(i+j<nums.length) {
                    i=i+j;
                }
                else {
                    break;
                }
            }
            list.add(sum2);
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
