//
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        And then read line by line: "PAHNAPLSIIGYIR"
//
//        Write the code that will take a string and make this conversion given a number of rows:
//   string convert(string s, int numRows);
//
// my attempt

// public class day_03 {
//        public String convert(String s, int numRows) {
//            char[][] twoD = new char[numRows][];
//            char[] string = new char[s.length()];
//            for (int i = 0; i < s.length(); i++) {
//                string[i] = s.charAt(i);
//            }
//            int column = 0;
//            int letter = 0;
//            while (letter<string.length){
//                for (int j = 0; j < numRows; j++) {
//                    twoD[j][column]= string[letter];
//                    letter++;
//                }
//                column++;
//                for (int j = numRows-2; j >0 ; j--) {
//                    twoD[j][column]=string[letter];
//                    letter++;
//                    column++;
//                }
//            }
//        return s;
//        }
//}

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int k = 2* (numRows -1);
        for(int i=0;i<numRows;i++){
            int index = i ;
            while(index<n){
                str.append(s.charAt(index));
                if(i!=0 && i!=numRows-1){
                    int k1 = k- (2*i);
                    int k2 = index + k1;
                    if(k2<n){
                        str.append(s.charAt(k2));
                    }
                }
                index = index + k;
            }
        }
        return str.toString();
    }
}
