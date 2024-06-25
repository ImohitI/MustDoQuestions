package edu.dsa.trees.leveltraversal;
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

        //create the root node of binary tree
        TreeNode<T> root = new TreeNode<T>(ListOfNodes.get(0).data);

        //create q queue and add root to it
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        //start iterating over list from second
        int i = 1;
        while (i < ListOfNodes.size()) {
            //get the next node from the queue
            TreeNode<T> curr = q.remove();

            //if node is not null, create a new treenode
            // set it as the left child
            if (ListOfNodes.get(i) != null) {
                curr.left = new TreeNode<T>(ListOfNodes.get(i).data);
                q.add(curr.left);
            }
            i++;

            // if there are more nodes 
            // add to queue 
            if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                curr.right = new TreeNode<T>(ListOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }
        return root;
    }
}
