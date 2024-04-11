package com.interviewprep.hmap;

public class JewelsAndStone {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        int[] s = new int[128];
        for (char c : jewels.toCharArray()) {
            s[c] = 1;
        }
        for (char c : stones.toCharArray()) {
            ans += s[c];
        }

        return ans;

    }

}
