package com.interviewprep.hmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class InDelGetRandom_O1 {
    private HashMap<Integer, Integer> numMap;
    private ArrayList<Integer> numList;
    private Random rand;

    public InDelGetRandom_O1() {
        numMap = new HashMap<>();
        numList = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (numMap.containsKey(val)) {
            return false;
        }
        numMap.put(val, numList.size());
        numList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numMap.containsKey(val)) {
            return false;
        }
        int index = numMap.get(val);
        int lastElement = numList.get(numList.size() - 1);
        numList.set(index, lastElement);
        numMap.put(lastElement, index);
        numList.remove(numList.size() - 1);
        numMap.remove(val);
        return true;
    }

    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}
