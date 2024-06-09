package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class InvertBinaryTree {
        // Function to mirror binary tree
        public static TreeNode<Integer> invertTree(TreeNode<Integer> root) {
            if (root == null) {
               return null;
            }
            if(root.left!=null){
               invertTree(root.left);
            }
            if(root.right!=null){
              invertTree(root.right);
            }
        
            TreeNode<Integer> temp = root.left;
            root.left = root.right;
            root.right = temp;
    
            return root;
        }

           // Driver code
    public static void main(String args[]){

        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(125), new TreeNode<Integer>(350)),
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(110), new TreeNode<Integer>(125), new TreeNode<Integer>(350)),
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(90), new TreeNode<Integer>(350)),
            Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(300), new TreeNode<Integer>(400), new TreeNode<Integer>(500)),
            Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(125), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25)),
            Arrays.asList(new TreeNode<Integer>(100)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4)),
            Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), null, null, new TreeNode<Integer>(5)),
            Arrays.asList()
        );
   
        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }

        int i = 0;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println((i + 1) + ".\tBinary Tree");
            printTree(tree.root);
            i++;
            invertTree(tree.root);
            System.out.println("\n\tMirrored binary tree: ");
            printTree(tree.root);
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
