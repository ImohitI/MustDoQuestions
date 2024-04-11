package com.interviewprep.hmap;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        System.out.println(isomorhicSol1(s, t));
        System.out.println(isomorhicSol2(s, t));

    }

    public static boolean isomorhicSol1(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, ++count);
                sb.append(count);
            } else {
                sb.append(sMap.get(c));
            }
        }
        sMap.clear();
        count = 0;
        StringBuilder tb = new StringBuilder();
        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, ++count);
                tb.append(count);
            } else {
                tb.append(sMap.get(c));
            }
        }
        System.out.println(sb);
        System.out.println(tb);
        if (sb.toString().equals(tb.toString())) {
            System.out.println("Is isomorhic");
            return true;
        } else {
            System.out.println("not isomorphic");
        }

        return false;
    }

    public static boolean isomorhicSol2(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);

            if ((mapST.containsKey(c1) && mapST.get(c1) != c2) || (mapTS.containsKey(c2) && mapTS.get(c2) != c1)) {
                return false;
            }

            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }
        return true;
    }
}