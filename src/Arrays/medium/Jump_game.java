//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//        Return true if you can reach the last index, or false otherwise.
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//        Example 2:
//
//        Input: nums = [3,2,1,0,4]
//        Output: false
//        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//--------------------------------------------------------------------
package Arrays.medium;

public class Jump_game {
    public boolean canJump(int[] nums) {
        int currMaximum = 0;
        int checker = 0;
        if(nums.length == 1){
            return true;
        }
        for(int i = 0 ; i < nums.length -1 ; i++){
            currMaximum = Math.max(currMaximum , nums[i] + i);
            if(checker == i){
                checker = currMaximum;
            }
            if(currMaximum >= nums.length-1){
                return true;
            }
            if(nums[checker]==0 && i==checker){
                return false;
            }
        }
        return true;
    }
}
//---------------------------------------------------
//so here there are two variable that is currMaximum and checker so currmaximum is use to calculate
//the maximum element can jump till where and if it exceeds the nums length then it will return true
//if not the when the checker and i are equal then it will assign checker as maximum and the the check will
//check if the value at the checker position a 0 if yes the it will return false