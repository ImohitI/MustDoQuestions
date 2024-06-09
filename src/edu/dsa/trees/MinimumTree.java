package edu.dsa.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumTree {
       // Function to construct an adjacency list representation of a graph
    public static List<Set<Integer>> constructAdjacencyList(int n, int[][] edges) {
        // Initialize an empty adjacency list with 'n' empty sets
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        // Iterate through the 'edges' list and add edges to the adjacency list
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        // Return the constructed adjacency list
        return adj;
    }

    // Function to find the minimum height trees in a graph
    public static List<Integer> minHeightTrees(int n, int[][] edges) {
        // If there are 1 or 2 nodes, return them as the minimum height trees
        if (n <= 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        // Construct the adjacency list for the graph
        List<Set<Integer>> adj = constructAdjacencyList(n, edges);

        // Initialize a list to store the leaves of the graph
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Initialize a variable to keep track of remaining nodes
        int remNodes = n;

        // Iterate until there are only 1 or 2 nodes left
        while (remNodes > 2) {
            // Decrement the count of remaining nodes by the number of leaves
            remNodes -= leaves.size();

            // Initialize a temporary list to store new leaves
            List<Integer> tempLeaves = new ArrayList<>();

            // Iterate through the current leaves
            while (leaves.size() > 0) {
                int leaf = leaves.remove(leaves.size() - 1);

                // Get its neighbor
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(leaf).remove(neighbor);

                // Remove the link from the neighbor back to the leaf
                adj.get(neighbor).remove(leaf);

                // If the neighbor becomes a new leaf, add it to 'tempLeaves'
                if (adj.get(neighbor).size() == 1) {
                    tempLeaves.add(neighbor);
                }
            }

            // Update 'leaves' with the new leaves found in this iteration
            leaves = tempLeaves;
        }

        // Return the remaining nodes as the minimum height trees
        return leaves;
    }

    // Driver code
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 6};
        int[][][] input2 = {{}, {{0, 1}}, {{0, 1}, {1, 2}}, {{1, 0}, {1, 2}, {2, 3}}, {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {4, 5}}};

        for (int i = 0; i < input1.length; i++) {
            System.out.println((i + 1) + ".\tn: " + input1[i] +
                                         "\n\tedges: " + Print.twoDArrayToString(input2[i]) +
                                         "\n\n\tRoot nodes that minimize the height: " + minHeightTrees(input1[i], input2[i]));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}

class Print {
    // Define a function to convert intervals to a string
    public static String twoDArrayToString(int[][] arr) {
        if (arr.length == 0){
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            result.append("[");
            for (int j = 0; j < arr[i].length; j++) {
                result.append(arr[i][j]);
                // Add a comma and space if it's not the last element in the row
                if (j < arr[i].length - 1) {
                    result.append(", ");
                }
            }
            result.append("]");
            // Add a comma and space if it's not the last row
            if (i < arr.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}