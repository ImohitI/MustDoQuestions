package com.algoexpert.arraysproblems;

public class ClosestValueInBST {
    static int COUNT;
    public static void main(String[] args) {

/*
        BST b = new BST(10);

        b.left = new BST(5);
        b.left.left = new BST(2);
        b.left.left.left = new BST(1);

        b.left.right = new BST(5);

        b.right = new BST(15);
        b.right.left = new BST(13);
        b.right.left.right = new BST(14);

        b.right.right = new BST(22);

        int ans = findClosestValueInBst(b, 12);
        System.out.println("/////////---answer " + ans);
*/

        BST b = new BST(100);
        b.insert(5);
        b.insert(15);
        b.insert(5);
        b.insert(2);
        b.insert(1);
        b.insert(22);
        b.insert(1);
        b.insert(1);
        b.insert(3);
        b.insert(1);
        b.insert(1);
        b.insert(502);
        b.insert(55000);
        b.insert(204);
        b.insert(205);
        b.insert(207);
        b.insert(206);
        b.insert(208);
        b.insert(203);
        b.insert(-51);
        b.insert(-403);
        b.insert(1001);
        b.insert(57);
        b.insert(60);
        b.insert(4500);

        b.print2D(b);
        int ans = findClosestValueInBst(b, 29751);//30000
        System.out.println("/////////---answer " + ans);

/*        int ans = findClosestValueBst(b, 30000);//30000 // 29751
        System.out.println("/////////---answer " + ans);*/
    }

    public static int findClosestValueInBst(BST tree, int target) {
        int answer = -1;
        if (tree != null) {
            answer = look(tree, target, tree.value);
            //look(tree.right, target);
        }

        return answer;
    }

    public static int look(BST tree, int target, int headerValue) {
        System.out.println("<<-- tree.value " + tree.value + " target " + target + " headerValue " + headerValue + " -->>");
        if (tree.value == target) {
            System.out.println("target milgya");
            return target;
        }
        if (tree.value > target && headerValue > target) {
            System.out.println("left dekho pls");
            if (tree.left == null) {
                System.out.println("i m returning " + tree.value);
                return tree.value;
            }
            return look(tree.left, target, tree.value);
        }
        if (tree.value < target && headerValue > target) {
            System.out.println("kiska chota h ...1 ");
            if(tree.right==null) {
                if (target - tree.value <= headerValue - target) {
                    System.out.println(">> return tree " + tree.value);
                    return tree.value;
                }else{
                    System.out.println(">> return header " + headerValue);
                    return headerValue;
                }
            }else {
                System.out.println(">> just go right " + tree.value);

                return look(tree.right, target, tree.value);
            }
        }
        if (tree.value > target && headerValue < target) {
            System.out.println("kiska chota h ...2");
            if(tree.left==null) {
                if (tree.value - target <= target - headerValue) {
                    System.out.println(">> return tree " + tree.value);
                    return tree.value;
                } else {
                    System.out.println(">> return header "+headerValue);
                    return headerValue;
                }
            }else{
                System.out.println(">> just go left " + tree.value);

                return look(tree.left, target, tree.value);
            }
        }
        if (tree.value < target && headerValue < target) {
            System.out.println("right dekho pls");
            if (tree.right == null) {
                System.out.println("i m returning " + tree.value);
                return tree.value;
            }
            return look(tree.right, target, tree.value);

        }

        return -1;
    }


    public static int findClosestValueBst(BST tree, int target){

        return findClosestValueBst(tree, target , Double.MAX_VALUE);
    }
    public static int findClosestValueBst(BST tree, int target, double closest){
        System.out.println(" tree.value "+tree.value+" target "+target+" closest "+closest);
        if(Math.abs(target - closest) > Math.abs(target - tree.value)){
            System.out.println("setting closest as "+tree.value);
            closest = tree.value;
        }
        if(target < tree.value && tree.left != null){
            System.out.println("Looking Left of "+tree.value);
            return findClosestValueBst(tree.left, target,closest);
        }else if(target > tree.value && tree.right != null){
            System.out.println("Looking Right of "+tree.value);
            return findClosestValueBst(tree.right, target, closest);
        }else{
            System.out.println("Returning closest "+closest);
            return (int) closest;
        }
    }
    static class BST {

        public int value;
        public BST left;
        public BST right;


        public BST(int value) {
            this.value = value;
            COUNT++;
        }

        public boolean insert(int val) {

            if (this.value > val) {
                if (this.left == null) {
                    this.left = new BST(val);
                } else {
                    this.left.insert(val);
                }
            } else if(this.value <= val) {
                if (this.right == null) {
                    this.right = new BST(val);
                } else {
                    this.right.insert(val);
                }
            }
            return true;
        }
        static void print2DUtil(BST root, int space)
        {
            // Base case
            if (root == null)
                return;

            // Increase distance between levels
            space += COUNT;

            // Process right child first
            print2DUtil(root.right, space);

            // Print current node after space
            // count
            System.out.print("\n");
            for (int i = COUNT; i < space; i++)
                System.out.print(" ");
            System.out.print(root.value + "\n");

            // Process left child
            print2DUtil(root.left, space);
        }
        static void print2D(BST root)
        {
            // Pass initial space count as 0
            print2DUtil(root, 0);
        }
    }

}
