package com.dsa_basics.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapUse {
    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        // inserting a new k V
        hashMap.putIfAbsent(0, 0);
        hashMap.putIfAbsent(2, 3);
        // insert new or update
        hashMap.put(1, 1);
        hashMap.put(1, 2);
        // get specific value
        int value = hashMap.get(2);
        System.out.println(value);
        // delete a key
        hashMap.remove(2);
        // check if key in map
        if (!hashMap.containsKey(2)) {
            System.out.println("2 is not present");
        }
        hashMap.size();
        // iterate hashmap
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println("(" + entry.getKey() + "," + entry.getValue() + ")");
        }

        hashMap.clear();
        if (hashMap.isEmpty()) {
            System.out.println("hashmap is empty now");
        }
    }

}
