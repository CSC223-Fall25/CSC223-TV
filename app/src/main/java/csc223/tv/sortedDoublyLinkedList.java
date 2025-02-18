package csc223.tv;

public class sortedDoublyLinkedList extends DoublyLinkedList {

    Node tail;


    // constructor will be the same as doubly linked list
    public sortedDoublyLinkedList(){
        super();
    }

    @Override
    public void insert(char item){
        Node newNode = new Node(item);

        Node current = this.head.next;

        while (current != this.tail && item >= current.data)
            current = current.next;
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;

            this.size += 1;   
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Node current = this.head.next;

        while (current.next != this.tail){
            str.append(current.data);
            current = current.next;
        }

        return str.toString();
    }
    
    
}
