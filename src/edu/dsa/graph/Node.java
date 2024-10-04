package edu.dsa.graph;

import java.util.*;

public class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }
}
