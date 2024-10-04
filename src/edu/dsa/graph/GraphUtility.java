package edu.dsa.graph;
import java.util.*;

public class GraphUtility {
    public static Node createGraph(int[][] data) {
        if (data.length == 0) {
            return new Node(1);
        }

        Node[] nodes = new Node[data.length];
        for (int i = 0; i<data.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < data.length; i++) {
            for (int neighbor : data[i]) {
                nodes[i].neighbors.add(nodes[neighbor-1]);
            }
        }
        return nodes[0];
    }

    public static List<List<Integer>> create2DList(Node root) {
        //initialize a queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //initialize a HashMap to keep track of visited nodes
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        //initialize a 2D List to store the graph
        List<List<Integer>> graph = new ArrayList<>();
        //initialize a hashmap to store index of each node
        HashMap<Node, Integer> nodeIndex = new HashMap<Node, Integer>();
       // Perform breadth-first traversal
       while (!queue.isEmpty()) {
            // Get the next node in the queue
            Node node = queue.remove();
            // Create a new List to store the neighbors of the current node
            List<Integer> neighbors = new ArrayList<Integer>();
            // Iterate through the neighbors of the current node
            for (Node neighbor : node.neighbors) {
                // Append the neighbor's value to the List of neighbors
                neighbors.add(visited.getOrDefault(neighbor, neighbor).data);
                // Add the neighbor to the queue if it hasn't been visited yet
                if (!visited.containsKey(neighbor) && !queue.contains(neighbor)) {
                    visited.put(neighbor, neighbor);
                    queue.add(neighbor);
                }
            }
            // Sort the List of neighbors
            Collections.sort(neighbors);
            // Append the current node's value and its neighbors to the 2D List
            if (!nodeIndex.containsKey(node)) {
                int index = graph.size();
                nodeIndex.put(node, index);
                List<Integer> sublist = new ArrayList<Integer>();
                sublist.add(node.data);
                sublist.addAll(neighbors);
                graph.add(sublist);
            }
        }
        // Sort the graph by node value
        Collections.sort(graph, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> sublist : graph) {
            List<Integer> sub = new ArrayList<>(sublist.subList(1, sublist.size()));
            result.add(sub);
        }
        return result;  
    }

    public static void printGraphRec(Node root, Set<Node> visitedNodes) {
        if (root == null || visitedNodes.contains(root)) {
            return;
        }

        visitedNodes.add(root);
        System.out.print("\t" + root.data + ": {");
        for (Node n : root.neighbors) {
            System.out.print(n.data + " ");
        }
        System.out.println("}");

        for (Node n : root.neighbors) {
            printGraphRec(n, visitedNodes);
        }
    }

    public static void printGraph(Node root) {
        Set<Node> visitedNodes = new HashSet<>();
        printGraphRec(root, visitedNodes);
    }
}
