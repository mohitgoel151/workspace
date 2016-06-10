package learn.ds.linkedlist;

public final class LinkedListUtils {
    
    public static void printLinkedList(LinkedListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.getData() + " -> ");
            head = head.getNext();
        }
    }

}
