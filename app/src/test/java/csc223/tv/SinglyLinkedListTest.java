package csc223.tv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
    private SinglyLinkedList list;

    @BeforeEach
    public void setUp(){
        list = new SinglyLinkedList();
    }

    @Test
    public void testInsertAndSize(){
        list.insert('a');
        list.insert('b');
        list.insert('c');
        assert(list.size == 3);
        assert(list.head.next.data == 'a');
    }

    @Test
    public void testRemove(){
        for (int i = 0; i < 10; i++){
            list.insert('i');
        }
        for (int i = 0; i < 9; i++){
            list.remove('i');
        }
        assert(list.size == 1);
        assertFalse(list.isEmpty());
    }

    @Test 
    public void testGetFirst(){
        // Test get first from an empty list
        assertTrue(list.isEmpty());
        assertEquals(list.getFirst(), '☠');

        list.insert('e');
        for (int i =0; i < 10; i ++){
            list.insert('i');
        }

        assertEquals(list.getFirst(), 'e');
    }

    @Test
    public void testGetLast(){
        //test get last from an empty list
        assertTrue(list.isEmpty());
        assertEquals(list.getLast(), '☠');

        //insert elements in the list
        list.insert('e');
        list.insert('2');

        assertEquals(list.getLast(), '2');
        assertNotEquals(list.getLast(), '3');
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
        list.insert('b');
        list.insert('c');

        assertEquals(list.indexOf('a'), 0);
        assertEquals(list.indexOf('b'), 1);

        assertEquals(list.indexOf('d'), -1);
    }

    @Test
    public void testLastIndexOf(){
        for (int i =0; i < 10; i ++){
            list.insert('r');
        }
        assertEquals(list.lastIndexOf('r'), 9);
    } 

    @Test
    public void testReverse(){
        list.insert('a');
        list.insert('b');
        list.insert('c');

        assertEquals(list.head.next.data, 'a');

        list.reverse();

        assertEquals(list.head.next.data, 'c');
        assertEquals(list.head.next.next.next.data, 'a');
    }

    @Test
    public void testtoString(){
        list.insert('a');
        list.insert('b');

        assertEquals(list.toString(), "ab");

        list.reverse();

        assertEquals(list.toString(), "ba");
    }
}

