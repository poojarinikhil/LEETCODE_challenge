package Arrays.medium;
import java.util.Arrays;
public class Rotate_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5}, 2)));
    }
    public static int[] rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,k-1);
        return nums;
    }
    public static int[] reverse(int[] nums, int start, int end){
        int sp=start;
        int ep = end;
        int temp=0;
        for(int i = start;i<=end/2;i++){
            temp=nums[sp];
            nums[sp]=nums[ep];
            nums[ep]=temp;
            sp++;
            ep--;
        }
        return nums;
    }
}
