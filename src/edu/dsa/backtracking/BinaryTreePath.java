package edu.dsa.backtracking;

import java.util.*;

import edu.dsa.backtracking.houserobber.BinaryTree;

import edu.dsa.backtracking.houserobber.TreeNode;

class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode<Integer> root) {
        List<String> paths = new ArrayList<>();
        // backtrack1(root, "", paths);
        backtrack(root, new StringBuilder(), paths);
        return paths;
    }

    public void backtrack1(TreeNode<Integer> root, String path, List<String> paths) {
        if (root != null) {
            path += root.data;
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                path += "->";
                backtrack1(root.left, path, paths);
                backtrack1(root.right, path, paths);
            }
        }
    }

    public void backtrack(TreeNode<Integer> root, StringBuilder path, List<String> paths) {
        if (root == null) return;

        int lengthBefore = path.length();
        path.append(root.data);
        if (root.left == null && root.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            backtrack(root.left, path, paths);
            backtrack(root.right, path, paths);
        }

        path.setLength(lengthBefore);

    }

    public void backtrack3(TreeNode<Integer> root, StringBuilder path, List<String> paths) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            paths.add(path.append(root.data).toString());
            return;
        }

        int lengthBefore = path.length();
        path.append(root.data).append("->");

        backtrack3(root.left, path, paths);
        backtrack3(root.right, path, paths);

        path.setLength(lengthBefore);
        
    
    }    

    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(17), new TreeNode<>(1), null, new TreeNode<>(19), new TreeNode<>(5)),
                Arrays.asList(new TreeNode<>(7), new TreeNode<>(6), new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(3), new TreeNode<>(2), null, new TreeNode<>(1)),
                Arrays.asList(new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(6), new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(7), new TreeNode<>(8), null, new TreeNode<>(9)),
                Arrays.asList(new TreeNode<>(5), new TreeNode<>(2), new TreeNode<>(1), new TreeNode<>(6), new TreeNode<>(10), null, new TreeNode<>(44)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(6))
        );
        
        List<BinaryTree> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> listOfNodes : listOfTrees) {
            BinaryTree tree = new BinaryTree(listOfNodes);
            inputTrees.add(tree);
        }

        BinaryTreePath solution = new BinaryTreePath();
        int x = 1;
        for (int i = 0; i < inputTrees.size(); i++) {
            System.out.println(x + ".\tInput Tree:");
            //Print.displayTree(inputTrees.get(i).root,null);
            List<String> res = solution.binaryTreePaths(inputTrees.get(i).root);
            System.out.println("\n\tPaths: " + Arrays.toString(res.toArray()));
            x++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}