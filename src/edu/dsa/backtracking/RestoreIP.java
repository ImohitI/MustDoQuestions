package edu.dsa.backtracking;

import java.util.*;

public class RestoreIP {
    
    public static List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;

        backtrack(0, 0, "", s, res);

        return res;
    }

    public static void backtrack(int i, int dots, String curIP, String s, List<String> res) {

       if (dots == 4 && i == s.length()) {
            res.add(curIP.substring(0, curIP.length() - 1));
            return;
       } 
       if (dots > 4) return;

       for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            if (i != j && s.charAt(i) == '0') continue;
            if (Integer.parseInt(s.substring(i, j + 1)) < 256) {
                backtrack(j + 1, dots + 1, curIP + s.substring(i, j + 1) + ".", s, res);
            }
       }
    }

    public static void main(String[] args) {

        String[] inputs = {
            "0000",
            "25525511135",
            "12121212",
            "113242124",
            "199219239",
            "121212",
            "25525511335"
        };
        for (int i = 0; i < inputs.length; i++) {

            List < String > result = restoreIpAddresses(inputs[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput Addresses: " + inputs[i]);
            System.out.println("\n\tPossible valid IP Addresses are: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }    
}
