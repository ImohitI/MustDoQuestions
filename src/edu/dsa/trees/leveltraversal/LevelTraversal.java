package edu.dsa.trees.leveltraversal;

import java.util.*;

public class LevelTraversal {

    public static String levelOrderTraversal(TreeNode<Integer> root) {
 
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return "None";
        } else {
            ArrayList<Queue<TreeNode<Integer>>> queues = new ArrayList<Queue<TreeNode<Integer>>>();
            queues.add(new ArrayDeque<TreeNode<Integer>>());
            queues.add(new ArrayDeque<TreeNode<Integer>>());

            Queue<TreeNode<Integer>> currentQueue = queues.get(0);
            Queue<TreeNode<Integer>> nextQueue = queues.get(1);

            currentQueue.add(root);
            int levelNumber = 0;

            while (!currentQueue.isEmpty()) {

                TreeNode<Integer> temp = currentQueue.poll();
                result.append(String.valueOf(temp.data));
                
                if (temp.left != null) {
                    nextQueue.add(temp.left);
                }
                if (temp.right != null) {
                    nextQueue.add(temp.right);
                }
                if (currentQueue.isEmpty()) {
                    ++levelNumber;
                    if (!nextQueue.isEmpty()) {
                        result = result.append(" : ");
                    }
                    currentQueue = queues.get(levelNumber % 2);
                    nextQueue = queues.get((levelNumber + 1) % 2);
    
                } else {
                    result = result.append(", ");
                }
            }
        }
        return result.toString();
    }
    

	public static void main(String[] argv) {
		 List<TreeNode<Integer>> testCasesRoots = new ArrayList<>();

        List<TreeNode<Integer>> input1 = Arrays.asList(
                new TreeNode<>(100),
                new TreeNode<>(50),
                new TreeNode<>(200),
                new TreeNode<>(25),
                new TreeNode<>(75),
                new TreeNode<>(350)
        );
        BinaryTree<Integer> tree1 = new BinaryTree<>(input1);
        testCasesRoots.add(tree1.root);

        List<TreeNode<Integer>> input2 = Arrays.asList(
                new TreeNode<>(25),
                new TreeNode<>(50),
                null,
                new TreeNode<>(100),
                new TreeNode<>(200),
                new TreeNode<>(350)
        );
        BinaryTree<Integer> tree2 = new BinaryTree<>(input2);
        testCasesRoots.add(tree2.root);

        List<TreeNode<Integer>> input3 = Arrays.asList(
                new TreeNode<>(350),
                null,
                new TreeNode<>(100),
                null,
                new TreeNode<>(50),
                new TreeNode<>(25)
        );
        BinaryTree<Integer> tree3 = new BinaryTree<>(input3);
        testCasesRoots.add(tree3.root);

        BinaryTree<Integer> tree4 = new BinaryTree<>(Arrays.asList(new TreeNode<>(100)));
        testCasesRoots.add(tree4.root);

        testCasesRoots.add(null);

        for (int i = 0; i < testCasesRoots.size(); i++) {
            if (i > 0) {
                System.out.println("\n");
            }
            System.out.println(i + 1 + ".\tBinary Tree");
            printTree(testCasesRoots.get(i));
            System.out.print("\n\tLevel order traversal: ");
            System.out.println(levelOrderTraversal(testCasesRoots.get(i)) + "\n");
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