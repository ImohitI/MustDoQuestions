package edu.dsa.twop.second.lca_bt;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    private Node createBinaryTree(List<Integer> nodes) {
        if (nodes.isEmpty() || nodes.get(0) == 0) {
            return null;
        }

        Node root = new Node(nodes.get(0));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < nodes.size()) {
            Node curr = q.poll();
            if (i < nodes.size() && nodes.get(i) != 0) {
                curr.left = new Node(nodes.get(i));
                curr.left.parent = curr;
                q.offer(curr.left);
            }
            i++;
            if (i < nodes.size() && nodes.get(i) != 0) {
                curr.right = new Node(nodes.get(i));
                curr.right.parent = curr;
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    public BinaryTree(List<Integer> nodes) {
        this.root = createBinaryTree(nodes);
    }

    public Node find(Node root, int value) {
        if (root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == value) {
                return curr;
            }
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return null;
    }

    public Node getRoot() {
        return root;
    }
}
