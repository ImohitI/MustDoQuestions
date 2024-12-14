package edu.dsa.greedytech;

import java.util.Arrays;

class TwoCitySchedule {

    public static int twoCityScheduling(int[][] arr) {
        int result = 0;

        Arrays.sort(arr, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int costLength = arr.length;

        for (int i = 0; i < costLength; i++) {
            result += arr[i][0] + arr[costLength - i - 1][1];
        }


        return result;
    }

    public static void main(String[] args) {
        int[][][] inputCosts = {{{10, 20}, {30, 200}, {400, 50}, {30,20}},
        {{259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}},
        {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779},{457, 60}, {650, 359}, {631, 42}},
        {{1, 2}, {3, 4}, {5, 6}, {7,8}},
        {{1, 2}, {1, 2}, {1, 2}, {1, 2}},
        {{10, 100}, {10, 1000}, {50, 500}, {1,100}}};

        for(int i=0;i < inputCosts.length;i++){
            System.out.println((i + 1)+ "\tcosts"+ Arrays.deepToString(inputCosts[i]));
            System.out.println("\n\tThe minimum cost to send people equally into city A and B is: "+ twoCityScheduling(inputCosts[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        
    }
}