package edu.dsa.linklist.revknodes;

public class LinkedListReversal {
    static LinkedListNode[] reverseLinkedList(LinkedListNode node, int k) {

        LinkedListNode previous = null;
        LinkedListNode current = node;
        LinkedListNode next = null;

        for (int i = 0; i < k; i++) {
            // temporarily store the next node
            next = current.next;
            // reverse the current node
            current.next = previous;
            // before we move to the next node, point previous to the
            // current node
            previous = current;
            // move to the next node
            current = next;
        }

        System.out.println("\t\tPointers after reversing k = " + k + " elements:");
        System.out.println("\t\t\tcurrent: " + (current != null ? Integer.toString(current.data) : "null"));
        System.out.println("\t\t\tnext: " + (next != null ? Integer.toString(next.data) : "null"));
        System.out.println("\t\t\tprevious: " + (previous != null ? Integer.toString(previous.data) : "null"));

        return new LinkedListNode[] { previous, current };
    }
}