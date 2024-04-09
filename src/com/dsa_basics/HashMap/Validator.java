package com.dsa_basics.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class Validator {
    @Test
    public void testMyMap() {
        MyMap<String, String> myMap = new MyMap<>(3);
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");

        assertNotNull(myMap);
        assertEquals(4, myMap.size());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney", myMap.get("Australia"));
    }
}