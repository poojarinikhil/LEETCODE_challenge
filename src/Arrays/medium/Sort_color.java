package Arrays.medium;

import java.util.Arrays;

public class Sort_color {
    public static void main(String[] args) {
        int[] a = {1,0,2,2,0,1};
        System.out.println(Arrays.toString(sortColors(a)));
    }
    public static int[] sortColors(int[] nums) {
        for(int i=0 ;i<nums.length;i++){
            for(int j=0; j<nums.length-1;j++){
                int temp = 0;
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
}
