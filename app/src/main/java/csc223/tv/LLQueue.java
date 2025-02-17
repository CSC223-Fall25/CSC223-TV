package csc223.tv;

import java.lang.annotation.Target;
import java.lang.reflect.Type;

public class LLQueue<T> {
    TreeNodeLL queue;
    int size;

    public LLQueue(){
        this.queue = new TreeNodeLL();
        this.size = 0;
    }

    public void enqueue(TreeNode node){
        this.queue.insert(node);
        this.size += 1;
    }

    public TreeNode dequeue() {
        if (this.queue.isEmpty()) {
            return null;
        }
        
        Object item = this.queue.getFirst();

        this.queue.remove(item);
        this.size -= 1;
        return (TreeNode) item;
    }

    public TreeNode top(){
        if (this.queue.isEmpty()){
            return null;
        }
        return (TreeNode) this.queue.getFirst();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public boolean contains(TreeNode item){
        return this.queue.contains(item);
    }
    
}
