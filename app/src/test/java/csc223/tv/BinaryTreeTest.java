package csc223.tv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    private BinaryTree tree;


    @BeforeEach
    public void setUp() {
        tree = new BinaryTree();
    }   

    @Test
    public void testInsertAndSize(){
        tree.insert('a');
        tree.insert('b');

        assertEquals(tree.size, 2);
        assertEquals(tree.height, 2);
    }

    @Test 
    public void testlevelOrder(){
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');

        assertEquals(tree.levelorder(), "abc");
    }

    @Test
    public void testpreOrder(){
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');
        tree.insert('d');
        tree.insert('e');

        assertEquals(tree.preorder(), "abdec");

    }

    @Test
    public void testinOrder(){
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');
        tree.insert('d');
        tree.insert('e');

        assertEquals(tree.inorder(), "dbeac");
    }

    @Test
    public void testpostOrder(){
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');
        tree.insert('d');
        tree.insert('e');

        assertEquals(tree.postorder(), "debca");
    }

    @Test
    public void testHeight(){
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');
        tree.insert('d');
        tree.insert('e');

        assertEquals(tree.height(), 3);
    }

    @Test
    public void testSearch(){
        tree.insert('a');
        tree.insert('b');
        tree.insert('c');
        tree.insert('d');
        tree.insert('e');

        assertTrue(tree.search('a'));
        assertTrue(tree.search('b'));
        assertTrue(tree.search('c'));
        assertFalse(tree.search('f'));

        
    }

    @Test
    public void testisEmpty(){
        assertTrue(tree.isEmpty());

        tree.insert('a');

        assertFalse(tree.isEmpty());

    }

}
