package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class MaxDepth {
    
    public static int findMaxDepth(TreeNode<Integer> root) {

        // Check if the root is None
        if (root == null)
            return 0;

        // Initialize a nodeStack with the root node and its depth
        Stack<TreeNode<Integer>> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);

        // Initialize max_depth to 0
        int maxDepth = 0;

        // Loop while the nodeStack is not empty
        while (!nodeStack.isEmpty()) {

            // Pop the top item from the nodeStack
            TreeNode<Integer> node = nodeStack.pop();
            int depth = depthStack.pop();

            // If the node has a left child, add it to the nodeStack with its depth
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }

            // If the node has a right child, add it to the nodeStack with its depth
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }

            // If the node is a leaf node, update max_depth if necessary
            if (node.left == null && node.right == null) {
                maxDepth = Math.max(maxDepth, depth);
            }
        }
        
        // Return the maximum depth
        return maxDepth;
    }

    // Driver code
    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> lists =Arrays.asList(
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), null, null, new TreeNode<Integer>(4), new TreeNode<Integer>(5)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), null, new TreeNode<Integer>(8)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), new TreeNode<Integer>(4))
    );

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ". Binary Tree");
            printTree(t.root);
            System.out.println("\n   Maximum Depth: " + findMaxDepth(t.root));
            System.out.println(new String(new char[100]).replace("\0", "-"));
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
