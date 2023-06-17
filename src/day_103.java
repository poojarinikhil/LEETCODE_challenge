import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day_103 {
    public static void main(String[] args) {
        int []candies= new int[]{2,3,5,1,3};
        System.out.println(kidsWithCandies(candies,3));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = bigger(candies);
        List<Boolean> output=new ArrayList<Boolean>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                output.add(Boolean.TRUE);
            } else {
                output.add(Boolean.FALSE);
            }
        }
        return output;
    }
    public static int bigger(int[] candies){
        int max = -1;
        for (int i = 0; i <candies.length; i++) {
            if(candies[i]>max){
                max = candies[i];
            }
        }
        return max;
    }
}
