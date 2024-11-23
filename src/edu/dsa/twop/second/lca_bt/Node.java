package edu.dsa.twop.second.lca_bt;

public class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    Node (int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
