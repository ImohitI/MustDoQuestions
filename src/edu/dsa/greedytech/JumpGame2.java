package edu.dsa.greedytech;

public class JumpGame2 {
    public static int jump(int[] nums) {
        // int res = 0;
        int res = 0, left = 0, right = 0;

        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left ; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            res++;
        }

        return res;
    }
}
