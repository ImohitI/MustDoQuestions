package edu.trees;

import java.util.*;

public class BinSearch {

    /*
     * O log n
     * O 1
     */
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Finding the mid using integer division
            int mid = low + (high - low) / 2;

            // Target value is present at the middle of the array
            if (nums[mid] == target) {
                return mid;
            }
            // Target value is present in the low subarray
            else if (target < nums[mid]) {
                high = mid - 1;
            }
            // Target value is present in the high subarray
            else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        // Target value is not present in the array
        return -1;
    }

    public static int binarySearchRecursive(List<Integer> nums, int start, int end, int target) {
        if (start > end)
            return -1;

        // Finding the mid using integer division
        int mid = start + (end - start) / 2;
        // Target value is present at the middle of the array
        if (nums.get(mid) == target)
            return mid;
        // If the target value is greater than the middle, ignore the first half
        else if (nums.get(mid) < target)
            return binarySearchRecursive(nums, mid + 1, end, target);
        // If the target value is less than the middle, ignore the second half
        return binarySearchRecursive(nums, start, mid - 1, target);
    }

    public static void main(String[] args) {
        testbinSearch();
        testbinSearchRec();
        testRotatedBinSearch();
    }

    private static void testbinSearch() {
        int[][] numsLists = {
                {},
                { 0, 1 },
                { 1, 2, 3 },
                { -1, 0, 3, 5, 9, 12 },
                { -100, -67, -55, -50, -49, -40, -33, -22, -10, -5 }
        };

        int[] targetList = { 12, 1, 3, 9, -22 };

        for (int i = 0; i < numsLists.length; i++) {
            int[] nums = numsLists[i];
            int target = targetList[i];
            int index = binarySearch(nums, target);
            System.out.println((i + 1) + ".\tArray to search: " + Arrays.toString(nums));
            System.out.println("\tTarget: " + target);
            if (index != -1) {
                System.out.println("\t" + target + " exists in the array at index " + index);
            } else {
                System.out.println("\t" + target + " does not exist in the array, so the return value is " + index);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static void testbinSearchRec() {
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(10, 20, 30, 40, 50, 60),
                Arrays.asList(12, 24, 35, 47, 58, 69, 72, 83, 94),
                Arrays.asList(5, 13, 28, 41, 56, 63, 77, 82, 99, 105),
                Arrays.asList(5, 7, 12, 17, 21, 28, 33, 37, 41, 48, 52, 57, 62, 68, 72));

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);
        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) +
                    "\n\ttarget " + targetList.get(i) +
                    " found at index "
                    + binarySearchRecursive(numList.get(i), 0, numList.get(i).size() - 1, targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int binarySearchRotated(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {
            // Finding the mid using integer division
            int mid = start + (end - start) / 2;
            // Target value is present at the middle of the array
            if (nums.get(mid) == target)
                return mid;
            // start to mid is sorted
            if (nums.get(start) <= nums.get(mid)) {
                if (nums.get(start) <= target && target < nums.get(mid)) {
                    end = mid - 1; // target is within the sorted first half of the array
                } else {
                    start = mid + 1; // target is not within the sorted first half, so let’s examine the unsorted
                                     // second half
                }
            }
            // mid to end is sorted
            else {
                if (nums.get(mid) < target && target <= nums.get(end))
                    start = mid + 1; // target is within the sorted second half of the array
                else
                    end = mid - 1; // target is not within the sorted second half, so let’s examine the unsorted
                                   // first half
            }
        }
        return -1;
    }

    public static int binarySearchRotRec(List<Integer> nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (nums.get(mid) == target)
            return mid;
        if (nums.get(start) <= nums.get(mid)) {
            if (nums.get(start) <= target && target < nums.get(mid)) {
                return binarySearchRotRec(nums, start, mid - 1, target);
            }
            return binarySearchRotRec(nums, mid + 1, end, target);
        } else {
            if (nums.get(mid) < target && target <= nums.get(end)) {
                return binarySearchRotRec(nums, mid + 1, end, target);
            }
            return binarySearchRotRec(nums, start, mid - 1, target);
        }
    }

    public static int binarySearchRotatedRec(List<Integer> nums, int target) {
        return binarySearchRotRec(nums, 0, nums.size() - 1, target);
    }

    public static void testRotatedBinSearch() {
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(5, 6, 7, 1, 2, 3, 4),
                Arrays.asList(40, 50, 60, 10, 20, 30),
                Arrays.asList(47, 58, 69, 72, 83, 94, 12, 24, 35),
                Arrays.asList(77, 82, 99, 105, 5, 13, 28, 41, 56, 63),
                Arrays.asList(48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41));

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);

        for (int i = 0; i < targetList.size(); i++) {
            if (i == 3)
                break;
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) +
                    "\n\ttarget " + targetList.get(i) +
                    " found at index " + binarySearchRotated(numList.get(i), targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}