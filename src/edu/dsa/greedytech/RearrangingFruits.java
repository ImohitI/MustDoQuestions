package edu.dsa.greedytech;
import java.util.*;
public class RearrangingFruits {

    public static long minCostToRearrangeFruits (int[] basket1, int[] basket2) {
        int[] combined = new int[basket1.length + basket2.length];
        System.arraycopy(basket1, 0, combined, 0, basket1.length);
        System.arraycopy(basket2, 0, combined, basket1.length, basket2.length);
        
        Map<Integer, Integer> combinedCounter = new HashMap<>();

        // Create frequency count of combined baskets
        for (int fruit : combined) {
            combinedCounter.put(fruit, combinedCounter.getOrDefault(fruit, 0) + 1);
        }

        // Check if making the baskets equal is possible
        for (int count : combinedCounter.values()) {
            if (count % 2 != 0) {
                return -1;
            }
        }

        // Frequency count for excess items in each basket
        Map<Integer, Integer> counter1 = new HashMap<>();
        Map<Integer, Integer> counter2 = new HashMap<>();
        for (int fruit : basket1) {
            counter1.put(fruit, counter1.getOrDefault(fruit, 0) + 1);
        }
        for (int fruit : basket2) {
            counter2.put(fruit, counter2.getOrDefault(fruit, 0) + 1);
        }

        List<Integer> excess1 = new ArrayList<>();
        List<Integer> excess2 = new ArrayList<>();

        // Identify excess fruits in basket1 and basket2
        for (int fruit : combinedCounter.keySet()) {
            int diff = counter1.getOrDefault(fruit, 0) - counter2.getOrDefault(fruit, 0);
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) {
                    excess1.add(fruit);
                }
            } else if (diff < 0) {
                for (int i = 0; i < (-diff) / 2; i++) {
                    excess2.add(fruit);
                }
            }
        }

        Collections.sort(excess1);
        Collections.sort(excess2, Collections.reverseOrder());

        // Smallest fruit cost
        int minFruitCost = Integer.MAX_VALUE;
        for (int fruit : combinedCounter.keySet()) {
            minFruitCost = Math.min(minFruitCost, fruit);
        }

        // Calculate the minimum cost to equalize the baskets
        long totalCost = 0;
        for (int i = 0; i < excess1.size(); i++) {
            totalCost += Math.min(2 * minFruitCost, Math.min(excess1.get(i), excess2.get(i)));
        }

        return totalCost;
    }
    
    public static void main(String[] args) {
        int[][] basket1List = {
                {3, 3, 3, 3, 3, 3, 3, 4},
                {4, 2, 2, 2},
                {2, 3, 4, 1},
                {84, 80, 43, 8, 80, 88, 43, 14, 100, 88},
                {1, 2, 2, 3, 3, 4},
                {4, 4, 4, 4, 3},
        };

        int[][] basket2List = {
                {1, 1, 1, 1, 3, 4, 4, 4},
                {1, 4, 1, 2},
                {3, 2, 5, 1},
                {32, 32, 42, 68, 68, 100, 42, 84, 14, 8},
                {1, 1, 2, 3, 4, 4},
                {5, 5, 5, 5, 3},
        };

        
        for (int i = 0; i < basket1List.length; i++) {
            System.out.print((i + 1) + ".\t Basket 1 = " + Arrays.toString(basket1List[i]));
            System.out.print("\n\t Basket 2 = " + Arrays.toString(basket2List[i]));
            long result = minCostToRearrangeFruits(basket1List[i], basket2List[i]);
            System.out.println("\n\n\t Minimum cost to rearrange fruits in the two baskets is " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
