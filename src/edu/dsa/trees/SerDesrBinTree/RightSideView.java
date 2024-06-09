package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class RightSideView {

    private static void dfs(TreeNode<Integer> node, int level, List<Integer> rside) {
        if (level == rside.size()) {
            rside.add(node.data);
        }

        List<TreeNode<Integer>> children = new ArrayList<TreeNode<Integer>>();
        children.add(node.right);
        children.add(node.left);

        for (TreeNode<Integer> child : children) {
            if (child != null) {
                dfs(child, level + 1, rside);
            }
        }
    }

    // Function to get the right side view of a binary tree
    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> rside = new ArrayList<Integer>();
        dfs(root, 0, rside);

        return rside;
    }

    // Driver code
    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> input = Arrays.asList(
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), null, null, new TreeNode<Integer>(4), new TreeNode<Integer>(5)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), null, new TreeNode<Integer>(8)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), new TreeNode<>(4))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : input) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
            inputTrees.add(tree);
        }

        int y = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(y++ + ". Binary tree:");
            printTree(tree.root);
            System.out.print("\n   Right side view: [");
            List<Integer> result = rightSideView(tree.root);
            // Print the right side view
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
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