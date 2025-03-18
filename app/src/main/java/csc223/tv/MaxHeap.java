package csc223.tv;


public class MaxHeap implements Heap {

    char[] heap;
    int capacity;
    int size;


    public MaxHeap() {
        this.size = 0;
        this.capacity = 100;
        this.heap = new char[capacity];

    }

    public void insert(char value) {    

        heap[this.size] = value;
        size += 1;
        heapifyUp(size -1);
    }

    private void heapifyUp(int index){
        int parentIndex = (index - 1) / 2;

        if (index > 0 && heap[index] > heap[parentIndex]){
            //swap
            char temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            heapifyUp(parentIndex);
        }
    }  

    public void delete(){

        if(isEmpty()) {
            return;
        }
        
        heap[0] = heap[size -1];
        size -= 1;
        heap[size] = '\u0000'; // clear the last element
        heapifyDown(0);

    }
    private void heapifyDown(int index){
        int biggest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < size && heap[leftChildIndex] > heap[biggest]){
            biggest = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex] > heap[biggest]){
            biggest = rightChildIndex;
        }

        if ( biggest != index) {
            //swap 
            char temp = heap[index];
            heap[index] = heap[biggest];
            heap[biggest] = temp;
            heapifyDown(biggest);
        }
    }

    public char peek(){
        if (isEmpty()) {
            return '\u0000'; //return null character
        } 
        return heap[0];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        size = 0;
        for (int i =0; i < capacity; i ++){
            heap[i] = '\u0000'; // clear every elements
        }
    }

    public String toString() {
       StringBuilder sb = new StringBuilder();
       for (int i =0; i < size; i++){
            sb.append(heap[i]).append(" ");
       }
       return sb.toString().trim();
    }
}
