package com.interviewprep.hmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            if (map.containsKey(match) && map.get(match) != i) {
                result = new int[] { i, map.get(match) };
                break;
            }
        }
        return result;
    }

    public static int[] twoSum_singlePass(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            if (!map.containsKey(match)) {
                map.put(nums[i], i);
            } else {
                result = new int[] { map.get(match), i };
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // printExp();
        System.out.println(" In main");
        int[] res = twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println(Arrays.toString(res));
        res = twoSum_singlePass(new int[] { 3, 2, 4 }, 6);
        System.out.println(Arrays.toString(res));
    }

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void printExp() {
        int[] ints = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(IntStream.of(ints).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
        System.out.println(IntStream.of(ints).boxed().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(Arrays.toString(ints));

        String[] strs = new String[] { "John", "Mary", "Bob" };
        System.out.println(Stream.of(strs).collect(Collectors.joining(", ")));
        System.out.println(String.join(", ", strs));
        System.out.println(Arrays.toString(strs));

        DayOfWeek[] days = { DayOfWeek.FRIDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY };
        System.out.println(Stream.of(days).map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(Arrays.toString(days));

        // These options are not the same as each item is printed on a new line:
        IntStream.of(ints).forEach(System.out::println);
        Stream.of(strs).forEach(System.out::println);
        Stream.of(days).forEach(System.out::println);
    }
}
