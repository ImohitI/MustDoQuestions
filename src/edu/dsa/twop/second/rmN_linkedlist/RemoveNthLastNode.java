package edu.dsa.twop.second.rmN_linkedlist;

public class RemoveNthLastNode {
    
    // in a single pass
    public static Node removeNthLastNode(Node head, int n) {
        Node right = head;
        Node left = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }

    public static void main(String[] args) {
        int[] list = {23, 89, 10, 5, 67, 39, 70, 28};
        LinkedList<Integer> inputList = new LinkedList<>();
        inputList.createLinkedList(list);

        inputList.printList(inputList.head);

        int n = 8;
        inputList.printList(removeNthLastNode(inputList.head, n));

    }
}
