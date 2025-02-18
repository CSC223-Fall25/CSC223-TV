package csc223.tv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NodeTest {
    

    @Test
    public void testNode(){
        Node node = new Node('A');

        assertEquals(node.data, 'A');
        assertNull(node.next);
        assertNull(node.previous);
    }

    @Test
    public void testNodeLink(){
        Node first = new Node('a');
        Node second = new Node('b');

        first.next = second;
        second.previous = first;

        assertEquals(first.next.data, 'b');
        assertEquals(second.previous.data, 'a');
        assertEquals(first.next, second);
        assertEquals(second.previous, first);
    }
}
