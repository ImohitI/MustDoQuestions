package edu.dsa.fastslowp;

import java.util.Arrays;

public class Test {
    private static boolean isHappyNumber(int num) {

        int slow = num;
        int fast = addSquareOfDigits(num);
        while (fast != 1 && fast != slow) {
            slow = addSquareOfDigits(slow);
            fast = addSquareOfDigits(addSquareOfDigits(fast));
        }
        return fast == 1;
    }

    private static int addSquareOfDigits(int num) {

        int sq = 0;
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            sq += (Math.pow(digit, 2));
        }
        return sq;
    }

    private static boolean circularArrayLoop(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextStep(slow, nums[slow], size);

                if (isNotCycle(nums, forward, slow)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], size);

                if (isNotCycle(nums, forward, slow)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], size);

                if (isNotCycle(nums, forward, slow)) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
            result += size;
        }
        return result;
    }

    public static boolean isNotCycle(int[] nums, boolean prevDir, int pointer) {

        boolean currDirection = nums[pointer] >= 0;

        if (prevDir != currDirection || Math.abs(nums[pointer] % nums.length) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // testHappy();
        testCircular();
    }

    public static void testHappy() {
        int a[] = { 1, 5, 19, 25, 7 };
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            String output = isHappyNumber(a[i]) ? "True" : "False";

            System.out.println("\n\tIs it a happy number? " + output);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void testCircular() {
        int[][] input = {
                { -2, -3, -9 },
                { -5, -4, -3, -2, -1 },
                { -1, -2, -3, -4, -5 },
                { 2, 1, -1, -2 },
                { -1, -2, -3, -4, -5, 6 },
                { 1, 2, -3, 3, 4, 7, 1 },
                { 2, 2, 2, 7, 2, -1, 2, -1, -1 }
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
