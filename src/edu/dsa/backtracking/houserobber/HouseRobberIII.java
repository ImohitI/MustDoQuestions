package edu.dsa.backtracking.houserobber;

import java.util.*;

public class HouseRobberIII {
    public static int[] heist(TreeNode<Integer> root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftPair = heist(root.left);
        int[] rightPair = heist(root.right);

        int withRoot = root.data + leftPair[1] + rightPair[1];
        int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

        return new int[]{withRoot, withoutRoot};
    }

    public static int rob(TreeNode<Integer> root) {
        int[] result = heist(root);
        return Math.max(result[0], result[1]);
    }

    public static void main(String[] args) {
       List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList( 
         Arrays.asList( new TreeNode<Integer>(10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
         Arrays.asList( new TreeNode<Integer>(7), new TreeNode<Integer>(9), new TreeNode<Integer>(10), new TreeNode<Integer>(15), new TreeNode<Integer>(20)),
         Arrays.asList( new TreeNode<Integer>(8), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
         Arrays.asList( new TreeNode<Integer>(7), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
         Arrays.asList( new TreeNode<Integer>(9), new TreeNode<Integer>(5), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
         Arrays.asList( new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12))
       );

        

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }


        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tInput Tree:");
            //Print.displayTree(tree.root);
            x++;
            System.out.println("\n\tMaximum amount we can rob without getting caught: " + rob(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}