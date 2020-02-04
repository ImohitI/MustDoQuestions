package com.interviewprep.BST;

public class BSTUtility {

    public Node search(Node root, int key){


        if(root==null || root.key== key){
            return root;
        }

        if(root.key> key){
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    //A recursive function to insert a new key BST
    public Node insert( Node root, int key){

        //If the tree is empty, return a new node.
        if(root == null){
            root = new Node(null, null, key);
            return root;
        }


        if(key<root.key)
            root.left = insert(root.left,key);
        else if(key > root.key)
            root.right = insert(root.right, key);

        return root;
    }
    //A utility function to do inorder traversal of BST
    public void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    //A utility function to find the max depth
    public int maxDepth(Node node){
        if(node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            //use larger one
            if(lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }

    }

    public Node deleteRec(Node root, int key){

        if(root == null) return root;

        if(key<root.key)
            root.left = deleteRec(root.left, key);
        else if(key > root.key)
            root.right = deleteRec(root.right, key);
        else
        {
            //if key is same as node key then that node has to be deleted

            if(root.left == null){
                System.out.println(">> WTF right return "+root.right);
                return root.right;
            }else if(root.right == null){
                System.out.println(">> WTF left return "+root.left);
                return root.left;
            }

            //node with two children: get the inorder successor(smallest in the right subtree)
            root.key = minValue(root.right);
            System.out.println(">> "+root.key);
            //Delete the inorder successor
            root.right = deleteRec(root.right, root.key);

        }
        return root;
    }

    public int minValue(Node root){
        int minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public void print2DUtil(Node root, int space, int count)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += count;

        // Process right child first
        print2DUtil(root.right, space, count);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = count; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");

        // Process left child
        print2DUtil(root.left, space,count);
    }

    // Wrapper over print2DUtil()
    public void print2D(Node root , int count)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0, 10);
    }
    public boolean checkBST(Node node){
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(Node node , int min, int max){

        if(node ==null)
            return true;

        if(node.key < min || node.key > max){
            return  false;
        }

        return (checkBST(node.left, min, node.key-1) && checkBST(node.right, node.key+1,max));
    }

}
