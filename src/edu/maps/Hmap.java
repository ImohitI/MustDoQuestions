package edu.maps;

import java.util.ArrayList;

class Bucket {
    private ArrayList<Pair<Integer, Integer>> bucket;

    public Bucket() {
        // Constructor to initialize an empty list to store key-value pairs
        bucket = new ArrayList<>();
    }

    // Method to get the value corresponding to the given key
    public int get(int key) {
        // Iterate through each key-value pair in the bucket
        for (Pair<Integer, Integer> kv : bucket) {
            // If the key matches the provided key, return the corresponding value
            if (kv.getKey() == key) {
                return kv.getValue();
            }
        }
        // If the key is not found, return -1
        return -1;
    }

    // Method to update the value for the given key
    public void update(int key, int value) {
        // Flag to indicate whether the key is found in the bucket
        boolean found = false;
        // Iterate through each key-value pair in the bucket
        for (int i = 0; i < bucket.size(); i++) {
            Pair<Integer, Integer> kv = bucket.get(i);
            // If the key matches the key of the current key-value pair
            if (key == kv.getKey()) {
                // Update the value of the key-value pair
                bucket.set(i, new Pair<>(key, value));
                // Set the flag to true, indicating that the key is found
                found = true;
                break;
            }
        }
        // If the key is not found in the bucket, add it along with its value
        if (!found) {
            bucket.add(new Pair<>(key, value));
        }
    }

    // Method to remove the key-value pair with the given key
    public void remove(int key) {
        // Iterate through each key-value pair in the bucket
        for (int i = 0; i < bucket.size(); i++) {
            Pair<Integer, Integer> kv = bucket.get(i);
            // If the key matches the key of the current key-value pair
            if (key == kv.getKey()) {
                // Delete the key-value pair from the bucket
                bucket.remove(i);
                // Exit the loop as the key has been removed
                break;
            }
        }
    }
}

// Define Pair class to store key-value pairs
class Pair<K, V> {
    private K key;
    private V value;

    // Constructor to initialize key-value pair
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter methods for key and value
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class Hmap {
    // Method to calculate hash value for a given key
    public static int calculateHash(int key) {
        int keyBase = 2069;
        return key % keyBase;
    }

    public static void main(String[] args) {
        // Create an array of Bucket objects
        Bucket[] buckets = new Bucket[2069];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        // Example usage:
        int[][] keyValuePair = { { 1, 1000 }, { 2070, 2000 }, { 2068, 3000 } };
        int i = 1;
        for (int[] pair : keyValuePair) {
            int key = pair[0];
            int value = pair[1];
            int hashKey = calculateHash(key);
            System.out.println(
                    i + ".\tInserting key-value pair: Key = " + key + ", Value = " + value + ", HashKey = " + hashKey);
            buckets[hashKey].update(key, value);

            // Retrieving values
            System.out.println("\tRetrieving value for key " + key + ": " + buckets[hashKey].get(key) + "\n");
            i++;
        }

        // Removing a key
        int keyToRemove = keyValuePair[keyValuePair.length - 1][0];
        System.out.println(i + ".\tRemoving key " + keyToRemove);
        buckets[calculateHash(keyToRemove)].remove(keyToRemove);
        System.out.println("\tValue for key " + keyToRemove + " after removal: "
                + buckets[calculateHash(keyToRemove)].get(keyToRemove)); // Output: -1 (removed)
    }
}