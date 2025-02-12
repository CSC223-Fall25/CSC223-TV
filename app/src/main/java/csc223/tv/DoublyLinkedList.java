package csc223.tv;

public class DoublyLinkedList extends SinglyLinkedList {

    Node tail;
    
    //Constructor
    public DoublyLinkedList() {
        super();
        this.tail = new Node('☠');
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    @Override
    public void insert(char item){
        Node newnode = new Node(item);

        newnode.previous = this.tail.previous;
        newnode.next = this.tail;
        this.tail.previous.next = newnode;
        this.tail.previous = newnode;
        this.size += 1;
        
    }

    @Override 
    public void remove(char item){
        Node current = this.head.next;
        while (current != this.tail){
            if (current.data == item){
                current.previous.next = current.next;
                current.next.previous = current.previous;
                super.size -= 1;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public char getFirst(){
        if (super.isEmpty()){
            return '☠';
        } else {
            return this.head.next.data;
        }
    }

    @Override
    public char getLast(){
        if (super.isEmpty()){
            return '☠';
        } else {
            return this.tail.previous.data;
        }
    }

    @Override
    public char get(int index){
        if (index < 0 || index >= super.size){
            return '☠';
        }
        Node current = this.head.next;
        for (int i = 0; i < index; i ++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void reverse() {
        Node current = this.head.next;
        Node prev = null;
        Node next = null;
    
        while (current != this.tail){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } 
        this.head.next = prev;
    }
        

    @Override
    // clear all the elements in the list
    public void clear(){
        this.head.next = this.tail;
        this.tail.previous = this.head;
        super.size = 0;
    }

    @Override
    public int indexOf(char item){
        Node current = this.head.next;
        int i = 0;
        while (current != this.tail){
            if( current.data == item) {
                return i;
            }
            current = current.next;
            i += 1;

        }
        return -1;

    }

    @Override
    public int lastIndexOf(char item) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node current = this.head.next;
        while (current != this.tail){
            if (current.data == item){
                lastIndex = currentIndex;
            }
            current = current.next;
            currentIndex += 1;
        }
        return lastIndex;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node current = this.head.next;
        while (current != this.tail){
            str.append(current.data);
            current = current.next;
        }

        return str.toString();
    }





}
