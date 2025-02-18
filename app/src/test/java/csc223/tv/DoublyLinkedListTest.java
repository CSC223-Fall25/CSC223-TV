package csc223.tv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DoublyLinkedListTest {
    private DoublyLinkedList list;

    @BeforeEach
    public void setUp(){
        list = new DoublyLinkedList();
    }

    @Test
    public void testInsertAndSize(){
        list.insert('a');
        list.insert('b');

        assertEquals(list.size, 2);
        assertEquals(list.head.next.data, 'a');
        assertEquals(list.tail.previous.data, 'b');

    }

    @Test 
    public void testRemove(){
        for (int i =0; i < 10; i ++){
            list.insert('a');
        }

        for (int i = 0; i < 10; i ++ ){
            list.remove('a');
        }

        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetFirst(){
        list.insert('b');
        for (int i = 0; i < 10; i ++){
            list.insert('a');
        }

        assertEquals(list.getFirst(), 'b');
        
    }

    @Test
    public void testGetLast(){
        for (int i = 0; i< 10; i ++){
            list.insert('a');
        }
        list.insert('b');

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

    @Test
    public void testReverse(){
        list.insert('a');
        list.insert('b');
        list.insert('c');

        list.reverse();

        assertEquals(list.head.next.data, 'c');
        assertEquals(list.head.next.next.next.data, 'a');
        //assertEquals(list.tail.previous.data, 'a');
    }

    @Test 
    public void testtoString(){
        list.insert('a');
        list.insert('b');
        list.insert('c');

        assertEquals(list.toString(), "abc");
    }




    

}
