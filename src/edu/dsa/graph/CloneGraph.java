package edu.dsa.graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

     public static Node cloneHelper(Node root, Map<Node, Node> nodesCompleted) {
        // If the root node is None, return None
        if (root == null) {
            return null;
        }
        // Create a new Node with the same data as the root node
        Node clonedNode = new Node(root.data);
        // Add the root node and its clone to the nodesCompleted hash map
        nodesCompleted.put(root, clonedNode);
        // Iterate through the neighbors of the root node
        for (Node p : root.neighbors) {
            // Retrieve the value of key p in nodes_completed hash map.
            // If it exists, assign the corresponding cloned node to x.
            // This checks if neighbor node p has already been cloned.
            Node x = nodesCompleted.get(p);
            // If the neighbor is not cloned yet, recursively clone it
            if (x == null) {
                clonedNode.neighbors.add(cloneHelper(p, nodesCompleted));
            }
            // If the neighbor is already cloned, add the cloned neighbor to the new
            // node's neighbors 
            else {
                clonedNode.neighbors.add(x);
            }
        }
        return clonedNode;
    }

    public static Node clone(Node root) {
        Map<Node, Node> nodesCompleted = new HashMap<Node, Node>();
        return cloneHelper(root, nodesCompleted);
    }

    
    public static void main(String[] args) {
        int[][][] data = {
                {{2, 3}, {1, 3}, {1, 2}},
                {{2, 4}, {1, 3}, {2, 4}, {1, 3}},
                {{2, 5}, {1, 3}, {2, 4}, {3, 5}, {1, 4}},
                {{2}, {1}},
                {{2, 6}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {1, 5}},
                {{}}
        };

        for (int i = 0; i < data.length; i++) {
            Node node1 = GraphUtility.createGraph(data[i]);
            System.out.println((i + 1) + ".\t Original Graph: " + GraphUtility.create2DList(node1) + "\n");
            GraphUtility.printGraph(node1);
            System.out.println();
            Node clonedRoot = clone(node1);
            System.out.println("\t Cloned Graph: " + GraphUtility.create2DList(clonedRoot) + "\n");
            GraphUtility.printGraph(node1);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }   

}
