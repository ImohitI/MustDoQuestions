package edu.trees.diameter;

import java.util.*;

class Pair {
    int diameter;
    int height;

    public Pair(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

/*
 * Space complexity is O n, because every node is visited once
 * Time complexity O n , recursive stack can grow up to O n
 */
public class Solution {

    // Helper function to calculate diameter and height of a binary tree
    public static Pair diameterHelper(TreeNode<Integer> node) {
        if (node == null) {
            // If the node is null, return Pair with diameter and height both as 0
            return new Pair(0, 0);
        } else {
            // Recursively calculate the Pair for left and right subtrees
            Pair lh = diameterHelper(node.left);
            Pair rh = diameterHelper(node.right);

            // Calculate height as the maximum height of left and right subtrees + 1
            int height = Math.max(lh.height, rh.height) + 1;

            // Calculate diameter as the maximum of left diameter, right diameter, and the
            // sum of left and right heights
            int diameter = Math.max(lh.diameter, Math.max(rh.diameter, lh.height + rh.height));

            // Return the Pair for the current subtree
            return new Pair(diameter, height);
        }
    }

    // Function to find the diameter of a binary tree
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        if (root == null)
            // If the root is null, return 0 as the diameter
            return 0;

        // Calculate the Pair for the entire tree using the helper function
        Pair pair = diameterHelper(root);

        // Return the diameter from the Pair
        return pair.diameter;
    }

    // Driver code
    public static void main(String args[]) {
        List<List<TreeNode<Integer>>> lists = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(2), new TreeNode<Integer>(1), new TreeNode<Integer>(4),
                        new TreeNode<Integer>(3), new TreeNode<Integer>(5), new TreeNode<Integer>(6),
                        new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3),
                        new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6),
                        new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(45), new TreeNode<Integer>(32), new TreeNode<Integer>(23),
                        new TreeNode<Integer>(21), new TreeNode<Integer>(19), new TreeNode<Integer>(18),
                        new TreeNode<Integer>(1)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(4),
                        new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(6),
                        new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1),
                        new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12)));

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ".\tBinary Tree");
            printTree(t.root);
            System.out.println(
                    "\n\tDiameter of Tree: " + diameterOfBinaryTree(t.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void printTree(TreeNode<Integer> root) {
        printTree(root, "", false);
    }

    private static void printTree(TreeNode<Integer> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}
