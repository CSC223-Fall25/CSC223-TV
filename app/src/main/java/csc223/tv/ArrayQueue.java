package csc223.tv;

public class ArrayQueue {
    int [] queue;
    int size;
    int capacity;

    //constructor
    public ArrayQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
    }
    
    // return if the queue is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

    // add one thing in the queue
    public void enqueue(int item){
        queue[size] = item;
        size += 1;
    }
    
    // get thing out of the queue
    public int dequeue(){
        if (isEmpty()) {
            return -1;
        }
        int item = queue[0];

        for (int i = 1; i < size; i++){
            queue[i-1] = queue[i];
        }
        size -= 1;
        return item;
    }

    // return the the peek in the queue
    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return queue[0];
    }

    // return the size of queue
    public int size(){
        return size;
    }

    public boolean contain(int item) {
        for (int i =0; i < size; i ++) {
            if (queue[i] == item) {
                return true;
            }

        }   
        return false;
    }

}

