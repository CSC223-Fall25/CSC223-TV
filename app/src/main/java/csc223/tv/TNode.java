package csc223.tv;


public class TNode<T> {
    T data;
    TNode<T> next;
    TNode<T> previous;

    //constructor
    public TNode(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
