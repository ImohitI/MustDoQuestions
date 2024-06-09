package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class BinTreeInoPreo {
    public static TreeNode<Integer> buildTreeHelper(int[] pOrder, int[] iOrder, int left, int right, HashMap<Integer, Integer> mapping, int[] pIndex) {
    
        // If left > right, it means there are no more nodes left to construct
        if (left > right) {
            System.out.println("return null left > right ");

            return null;
        }

        // Pick current node from preorder list
        // using pIndex and increment pIndex
        int curr = pOrder[pIndex[0]];
        int currI = pIndex[0];
        pIndex[0]++;

        TreeNode<Integer> root = new TreeNode<Integer>(curr);
        System.out.println("curr "+curr+" currIndex "+currI);
        // If this node has no children then return
        if (left == right) {
            System.out.println("return root ");
            return root;
        }

        // Else find the index of this node in inorder list
        int inIndex = mapping.get(curr);

        // Recursively build the left subtree by calling buildTreeHelper
        // on the elements in the inorder list from left to inIndex - 1
        System.out.println("curr "+curr+" pIndex "+pIndex[0]+" left "+ left +" right "+ (inIndex - 1));

        root.left = buildTreeHelper(pOrder, iOrder, left, inIndex - 1, mapping, pIndex);

        // Recursively build the right subtree by calling buildTreeHelper
        // on the elements in the inorder list from inIndex + 1 to right
        System.out.println("curr "+curr+" pIndex "+pIndex[0]+" left "+ (inIndex + 1)+" right "+ right);

        root.right = buildTreeHelper(pOrder, iOrder, inIndex + 1, right, mapping, pIndex);

        return root;
    }

    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {
        // Using HashMap to store the inorder list to reduce time complexity
        // of search to O(1)
        HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();

        // Iterate through the inorder list and map each value to its index
        for (int i = 0; i < iOrder.length; i++) {
            mapping.put(iOrder[i], i);
        }

        // Explicitly using an array to pass pIndex by reference because
        // in Java, primitive types are passed by value
        int[] pIndex = {0};

        return buildTreeHelper(pOrder, iOrder, 0, pOrder.length - 1, mapping, pIndex);
    }

    // Driver code
    public static void main(String[] args) {
        int[][] pOrder = {
            {10, 20, 40, 50, 30, 60},
            {3, 9, 20, 15, 7},
            {-1},
            {1, 2, 4, 5, 3, 6},
            {1, 2, 4, 7, 3},
            {1, 2, 4, 8, 9, 5, 3, 6, 7}
        };

        int[][] iOrder = {
            {40, 20, 50, 10, 60, 30},
            {9, 3, 15, 20, 7},
            {-1},
            {4, 2, 5, 1, 6, 3},
            {4, 2, 7, 1, 3},
            {8, 4, 9, 2, 5, 1, 6, 3, 7}
        };

        int index = 0;
        for (int i = 0; i < pOrder.length; i++) {
            System.out.println((index + 1) + ".\tPre order: " + Arrays.toString(pOrder[index]));
            System.out.println("\tIn order: " + Arrays.toString(iOrder[index]));
            TreeNode<Integer> tree = buildTree(pOrder[index], iOrder[index]);
            index++;
            System.out.println("\n\tBinary tree:");
            printTree(tree);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            break;
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