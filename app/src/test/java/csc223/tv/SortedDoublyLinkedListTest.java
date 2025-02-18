package csc223.tv;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SortedDoublyLinkedListTest {
    private sortedDoublyLinkedList list;

    @BeforeEach
    public void setUp(){
        list = new sortedDoublyLinkedList();
    }

    @Test
    public void testInsertAndSize(){
        list.insert('b');
        list.insert('a');

        assertEquals(list.size, 2);
    }

    @Test 
    public void testtoString(){
        list.insert('a');
        list.insert('b');
        list.insert('c');

        assertEquals(list.toString(), "abc");
    }

    @Test
    public void testGetFirstandGetLast(){
        list.insert('b');
        list.insert('a');

        assertEquals(list.getFirst(), 'a');

        assertEquals(list.getLast(), 'b');
    }

    @Test 
    public void testGet(){
        // test invalid index
        assertTrue(list.isEmpty());
        assertEquals(list.get(1), '☠');

        for (int i =0; i < 5; i++){
            list.insert('e');
        }

        for (int i = 5; i < 10; i++){
            list.insert('r');
        }

        assertEquals(list.get(4), 'e');
        assertEquals(list.get(5), 'r');
    }

    @Test
    public void testClear(){
        for (int i =0; i < 100; i ++){
            list.insert('e');
        }
        // clear the list if the list is cleared successfully, then the assert test should be true
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains(){
        list.insert('a');
        list.insert('b');
        assertTrue(list.contains('b'));
        list.insert('c');
        assertTrue(list.contains('c'));

        assertTrue(list.size == 3);
    }
    @Test 
    public void testIndexOf(){
        list.insert('a');

        assertEquals(list.indexOf('a'), 0);

        list.insert('b');

        assertEquals(list.indexOf('b'), 1);
    }

    @Test
    public void testLastIndexOf(){
        list.insert('a');
        list.insert('a');

        assertEquals(list.lastIndexOf('a'), 1);

        for (int i =0; i < 10; i ++){
            list.insert('b');
        }

        assertEquals(list.lastIndexOf('b'), 11);
    }



}
