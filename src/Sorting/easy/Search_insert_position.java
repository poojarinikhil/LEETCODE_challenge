package Sorting.easy;

public class Search_insert_position {
    public static void main(String[] args) {
        int[] arr = {1,3};
//        int target =7;
        searchInsert(arr,2);
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        if(target>nums[nums.length-1]){
            mid = nums.length;
            return mid;
        }
        if(target<nums[0]){
            mid = 0;
            return mid;
        }
        while(start < end){
            mid = start+(end-start)/2;
            if(target>nums[mid]){
                start = mid +1;
            }
            else if(target<nums[mid]){
                end = mid;
            }
            else{
                return mid;
            }
        }
        return mid;
    }
}
