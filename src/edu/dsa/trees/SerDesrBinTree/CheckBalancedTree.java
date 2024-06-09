package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class CheckBalancedTree {
    public static boolean isBalanced(TreeNode<Integer> root) {
        return isBalancedHelper(root) != -1;
    }
  
    public static int isBalancedHelper(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
  
        int left = isBalancedHelper(node.left);
  
        if (left == -1) {
            return -1;
        }
  
        int right = isBalancedHelper(node.right);
  
        if (right == -1) {
            return -1;
        }
  
        if (Math.abs(left - right) > 1) {
            return -1;
        }
  
        return Math.max(left, right) + 1;
    }
   // Driver code
  public static void main(String args[]) {
    List<List<TreeNode<Integer>>> lists =Arrays.asList(
            Arrays.asList(new TreeNode<Integer>(6), new TreeNode<Integer>(2), new TreeNode<Integer>(8), new TreeNode<Integer>(0), new TreeNode<Integer>(4), new TreeNode<Integer>(7), new TreeNode<Integer>(9), null, null, new TreeNode<Integer>(3), new TreeNode<Integer>(5)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), null, new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8), null, new TreeNode<Integer>(9), null, new TreeNode<Integer>(10)),
            Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(9), new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(7), new TreeNode<Integer>(10), null, null, null, null, new TreeNode<Integer>(6), new TreeNode<Integer>(8)),
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(88), null, new TreeNode<Integer>(10)),
            Arrays.asList( new TreeNode<Integer>(1), null, new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4), null, new TreeNode<Integer>(5), null, new TreeNode<Integer>(6))
    );

    for (int i = 0; i < lists.size(); i++) {
      BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
      System.out.println((i + 1) + ".\tBinary Tree");
      printTree(t.root);
      System.out.println(
          "\n\tResult: " + isBalanced(t.root));
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
