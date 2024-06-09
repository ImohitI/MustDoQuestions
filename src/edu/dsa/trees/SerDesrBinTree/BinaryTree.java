package edu.dsa.trees.SerDesrBinTree;

import java.util.*;

public class BinaryTree<T> {

    TreeNode<T> root;
    BinaryTree(List<TreeNode<T>> ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private TreeNode<T> createBinaryTree(List<TreeNode<T>> ListOfNodes) {
        if (ListOfNodes.isEmpty()) {
            return null;
        }

        // Create the root node of the binary tree
        TreeNode<T> root = new TreeNode<>(ListOfNodes.get(0).data);

        // Create a queue and add the root node to it
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);
        // Start iterating over the list of ListOfNodes starting from the second node
        int i = 1;
        while (i < ListOfNodes.size()) {
            // Get the next node from the queue
            TreeNode<T> curr = q.remove();

            // If the node is not null, create a new TreeNode object for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (ListOfNodes.get(i) != null) {
                curr.left = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.left);
            }

            i++;

            // If there are more ListOfNodes in the list and the next node is not null,
            // create a new TreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                curr.right = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }

        return root;
    }
    
    public TreeNode<T> find(Integer value) {
        TreeNode<T> current = root;

        while (current != null) {
            Integer currentData = (Integer) current.data; // Cast to Integer if necessary
            if (currentData.equals(value)) { // Use equals() to compare Integers
                return current;
            } else if (value < currentData) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
    public TreeNode<T> find1(T value) {
        return findRec(root, value);
    }

    public TreeNode<T> findRec(TreeNode<T> root, T value) {
        if (root == null || root.data.equals(value))
            return root;

        TreeNode<T> leftResult = findRec(root.left, value);
        if (leftResult != null)
            return leftResult;

        TreeNode<T> rightResult = findRec(root.right, value);
        if (rightResult != null)
            return rightResult;

        return null;
    }
}
