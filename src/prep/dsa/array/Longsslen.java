package prep.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class Longsslen {
    public static void main(String[] args) {
        int[] arr = {100, 4, 100, 4, 200, 1, 3, 2};

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        int best = 0;
        for (int n : s) {
            // if n is the start of a sequence
            if (!s.contains(n - 1)) {
                int m = n + 1;
                while (s.contains(m)) m++;
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
}
