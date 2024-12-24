package edu.dsa.backtracking;

import java.util.Arrays;

public class MatchSticksSq {

    public boolean makesquare(int[] matchsticks) {
        int length = 0;

        for (int i : matchsticks) {
            length += i;
        }
        length = length/4;

        int[] sides = new int[] {0 , 0 , 0 , 0};
        Arrays.sort(matchsticks);//sorting in ascending order
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = temp;
        }

        return backtrack(matchsticks, sides, 0, length);
    }

    public boolean backtrack(int[] matchsticks, int[] sides, int i, int length){
        if (i == matchsticks.length) {
            return true;
        }
        
        for (int j = 0 ; j < 4; j++) {
            if ((sides[j] + matchsticks[i]) <= length) {
                sides[j] += matchsticks[i];
                if (backtrack(matchsticks, sides, i + 1, length)) {
                    return true;
                }
                sides[j] -= matchsticks[i];
            }
        }
        return false;
    }
}
