package com.interviewprep.BST;

public class Node {
    Node left;
    Node right;
    int key;

    public Node(int key) {
        this.key = key;
    }

    public Node(Node left, Node right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "["+key+"]";
    }
}
