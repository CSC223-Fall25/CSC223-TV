package csc223.tv;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyhashTableTest {
    private MyhashTable hashtable;

    @BeforeEach
    public void setUp() {
        hashtable = new MyhashTable(10);

        hashtable.put("ab", 0);
        hashtable.put("bc", 1);
        hashtable.put("cb", 2);
        hashtable.put("ad", 3);
        hashtable.put("da", 4);

    }

    @Test
    public void testContains() {
        assertTrue(hashtable.contains("ab"));
        assertFalse(hashtable.contains("ba"));

        assertTrue(hashtable.contains("bc"));
    }

    @Test
    public void testput() {
        hashtable.put("bb", 5);

        assertTrue(hashtable.contains("bb"));
    }

    @Test
    public void testGet() {
        assertEquals(hashtable.get("ab"), 0);

        assertEquals(hashtable.get("bc"), 1);
    }

    @Test
    public void testRemove() {
        hashtable.remove("ab");

        assertFalse(hashtable.contains("ab"));
    }

    @Test
    public void testSize() {
        assertEquals(hashtable.size(), 5);
    }
   
}
