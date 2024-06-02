package edu.dsa.fastslowp;

public class CycleAndMiddlell {
    public static void main(String[] args) {
        testCycle();
        testMiddle();

    }
    public static void testMiddle () {
        
        int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};
        
          for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tInput linked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tMiddle of the linked list is:  " );
            System.out.println(middleNode(list.head).data);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
    public static void testCycle() {
        int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
                { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));       
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
    public static boolean detectCycle(LinkedListNode head) {
        if (head == null) {
            return false;
        }
    
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    public static LinkedListNode middleNode(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;	
            fast = fast.next.next; 
        }

        return slow;
    }
}

class LinkedList<T> {
    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void createLinkedList(int[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(list[i]);
            insertNodeAtHead(newNode);
        }
    }

    public static LinkedListNode getNode(LinkedListNode head, int pos) {
        LinkedListNode ptr = head;
        if (pos != -1) {
            int p = 0;
            while (p < pos) {
                ptr = ptr.next;
                p += 1;
            }
            return ptr;
        }
        return ptr;
    }

    public static int getLength(LinkedListNode head) {
        LinkedListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            } else{
                // if this is the last node, print null at the end
                System.out.print(" → null \n ");
            }
        }
    }
    public static void printListWithForwardArrowLoop(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
    }
}