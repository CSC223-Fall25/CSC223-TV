package csc223.tv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BinarySearchTreeTest {
    private BinarySearchTree BSTTree;

    @BeforeEach
    public void setUp() {
        BSTTree = new BinarySearchTree();
    }
    
    @Test
    public void testSearchandInsert(){
        BSTTree.insert(1);
        BSTTree.insert(5);
        BSTTree.insert(3);
        BSTTree.insert(7);

        assertFalse(BSTTree.search(4));
        assertTrue(BSTTree.search(5));
        assertFalse(BSTTree.search(8));

        
    }

    @Test
    public void testDelete(){
        BSTTree.insert(5);
        BSTTree.insert(3);
        BSTTree.insert(7);
        BSTTree.insert(2);
        BSTTree.insert(4);
        BSTTree.insert(6);
        BSTTree.insert(8);

        //delete a leaf node
        BSTTree.delete(2);
        assertFalse(BSTTree.search(2));

        //delete a node with one child
        BSTTree.delete(3);
        assertFalse(BSTTree.search(3));

        //delete a node with two children
        BSTTree.delete(5);
        assertFalse(BSTTree.search(5));
        assertTrue(BSTTree.search(4));
        assertTrue(BSTTree.search(7));

        //delete the root node
        BSTTree.delete(7);
        assertFalse(BSTTree.search(7));
    }

    @Test
    public void testLowestCommonAncestor(){
        BSTTree.insert(5);
        BSTTree.insert(3);
        BSTTree.insert(7);
        BSTTree.insert(2);
        BSTTree.insert(4);
        BSTTree.insert(6);
        BSTTree.insert(8);

        assertEquals(5, BSTTree.lowestCommonAncestor(3, 7));

        // Test the situation that p or q is not in the Tree
        assertEquals(-1, BSTTree.lowestCommonAncestor(2, 10));
        
    }

    @Test
    public void testUpdate() {
        BSTTree.insert(5);
        BSTTree.insert(3);
        BSTTree.insert(7);
        BSTTree.insert(2);
        BSTTree.insert(4);
        BSTTree.insert(6);
        BSTTree.insert(8);

        BSTTree.update(3, 10);
        assertFalse(BSTTree.search(3));
        assertTrue(BSTTree.search(10));

        BSTTree.update(5, 10);
        assertFalse(BSTTree.search(5));
        assertTrue(BSTTree.search(10));
        assertFalse(BSTTree.search(3)); // cannot find 3 because 3 has been updated with 10 before
        assertTrue(BSTTree.search(7));
        assertTrue(BSTTree.search(2));
        assertTrue(BSTTree.search(4));
    }

    @Test
    public void testinorder() {
        BSTTree.insert(5);
        BSTTree.insert(3);
        BSTTree.insert(7);
        BSTTree.insert(2);
        BSTTree.insert(4);
        BSTTree.insert(6);
        BSTTree.insert(8);

        assertEquals(BSTTree.inOrder(), "2345678");
    }

    @Test
    public void testSortedArrayToBST() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};

        BSTNode root = BSTTree.sortedArrayToBST(sortedArray);

        assertEquals(root.data, 4);
        
    }
}   
