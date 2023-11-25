package Codevita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BalancedChemicalCompound {
    // Function to calculate the valency of an element
    static int getValency(char element) {
        int a = element;
        while (a%10 !=a){
            int one=a%10;
            int ten =a/10;
//            int ten_digit = ten/10;
            a = one + ten ;
        }
        return a;
    }

    // Function to find combinations of the given compound to reach the equivalent point
    static ArrayList<String> findCombinations(String compound, int equivalentPoint) {
        char firstElement = compound.charAt(0);
        char secondElement = compound.charAt(1);

        // Calculate valencies of the two elements
        int valency1 = getValency(firstElement);
        int valency2 = getValency(secondElement);

        // Store the combinations
        ArrayList<String> result = new ArrayList<>();

        // Iterate over multiples of valency1
        for (int multiple1 = 0; multiple1 <= equivalentPoint / valency1; multiple1++) {
            int remaining = equivalentPoint - (multiple1 * valency1);

            // Check if remaining is a multiple of valency2
            if (remaining % valency2 == 0 && multiple1 != 0) {
                int multiple2 = remaining / valency2;
                if (multiple2 != 0) {
                    result.add(String.format("%c%d %c%d", firstElement, multiple1, secondElement, multiple2));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input: the non-balanced compound and the equivalent point
        String compound = scanner.nextLine();
        int equivalentPoint = scanner.nextInt();

        // Find combinations to reach the equivalent point
        ArrayList<String> combinations = findCombinations(compound, equivalentPoint);

        // Print the result
        if (combinations.isEmpty()) {
            System.out.println("Not Possible");
        } else {
            Collections.reverse(combinations);
            for (String combination : combinations) {
                System.out.println(combination);
            }
        }

        scanner.close();
    }
}
