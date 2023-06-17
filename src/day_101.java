import java.util.Arrays;

public class day_101 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3})));
    }
        public static int[] runningSum(int[] nums) {
            int[] ans = new int[nums.length];
            for(int i = 0; i<nums.length;i++){
                int j = i;
                if(i>0){
                    while(j<=i && j>=0){
                        ans[i]=ans[i]+nums[j];
                        j--;
                    }
                }
                else{
                    ans[0]= nums[0];
                }
            }
            return ans;
        }

}
