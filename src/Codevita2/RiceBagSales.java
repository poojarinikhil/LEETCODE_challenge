package Codevita2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class RiceBagSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

    // Function to calculate the maximum number of bags that can be sold
    private static int getMaxBagsSold(int[][] customers, int[][] riceBags) {
        int maxBagsSold = 0;

        // Sort customers based on price preference in descending order
        Arrays.sort(customers, new Comparator<int[]>() {
            @Override
            public int compare(int[] customer1, int[] customer2) {
                return Integer.compare(customer2[1], customer1[1]);
            }
        });

        // Create a priority queue of rice bags sorted by quantity in descending order
        PriorityQueue<int[]> bagQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] bag1, int[] bag2) {
                return Integer.compare(bag2[0], bag1[0]);
            }
        });

        // Add rice bags to the priority queue
        for (int[] riceBag : riceBags) {
            bagQueue.add(riceBag);
        }

        // Iterate through the sorted customers
        for (int[] customer : customers) {
            int customerQuantityPreference = customer[0];
            int customerPricePreference = customer[1];

            // Check if the rice bag satisfies the customer's preferences
            while (!bagQueue.isEmpty() && bagQueue.peek()[1] <= customerPricePreference) {
                int[] bag = bagQueue.poll();

                if (bag[0] > customerQuantityPreference) {
                    maxBagsSold++;
                    break; // Move to the next customer
                }
            }
        }

        return maxBagsSold;
}
}