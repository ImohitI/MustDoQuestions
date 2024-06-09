package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class LCA_BT {
    private TreeNode<Integer> lca;

    public LCA_BT() {
        this.lca = null;
    }

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        lowestCommonAncestorRec(root, p, q);
        return lca;
    }

    // helper function to find the lowest common ancestor recursively
    private boolean lowestCommonAncestorRec(TreeNode<Integer> currentNode, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (currentNode == null)
            return false;

        boolean left = false, right = false, mid = false;

        if (p == currentNode || q == currentNode)
            mid = true;

        left = lowestCommonAncestorRec(currentNode.left, p, q);

        if (lca == null)
            right = lowestCommonAncestorRec(currentNode.right, p, q);

        if (boolToInt(mid) + boolToInt(left) + boolToInt(right) >= 2)
            lca = currentNode;

        return mid || left || right;
    }

    private int boolToInt(boolean val) {
        return (val) ? 1 : 0;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> inputTrees = Arrays.asList(
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25), new TreeNode<Integer>(350)),
            Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25)),
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
            Arrays.asList(new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(75), new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(350))
        );

        int[][] inputNodes = {
            {25, 75},
            {50, 350},
            {100, 200},
            {50, 25},
            {350, 200}
        };

        for (int i = 0; i < inputTrees.size(); i++) {
            LCA_BT solution = new LCA_BT();
            BinaryTree<Integer> tree = new BinaryTree<>(inputTrees.get(i));
            System.out.println((i + 1) + ".\tBinary tree:");
            printTree(tree.root);
            System.out.println("\tp = " + inputNodes[i][0]);
            System.out.println("\tq = " + inputNodes[i][1]);
            TreeNode<Integer> lca = solution.lowestCommonAncestor(tree.root, tree.find1(inputNodes[i][0]), tree.find1(inputNodes[i][1]));
            System.out.println("\n\tLowest common ancestor: " + lca.data);
            System.out.println("----------------------------------------------------------");
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
