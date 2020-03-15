package com.algoexpert.arraysproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTConstructionValidationTraversal {
    static int COUNT;

    private void inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            this.inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            this.inOrderTraverse(tree.right, array);
        }
    }

    private boolean compare(List<Integer> array1, List<Integer> array2) {
        if (array1.size() != array2.size()) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (!array1.get(i).equals(array2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

 /*       BST test1 = new BST(10);
        test1.insert(5).insert(15).insert(5).insert(2).insert(14).insert(22);
        BST test2 = new BST(10);
        test2.insert(15).insert(11).insert(22).remove(10);
        BST test3 = new BST(10);
        test3.insert(5).insert(7).insert(2).remove(10);*/
        BST test4 = new BST(10);
        test4.insert(5)
                .insert(15)
                .insert(22)
                .insert(17)
                .insert(34)
                .insert(7)
                .insert(2)
                .insert(5)
                .insert(1)
                .insert(35)
                .insert(27)
                .insert(16)
                .insert(30)
          .remove(22)
          .remove(17);

/*        BST test2 = new BST(10);
        test2.insert(5).insert(7).insert(2);
        test2.print2D(test2);


        System.out.println("------------------------------------------------------------------------------");
        //  test2.contains(7);
        test2.remove(10);
        test2.print2D(test2);*/

        //  test4.print2D(test4);
       // test4.print2D(test4);
        //test4.remove(22);
        System.out.println("------------------------------------------------------------------------------");
     //   test4.print2D(test4);
        //test4.remove(17);
        System.out.println("------------------------------------------------------------------------------");
        test4.print2D(test4);


        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 5, 7, 10, 15, 16, 27, 30, 34, 35));
        List<Integer> output = new ArrayList<Integer>();

        BSTConstructionValidationTraversal b = new BSTConstructionValidationTraversal();
     //   test4.inOrderTraverse(test4, output);
        test4.postOrderTraversal(test4, output);
       // test4.preOrderTraversal(test4, output);
        if (b.compare(output, expected)) {
            System.out.println("equal");
        } else {
            System.out.println("unequal");
        }
        for (int x : output) {
            System.out.println(" " + x);
        }
/*
        test4.validateBst(test4);

        BST test6 = new BST(10);
        test6.insert(5).insert(15).insert(5).insert(2).insert(1).insert(22);
        test6.left.right.right = new BST(11);
        test6.print2D(test6);
        test6.validateBst(test6);*/
    }


    static class BST {

        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            COUNT++;

        }

