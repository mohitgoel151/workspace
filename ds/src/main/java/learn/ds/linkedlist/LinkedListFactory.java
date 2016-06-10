package learn.ds.linkedlist;

public final class LinkedListFactory {
    
    public static LinkedListNode getLinkedList() {
        LinkedListNode head = new LinkedListNode(1);
        head.setNext(new LinkedListNode(2));
        head.getNext().setNext(new LinkedListNode(2));
        head.getNext().getNext().setNext(new LinkedListNode(4));
        head.getNext().getNext().getNext().setNext(new LinkedListNode(5));
        head.getNext().getNext().getNext().getNext().setNext(new LinkedListNode(6));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new LinkedListNode(7));
//        head.getNext().setNext(new LinkedListNode(2));
//        head.getNext().setNext(new LinkedListNode(2));
//        head.getNext().setNext(new LinkedListNode(2));
        
        
        
        return head;
    }

}
