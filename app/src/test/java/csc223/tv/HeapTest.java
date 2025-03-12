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
        testmaxheap.insert('e');
        testmaxheap.insert('c');
        testmaxheap.insert('d');
        testmaxheap.insert('a');
        testmaxheap.insert('b');
        testmaxheap.insert('d');
        testmaxheap.insert('c');
        //       e 
        //    c     d
        //  a  b   d  c

        testminheap = new MinHeap();
        testminheap.insert('a');
        testminheap.insert('b');
        testminheap.insert('c');
        testminheap.insert('d');
        testminheap.insert('e');
        testminheap.insert('f');
        testminheap.insert('d');
        //      a 
        //   b     c
        // d  e   f  d
    }

    @Test
    public void testInsert(){
        //test max heap tree 
        //  e c d a b d c
        assertEquals(testmaxheap.toString(),"e c d a b d c");

        //test min heap tree
        //  a b c d e f d
        assertEquals(testminheap.toString(),"a b c d e f d");
    }

    @Test
    public void testdelete(){
        //Max Heap Tests
        testmaxheap.delete();
        // d c d a b c
        assertEquals(testmaxheap.toString(),"d c d a b c");

        //Min Heap Tests
        testminheap.delete();
        // b d c d e f
        assertEquals(testminheap.toString(),"b d c d e f");
    }

    @Test
    public void testPeek(){
        //Max Heap Tests
        assertEquals(testmaxheap.peek(),'e');
        testmaxheap.delete();
        assertEquals(testmaxheap.peek(),'d');

        //Min Heap Test
        assertEquals(testminheap.peek(),'a');
        testminheap.delete();
        assertEquals(testminheap.peek(),'b');
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
        assertEquals(testmaxheap.toString(),"e c d a b d c");

        //Min Heap Test
        assertEquals(testminheap.toString(),"a b c d e f d");
    }
}
