//You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
//
//        The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
//
//        Return the earliest year with the maximum population.
//
//
//
//        Example 1:
//
//        Input: logs = [[1993,1999],[2000,2010]]
//        Output: 1993
//        Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
//        Example 2:
//
//        Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
//        Output: 1960
//        Explanation:
//        The maximum population is 2, and it had happened in years 1960 and 1970.
//        The earlier year between them is 1960.

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maximum_population {
    public static void main(String[] args) {
        int [][] logs = {{1950,1961},{1960,1971},{1970,1981},{1975,1985},{1978,1988}};
        System.out.println(maximumPopulation(logs));
    }
//    I tried but failedj
//    public static int maximumPopulation(int[][] logs) {
//        int maxpopulation =0;
//        int pointer = 0;
//        int smalleryear=0;
//        for (int i = 0; i < logs.length; i++) {
//            int birthyear=logs[i][0];
//            int deathyear=logs[i][1];
//            int population = 0;
//            List<Integer> year = new ArrayList<Integer>();
//            for (int j = i+1; j < logs.length; j++) {
//                if(deathyear <logs[j][0]){
//                    population++;
//                    year.add(logs[j][0]);
//                }
//            }
//            if(population > maxpopulation){
//                maxpopulation = population;
//            }
//        }
//    }
public static int maximumPopulation(int[][] logs) {

    int[] year = new int[101];
    // O(n) -> n is log.length

    for(int[] log : logs){
        year[log[0] - 1950]++;
        year[log[1] - 1950]--;
    }

    int maxNum = year[0], maxYear = 1950;

    for(int i = 1; i < year.length; i++){
        year[i] += year[i - 1];  // Generating Prefix Sum
        if(year[i] > maxNum){
            maxNum = year[i];
            maxYear = i + 1950;
        }
    }
    return maxYear;
}
}
