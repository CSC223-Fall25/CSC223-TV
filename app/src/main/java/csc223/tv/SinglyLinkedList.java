package csc223.tv;

public class SinglyLinkedList implements LinkedList {

    int size;
    Node head;
    
    // constructor
    public SinglyLinkedList() {
        this.size = 0;
        this.head = new Node('☠');
        this.head.next = null;
    }

    // Insert an item at the end of the list for unsorted lists
    public void insert(char item){
        Node new_node = new Node(item);
        Node current = this.head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new_node;
        this.size += 1;
    }


    // Removes an item from the list
    public void remove(char item){
        Node current = this.head;
        while (current.next != null) {
            if (current.next.data == item){
                current.next = current.next.next;
                this.size -= 1;
                return;
            }
            current = current.next;
        }
    }


    //return the first data in the linked list
    public char getFirst(){
        if (isEmpty()){
            return '☠';
        }
        return this.head.next.data;
    }

    // return the last data stored in the list
    public char getLast(){
        if (isEmpty()){
            return '☠';
        }
        Node current = this.head.next;
        while (current.next != null){
            current = current.next;
        }
        return current.data;
    }

    //return the data stored at the give index
    public char get(int index){
        if (index < 0 || index >= this.size){
            return '☠';
        }
        Node current = this.head.next;
        for (int i = 0; i < index; i ++ ){
            current = current.next;
        }
        return current.data;
    }

    //return the size of the list
    public int size(){
        return this.size;
    }

    //return true if the list is empty
    public boolean isEmpty(){
        return this.size == 0;
    }

    public void clear(){
        this.head.next = null;
        this.size = 0;
    }


    //return true if the data is stored in the list
    public boolean contains(char item){
        Node current = this.head;
        while (current.next != null){
            if (current.next.data == item){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //return the index of the given data
    public int indexOf(char item){
        Node current = this.head.next;
        int i = 0;
        while (current != null){
            if (current.data == item){
                return i;
            }
            current = current.next;
            i += 1;
        }
        return -1;
    }

    // return the last index of the given data
    public int lastIndexOf(char item) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node current = this.head.next;
        while (current != null){
            if ( current.data == item){
                lastIndex = currentIndex;
            }
            current = current.next;
            currentIndex += 1;
        }
        return lastIndex;
    }

    //return the reverse version of 
    public void reverse() {
        Node current = this.head.next;
        Node prev = null;
        Node next = null;
  
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } 
        this.head.next = prev;
    }

    //return string type of the data stored in the list
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node current = this.head.next;
        while (current != null){
            str.append(current.data);
            current = current.next;
        }
        return str.toString();
    }



}
