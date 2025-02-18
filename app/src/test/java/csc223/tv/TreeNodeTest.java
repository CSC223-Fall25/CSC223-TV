package csc223.tv;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TreeNodeTest {
    @Test
    public void testNode(){
        TreeNode node = new TreeNode('A');

        assertEquals(node.data, 'A');
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testNodeLink(){
        TreeNode first = new TreeNode('a');
        TreeNode second = new TreeNode('b');

        first.left = second;

        assertEquals(first.left.data, 'b');
        assertEquals(first.left, second);
    }

}