/*
        public BST insert(int value) {

            if(value< this.value){
                if(left == null){
                    BST bst = new BST(value);
                    left = bst;
                }else{
                    left.insert(value);
                }
            }else{
                if(right == null){
                    BST bst = new BST(value);
                    right = bst;
                }else{
                    right.insert(value);
                }
            }
            System.out.println(" before returning this "+this.value);
            return this;
        }*/


        public BST insert(int value) {
            BST tmp = this;
            while (tmp != null) {

                if (tmp.value > value) {
                    if (tmp.left != null)
                        tmp = tmp.left;
                    else {
                        tmp.left = new BST(value);
                        break;
                    }
                } else {
                    if (tmp.right != null)
                        tmp = tmp.right;
                    else {
                        tmp.right = new BST(value);
                        break;
                    }
                }
            }

            return this;
        }

        public boolean contains(int value) {
            BST tmp = this;

            while (tmp != null) {
                if (tmp.value > value) {
                    System.out.println(tmp.value + " going left");
                    tmp = tmp.left;

                } else if (tmp.value < value) {
                    System.out.println(tmp.value + " going right");
                    tmp = tmp.right;

                } else {
                    System.out.println(tmp.value + " Tree contains the value");
                    return true;
                }
            }
            System.out.println("Value not found in the tree");
            return false;
        }

        public static void print2DUtil(BST root, int space) {
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

        public static void print2D(BST root) {
            // Pass initial space count as 0
            print2DUtil(root, 0);
        }


        public BST remove(int value) {

            remove(value, null);
            return this;
        }

        public void remove(int value, BST parentNode) {

            BST currentNode = this;

            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);

                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            currentNode.value = 0;
                        }

                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;

                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        public int getMinValue() {
            if (left == null) {
                return value;
            } else {
                return left.getMinValue();
            }
        }

        public static List<Integer> inOrderTraverse(BST tree, List<Integer> array ){
            if(tree.left!= null){
                inOrderTraverse(tree.left, array);
            }
            array.add(tree.value);
            if(tree.right!=null){
                inOrderTraverse(tree.right, array);
            }
            return array;
        }

        public static List<Integer> preOrderTraversal(BST tree, List<Integer> array){
            if(tree !=null){
                array.add(tree.value);
            }

            if(tree.left!= null){
                //array.add(tree.value);
                preOrderTraversal(tree.left,array);
            }

            if(tree.right!=null){
                preOrderTraversal(tree.right,array);
            }

            return array;
        }

        public static List<Integer> postOrderTraversal(BST tree, List<Integer> array){

            if(tree.left!=null){
                postOrderTraversal(tree.left, array);
            }
/*            if(tree.right==null){
                array.add(tree.value);
            }*/
            if(tree.right!=null){
                postOrderTraversal(tree.right,array);
               // array.add(tree.value);
            }
            array.add(tree.value);
            return array;
        }


        public static boolean validateBst(BST tree){
            return  validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public static boolean validateBst(BST tree, int minValue, int maxValue){
            System.out.println("validating "+tree.value+" minValue "+minValue+" maxValue "+maxValue);
            if(tree.value < minValue || tree.value>= maxValue){
                System.out.println("failed validation");
                return false;
            }
            if(tree.left != null && !validateBst(tree.left, minValue, tree.value)){
                return  false;
            }
            if(tree.right != null && !validateBst(tree.right, tree.value, maxValue)){
                return false;
            }
            return true;
        }

  /*      public boolean validateBst(BST tree) {

            return validateBst(tree, Integer.MAX_VALUE);
        }

        public boolean validateBst(BST tree, int maxValue ){

            if (tree == null) {
                System.out.println("top returning true");
                return true;
            } else {

                System.out.println("validating for value "+tree.value+" maxValue "+maxValue);

                if (tree.left != null && tree.right != null) {

                    if (tree.left.value >= tree.value
                            || tree.right.value < tree.value
                            || tree.left.value >= maxValue
                            || tree.right.value >= maxValue) {
                        System.out.println("failed in validation");
                        return false;
                    }
                } else {
                    if (tree.left != null) {
                        System.out.println("validating for ... "+tree.value);
                        if (tree.left.value >= tree.value) {
                            return false;
                        }
                    } else if (tree.right != null) {
                        System.out.println("validating for ....... "+tree.value);
                        if (tree.right.value < tree.value) {
                            return false;
                        }
                    }else{
                        System.out.println("left and right nodes are null so returning true");
                        return true;
                    }
                }
            }


//            boolean leftFlag = true;
//            boolean rightFlag = true;

            if ((tree.left != null) && !validateBst(tree.left, tree.value)){
                return false;

            }
            if (tree.right != null && validateBst(tree.right, maxValue)) {
                 return false;
            }
*//*            if(leftFlag && rightFlag){
                System.out.println("returning true at the end ...");
                return true;
            }*//*

            return true;
        }*/

   /*     public BST remove(int value) {


            BST tmp = this;
            BST prevL = null;
            BST prevR = null;
            while (tmp != null) {

                if (tmp.value > value) {
                    prevL = tmp;
                    prevR = null;
                    tmp = tmp.left;

                } else if (tmp.value < value) {
                    prevR = tmp;
                    prevL = null;
                    tmp = tmp.right;

                } else {
                    System.out.println("Tree contains the value " + value);
                    if (tmp.left == null && tmp.right == null) {
                        System.out.println("Deleting if leave node");
                        if (prevL != null) {
                            prevL.left = null;

                        } else if (prevR != null) {
                            prevR.right = null;

                        }
                        break;

                    } else if ((tmp.right == null && tmp.left != null) || (tmp.left == null && tmp.right != null)) {
                        System.out.println("if Node has only one child ");
                        if (prevL != null) {
                            System.out.println("....1....");
                            prevL.left = tmp.left;

                        } else if (prevR != null) {
                            System.out.println("....2....");
                            prevR.right = tmp.left;

                        } else if (prevL == null && prevR == null) {
                            System.out.println(".....3....");
                            if (tmp.right != null && tmp.left == null) {
                                System.out.println("swapping with a node on the right");
                                tmp.value = tmp.right.value;
                                tmp.left = tmp.right.left;
                                tmp.right = tmp.right.right;

                            } else if (tmp.left != null && tmp.right == null) {
                                System.out.println(" swapping with a node on the left");
                                System.out.println(">> " + tmp.value + "  " + tmp.left.value);
                                tmp.value = tmp.left.value;
                                tmp.right = tmp.left.right;
                                tmp.left = tmp.left.left;
                                System.out.println("<< " + tmp.value + "  " + tmp.left.value);
                            }

                        }
                        break;
                    } else {
                        if (tmp.right != null) {
                            System.out.println(" tmp.right value" + tmp.right.value);
                            BST leftTemp = tmp.right;
                            BST prev = tmp;
                            if (leftTemp.left == null) {
                                System.out.println("when there is no left for the right , i swap");
                                prev.right = leftTemp.right;
                                break;
                            }
                            while (leftTemp.left != null) {
                                prev = leftTemp;
                                leftTemp = leftTemp.left;
                            }
                            System.out.println("now no more left left for the right so swapping only values " + leftTemp.value);
                            tmp.value = leftTemp.value;

                            if (leftTemp.right != null)
                                prev.left = leftTemp.right;
                            else
                                prev.left = null;

                            break;
                        }
                    }

                }
            }


            return this;
        }

*/
    }

}
