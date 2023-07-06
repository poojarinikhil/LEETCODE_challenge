package Arrays.medium;

import java.util.Arrays;

public class Product_of_Array_except_self {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
        public static int[] productExceptSelf(int[] nums) {
            int [] sm = new int[nums.length];
            int [] pm = new int[nums.length];
            int [] ans = new int[nums.length];
            pm[0] = nums[0];
            sm[nums.length-1] = nums[nums.length-1];

            for(int i = 1; i<nums.length; i++){
                pm[i] = pm[i-1]*nums[i];
            }

            for(int i =nums.length-2; i>=0; i--)
            {
                sm[i] = sm[i+1]*nums[i];
            }

            for(int i =0; i<nums.length; i++)
            {
                if(i==0)
                    ans[i] = 1*sm[i+1];
                else if(i==nums.length-1)
                    ans[i] = pm[i-1]*1;
                else
                    ans[i] = sm[i+1]*pm[i-1];
            }

            return ans; }

}
