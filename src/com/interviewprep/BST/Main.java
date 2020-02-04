package com.interviewprep.BST;

public class Main {
    public static void main(String[] args) {

        Node root = new Node(16);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(12);

        BSTUtility bstUtility = new BSTUtility();
        bstUtility.insert(root, 14);
        bstUtility.insert(root, 2);
        //System.out.println("Inserted key "+root.left.right.right.key);
       // System.out.println("Inserted key "+root.left.left.right.key);

        bstUtility.inorderRec(root);
        System.out.println(">> Depth "+bstUtility.maxDepth(root));

        bstUtility.print2D(root,10);

        bstUtility.deleteRec(root, 8);

//        if(root.left.left != null)
//            System.out.println("leftmost leaf ..."+root.left.left.key);
//        else
//            System.out.println("leftmost leaf .."+root.left.key);

        bstUtility.print2D(root,10);

        if(bstUtility.checkBST(root))
            System.out.println("This is a BST");
        else
            System.out.println("Its not a BST");
    }
}
