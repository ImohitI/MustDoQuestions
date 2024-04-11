package com.interviewprep.hmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // Create a HashMap to store the count of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Create a list of lists to store the numbers based on their frequency
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Populate the freq list with the numbers based on their frequency
        for (int num : count.keySet()) {
            freq[count.get(num)].add(num);
        }

        // Collect the top k frequent numbers
        List<Integer> result = new ArrayList<>();
        for (int i = freq.length - 1; i > 0; i--) {
            for (int num : freq[i]) {
                result.add(num);
                if (result.size() == k) {
                    return result.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }

        return new int[0];
    }
}
