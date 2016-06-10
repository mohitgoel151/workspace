package learn.ds.linkedlist;

public class LinkedListNode {
    
    private int data;
    private LinkedListNode next;
    
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    
    public LinkedListNode getNext() {
        return next;
    }
    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode() {
        // TODO Auto-generated constructor stub
    }
    
    public LinkedListNode(int value) {
        this.data = value;
    }
}
