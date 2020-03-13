package com.basics;

import java.util.Comparator;

public class ReverseOrdering implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
