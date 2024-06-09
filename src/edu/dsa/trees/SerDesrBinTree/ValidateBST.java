package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class ValidateBST {

    // Helper function for validating BST
    private static boolean validateBstHelper(TreeNode<Integer> root, long[] prev) {
        if (root == null)
            return true;

        if (!validateBstHelper(root.left, prev))
            return false;

        if (root.data <= prev[0])
            return false;

        prev[0] = root.data;
        
        return validateBstHelper(root.right, prev);
    }

    // Function to check if a given binary tree is a valid BST or not
    public static boolean validateBst(TreeNode<Integer> root) {
        long[] prev = {Long.MIN_VALUE};
        return validateBstHelper(root, prev);
    }

    // Driver code
    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(6), new TreeNode<Integer>(4)),
                Arrays.asList(new TreeNode<Integer>(6), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(4), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(8)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(5), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(8), new TreeNode<Integer>(2), new TreeNode<Integer>(4), null, new TreeNode<Integer>(9))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
            inputTrees.add(tree);
        }

        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tInput Tree:");
            printTree(tree.root);
            x++;
            System.out.println("\n\tValid BST: " + validateBst(tree.root));
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
