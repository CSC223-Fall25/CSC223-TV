package csc223.tv;

public class TreeNodeLL<T>{
    
    TNode<T> tail;
    TNode<T> head;
    int size;
    
    // Constructor
    public TreeNodeLL() {
        this.head = new TNode<T>(null);  
        this.tail = new TNode<T>(null);  
        this.head.next = this.tail;
        this.tail.previous = this.head;
        this.size = 0;
    }

    // Insert method for adding a new item
    public void insert(T item) {
        TNode<T> newNode = new TNode<T>(item);
        newNode.previous = this.tail.previous;
        newNode.next = this.tail;
        this.tail.previous.next = newNode;
        this.tail.previous = newNode;
        this.size++;
    }

    // Example of getting the first item in the list
    public T getFirst() {
        if (this.size == 0) {
            return null;
        }
        return this.head.next.data;
    }

    public void remove(T item){
        TNode<T> current = this.head.next;
        while (current != this.tail){
            if (current.data == item){
                current.previous.next = current.next;
                current.next.previous = current.previous;
                this.size -= 1;
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(T item) {
        TNode<T> current = this.head;
        while (current.next != this.tail){
            if (current.next.data == item){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
