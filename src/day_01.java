import java.sql.Array;

//For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
//
//        Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
public class day_01 {
    public static void main(String[] args) {
        String str1="TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2="TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(str1,str2));
    }
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int a = str1.length();
        int b = str2.length();

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return str2.substring(0, a);
    }
}
