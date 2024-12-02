package edu.dsa.greedytech;

import java.util.Arrays;

public class BoatSave {
    public static void main(String[] args) {
        int [][] people = {
            {1, 2},
            {3, 2, 2, 1},
            {3, 5, 3, 4},
            {5, 5, 5, 5},
            {1, 2, 3, 4},
            {1, 2, 3},
            {3, 4, 5}
        };
        int [] limit = {3, 3, 5, 5, 5, 3, 5};
    
        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + "\tWeights = " + Arrays.toString(people[i]));
            System.out.println("\tWeight limit " + limit[i]);
            System.out.println("\tThe minimum no of boats " + rescueBoats(people[i], limit[i]));
            System.out.println("----------------------------------");
        }
    }

    public static int rescueBoats(int[] people, int wlimit) {
        Arrays.sort(people);

        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= wlimit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }


}
