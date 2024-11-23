package edu.dsa.twop.second.rmN_linkedlist;

public class LinkedList<T> {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void createLinkedList(int[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            Node node = new Node(list[i]);
            insertNodeAtHead(node);
        }
    }

    public void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print("->");
            }
        }
        System.out.println("-> null");
    }
}
