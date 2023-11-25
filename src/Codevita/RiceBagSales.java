package Codevita;

import java.util.Scanner;
import java.util.*;

public class RiceBagSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[][] customers2={{35,2400},
//                            {70,5500},
//                            {87,6000},
//                            {20,1700},
//                            {12,500}};
//        int[][] ricebags2={{50,2500},
//                            {75,4875},
//                            {100,7000},
//                            {25,1250}};
//        int maxBagsSold = getMaxBagsSold(customers2, ricebags2);
//        System.out.println(maxBagsSold);
        // Read the number of customers and rice bags
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read customer preferences
        int[][] customers = new int[n][2];
        for (int i = 0; i < n; i++) {
            customers[i][0] = scanner.nextInt(); // quantity preference
            customers[i][1] = scanner.nextInt(); // price preference
        }

        // Read rice bags attributes
        int[][] riceBags = new int[m][2];
        for (int i = 0; i < m; i++) {
            riceBags[i][0] = scanner.nextInt(); // bag quantity
            riceBags[i][1] = scanner.nextInt(); // bag price
        }

        // Calculate the maximum number of bags that can be sold
        int maxBagsSold = getMaxBagsSold(customers, riceBags);

        // Print the result
        System.out.println(maxBagsSold);

        // Close the scanner
        scanner.close();
    }
    public static int[][] sort(int[][] ricebags){
        Arrays.sort(ricebags, Comparator.comparingInt(a -> a[0]));
        return ricebags;
    }
    public static int binary(int customerQuantityPreference, int customerPricePreference,int m,int[][] ricebags){
        int start = 0;
        int end = m;
        int count = 0;
        while (start<end){
            int middle = start+(end - start) /2;
            if (ricebags[middle][0]<customerQuantityPreference){
                start = middle +1;
            }
            else{
                if(ricebags[middle][1] <= customerPricePreference){
                    count =1;
                    return count;
                }
                else{
                    start = middle;
                }
            }
        }
        return count;
    }
    // Function to calculate the maximum number of bags that can be sold
    private static int getMaxBagsSold(int[][] customers, int[][] riceBags) {
        int maxBagsSold = 0;
//        int matches = 0;
        int[][] ricebags = sort(riceBags);
        for (int i = 0; i < customers.length; i++) {
            int customerQuantityPreference = customers[i][0];
            int customerPricePreference = customers[i][1];

//            for (int j = 0; j < riceBags.length; j++) {
//                int bagQuantity = riceBags[j][0];
//                int bagPrice = riceBags[j][1];
//
//                // Check if the bag satisfies the customer's preferences
//                if (bagPrice <= customerPricePreference && bagQuantity > customerQuantityPreference) {
//                    maxBagsSold++;
//                    break; // Move to the next customer
//                }
//            }
            maxBagsSold+=binary(customerQuantityPreference,customerPricePreference,ricebags.length,ricebags);
        }
        return maxBagsSold;
}
}