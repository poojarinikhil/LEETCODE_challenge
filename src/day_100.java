import java.util.Arrays;

public class day_100 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        for(int i=0;i<2*nums.length;i++){
            if(i<nums.length){
                ans[i]=nums[i];
            }
            else{
                ans[i] = nums[i-nums.length];
            }
        }
        return ans;
    }
}
