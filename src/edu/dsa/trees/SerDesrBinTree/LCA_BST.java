package edu.dsa.trees.SerDesrBinTree;
import java.util.*;

public class LCA_BST {

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2) {
        TreeNode<Integer> current = root;
        
        while (current != null) {
            if (node1.data > current.data && node2.data > current.data) {
                current = current.right;
            } else if (node1.data < current.data && node2.data < current.data) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }

    // Driver code
    public static void main(String args[]) {
        List<List<TreeNode<Integer>>> inputTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(6), new TreeNode<Integer>(2), new TreeNode<Integer>(8), new TreeNode<Integer>(0), new TreeNode<Integer>(4), new TreeNode<Integer>(7), new TreeNode<Integer>(9), null, null, new TreeNode<Integer>(3), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(6), new TreeNode<Integer>(2), new TreeNode<Integer>(8), new TreeNode<Integer>(0), new TreeNode<Integer>(4), new TreeNode<Integer>(7), new TreeNode<Integer>(9), null, null, new TreeNode<Integer>(3), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(2), new TreeNode<Integer>(1)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(9), new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(7), new TreeNode<Integer>(10), null, null, null, null, new TreeNode<Integer>(6), new TreeNode<Integer>(8)),
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(88), new TreeNode<Integer>(130))
        );

        int[][] inputNodes = {
                {2, 8},
                {2, 4},
                {2, 1},
                {6, 10},
                {88, 130}
        };

        for (int i = 0; i < inputTrees.size(); i++) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(inputTrees.get(i));
            System.out.println((i + 1) + ".\tBinary search tree:");
            printTree(tree.root);
            System.out.println("\n\tnode1 = " + inputNodes[i][0]);
            System.out.println("\tnode2 = " + inputNodes[i][1]);
            TreeNode<Integer> lca = lowestCommonAncestor(tree.root, tree.find(inputNodes[i][0]), tree.find(inputNodes[i][1]));
            System.out.println("\n\tLowest common ancestor: " + lca.data);
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
