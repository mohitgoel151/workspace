package learn.ds.linkedlist;


public class LinkedListReverse {

    public void execute() {

        LinkedListNode head = LinkedListFactory.getLinkedList();
        LinkedListUtils.printLinkedList(head);
        LinkedListNode reverse = withRecusion(head);
        LinkedListUtils.printLinkedList(reverse);
        
        LinkedListNode doubleRev = withoutRecusion(reverse);
        LinkedListUtils.printLinkedList(doubleRev);
        
    }
    
    private LinkedListNode withRecusion(LinkedListNode head) {
        
        if (head == null) 
            return head; // first question

        if (head.getNext() == null) 
            return head;
        
        LinkedListNode remaining = head.getNext();
        head.setNext(null);
        LinkedListNode rev = withRecusion(remaining);
        remaining.setNext(head);
        
        
        return rev;
    }
    
    private LinkedListNode withoutRecusion(LinkedListNode head) {
        
        if (head == null) 
            return head; // first question
        
        if (head.getNext() == null) 
            return head;
        
        LinkedListNode curr = head;
        LinkedListNode next = null;
        LinkedListNode prv = null;
        
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(prv);
            prv = curr;
            curr = next;
        }
        
        
        return prv;
    }

}
