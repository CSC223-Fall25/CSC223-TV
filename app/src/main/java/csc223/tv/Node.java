package csc223.tv;

public class Node {
    char data;
    Node next;
    Node previous;

    //constructor
    public Node(char data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
