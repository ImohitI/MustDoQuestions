package edu.dsa.twop.second.lca_bt;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
               List<List<Integer>> input_trees = Arrays.asList(
            Arrays.asList(100, 50, 200, 25, 75, 350),
            Arrays.asList(100, 200, 75, 50, 25, 350),
            Arrays.asList(350, 100, 75, 50, 200, 25),
            Arrays.asList(100, 50, 200, 25, 75, 350),
            Arrays.asList(25, 50, 75, 100, 200, 350)
        );
        List<List<Integer>> input_nodes = Arrays.asList(
            Arrays.asList(25, 75),
            Arrays.asList(50, 350),
            Arrays.asList(100, 200),
            Arrays.asList(50, 25),
            Arrays.asList(350, 200)
        );

        for (int i = 0; i < input_trees.size(); i++) {
            BinaryTree tree = new BinaryTree(input_trees.get(i));
            System.out.println((i + 1) + ".\tBinary tree:");
            //Print.displayTree(tree.getRoot());
            System.out.println("\n\tp = " + input_nodes.get(i).get(0));
            System.out.println("\tq = " + input_nodes.get(i).get(1));
            Node p = tree.find(tree.getRoot(), input_nodes.get(i).get(0));
            Node q = tree.find(tree.getRoot(), input_nodes.get(i).get(1));
            Node lca = LowestCommonAncestor(p, q);
            System.out.println("\n\tLowest common ancestor: " + lca.data);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

    public static Node LowestCommonAncestor(Node p, Node q) {

        Node ptr1 = p;
        Node ptr2 = q;

        while (ptr1 != ptr2) {
            if (ptr1.parent != null) {
                ptr1 = ptr1.parent;
            } else {
                ptr1 = q;
            }

            if (ptr2.parent != null) {
                ptr2 = ptr2.parent;
            } else {
                ptr2 = p;
            }
        }
        return ptr1;

    }
}
