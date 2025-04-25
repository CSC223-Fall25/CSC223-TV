package csc223.tv;
import java.util.*;

public class MyhashTable {

    private static class Entry{
        String key;
        Integer value;

        Entry(String key, int value){
            this.key = key;
            this.value = value;
        }

    }

    ArrayList<Entry>[]  buckets;
    int capacity;
    int size;
    

    public MyhashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList[capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i ++){
            buckets[i] = new ArrayList<>();
        }
    }

    private int getIndex(String key){
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public void put(String key, int value) {
        int index = getIndex(key);
        ArrayList<Entry> bucket = buckets[index];

        for (Entry  entry : bucket){
            if (entry.key == key){
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
        size += 1;
    }




    public Integer get(String key) {
        int index = getIndex(key);
        ArrayList<Entry> bucket = buckets[index];

        for (Entry entry : bucket){
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(String key){
        int index = getIndex(key);
        ArrayList<Entry> bucket = buckets[index];

        for (Entry entry : bucket){
            if (entry.key == key) {
                bucket.remove(entry);
                size -= 1;
                return;
            }
        }
    }

    public boolean contains(String key){
        int index = getIndex(key);
        ArrayList<Entry> bucket = buckets[index];

        for (Entry entry: bucket) {
            if (entry.key == key ) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }
}
