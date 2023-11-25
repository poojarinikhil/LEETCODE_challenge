package Arrays_question.medium;

import java.util.Arrays;

public class first_and_last_pos {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4};
        System.out.println(Arrays.toString(searchRange(nums, 4)));
    }
    public static int[] searchRange(int[] arr, int t) {
        int[] brr=new int[2];
        brr[0]=-1;brr[1]=-1;
        int f=-1;int l=-1;
        for(int i=0;i<arr.length;i++){
            if(t==arr[i]){
                if(f==-1){
                    brr[0]=i;
                    f++;
                }
                else{
                    brr[1]=i;
                    l++;
                }
            }
        }
        if(f!=-1&&l==-1){
            brr[1]=brr[0];
            return brr;
        }

        return brr;
    }
}
