package csc223.tv;

public class MinHeap implements Heap {

    int size;
    char[] heap;

    public MinHeap(){
        this.size = 0;
        this.heap = new char[500]; }

    private int parent(int i){
        return (i-1) /2;}    

    private int left(int i){
        return 2*i+1; }


    private int right(int i){
        return 2*i+2; }

    private void swap(int i,int j){
        char s = heap[i];
        heap[i] =heap[j];
        heap[j]= s;
     }

    private void heapifyUp(int i){

        if (i <= 0 ||heap[parent(i)] <= heap[i]){
            return;}
        else{
            swap(i, parent(i));
            heapifyUp(parent(i)); }
    }

    private void heapifyDown(int i){
        int min= i;
        int left = left(i);
        int right =right(i);

        if (left<size && heap[left] <heap[min]){
            min = left;
        }
        if (right<size && heap[right] <heap[min]) {
            min = right;}

        if (min!=i) {
            swap(i, min);
            heapifyDown(min); }
       }


    public void insert(char value) {

        heap[this.size] = value;
        heapifyUp(size);
        size++;}


    public void delete(){
        if (size ==0) {
            return;}

        else{
         heap[0] = heap[size- 1];
        size--;}

        if (size >0){
            heapifyDown(0); }
        
        }


    public char peek(){
        if (isEmpty()){
            return '\u0000';} //used just '0' but test case failed so used the character
        return heap[0];
 }

    public int size(){
        return size;}

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void clear(){
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return ""; }
        
        StringBuilder string = new StringBuilder();

        for (int i =0; i<size; i++) {
            string.append(heap[i]);
            if (i <size-1) {
                string.append(" ");}
        }
        return string.toString(); }



}
