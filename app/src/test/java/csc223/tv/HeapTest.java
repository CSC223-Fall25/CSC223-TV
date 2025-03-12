package csc223.tv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeapTest{

    private MinHeap testminheap;
    private MaxHeap testmaxheap;

    @BeforeEach
    public void setup(){
        testmaxheap = new MaxHeap();
        testmaxheap.insert(100);
        testmaxheap.insert(40);
        testmaxheap.insert(50);
        testmaxheap.insert(10);
        testmaxheap.insert(15);
        testmaxheap.insert(50);
        testmaxheap.insert(40);
        //        100   
        //    40       50
        //  10  15   50  40

        testminheap = new MinHeap();
        testminheap.insert(10);
        testminheap.insert(15);
        testminheap.insert(30);
        testminheap.insert(40);
        testminheap.insert(50);
        testminheap.insert(100);
        testminheap.insert(40);
        //        10   
        //    15       30
        //  40  50  100  40
    }

    @Test
    public void testInsert(){
        //test max heap tree 
        //  100 40 50 10 15 50 40
        assertEquals(testmaxheap.toString(),"100 40 50 10 15 50 40");

        //test min heap tree
        //  10 15 30 40 50 100 40
        assertEquals(testminheap.toString(),"10 15 30 40 50 100 40");
    }

    @Test
    public void testdelete(){
        //Max Heap Tests
        testmaxheap.delete();
        // 50 40 50 10 15 40
        assertEquals(testmaxheap.toString(),"50 40 50 10 15 40");

        //Min Heap Tests
        testminheap.delete();
        //15 40 30 40 50 100
        assertEquals(testminheap.toString(),"15 40 30 40 50 100");
    }

    @Test
    public void testPeek(){
        //Max Heap Tests
        assertEquals(testmaxheap.peek(),100);
        testmaxheap.delete();
        assertEquals(testmaxheap.peek(),50);

        //Min Heap Test
        assertEquals(testminheap.peek(),10);
        testminheap.delete();
        assertEquals(testminheap.peek(),15);
    }


    @Test
    public void testSize(){
        //Max Heap Tests
        assertEquals(testmaxheap.size(),7);

        testmaxheap.delete();
        assertEquals(testmaxheap.size(),6);

        testmaxheap.clear();
        assertEquals(testmaxheap.size(),0);

        //Min Heap Test
        assertEquals(testminheap.peek(),7);

        testminheap.delete();
        assertEquals(testminheap.peek(),6);

        testminheap.clear();
        assertEquals(testminheap.peek(),0);
    }

    @Test
    public void testIsEmpty(){
        //Max Heap Tests
        assertFalse(testmaxheap.isEmpty());
        testmaxheap.clear();
        assertTrue(testmaxheap.isEmpty());

        //Min Heap Test
        assertFasle(testminheap.isEmpty());
        testminheap.clear();
        assertTrue(testminheap.isEmpty());
    }

    @Test
    public void testClear(){
        //Max Heap Tests
        assertFalse(testmaxheap.isEmpty());
        testmaxheap.clear();
        assertTrue(testmaxheap.isEmpty());

        //Min Heap Test
        assertFasle(testminheap.isEmpty());
        testminheap.clear();
        assertTrue(testminheap.isEmpty());
    }

    @Test
    public void testToString(){
        //Max Heap Tests
        assertEquals(testmaxheap.toString(),"100 40 50 10 15 50 40");

        //Min Heap Test
        assertEquals(testminheap.toString(),"10 15 30 40 50 100 40");
    }
}
