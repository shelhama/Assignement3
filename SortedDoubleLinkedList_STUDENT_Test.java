import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.ListIterator;
/**
 * @author Samuella Helha
 */

/**
 * JUnit test class for SortedDoubleLinkedList.
 */
public class SortedDoubleLinkedList_STUDENT_Test {
    private SortedDoubleLinkedList<Integer> sortedList;
    private Comparator<Integer> comparator;

    /**
     * Setup method to initialize a new sorted list before each test.
     */
    @BeforeEach
    public void setUp() {
        comparator = Integer::compareTo;
        sortedList = new SortedDoubleLinkedList<>(comparator);
    }

    /**
     * Test adding elements to the sorted list.
     * Ensures elements are inserted in the correct order.
     */
    @Test
    public void testAdd() {
        sortedList.add(30);
        sortedList.add(10);
        sortedList.add(20);
        
        ListIterator<Integer> iterator = sortedList.iterator();
        assertEquals(10, iterator.next(), "First element should be 10.");
        assertEquals(20, iterator.next(), "Second element should be 20.");
        assertEquals(30, iterator.next(), "Third element should be 30.");
    }

    /**
     * Test if addToFront() throws UnsupportedOperationException.
     * This operation is not allowed for a sorted list.
     */
    @Test
    public void testAddToFrontException() {
        assertThrows(UnsupportedOperationException.class, () -> sortedList.addToFront(5), 
            "addToFront should throw UnsupportedOperationException.");
    }

    /**
     * Test if addToEnd() throws UnsupportedOperationException.
     * This operation is not allowed for a sorted list.
     */
    @Test
    public void testAddToEndException() {
        assertThrows(UnsupportedOperationException.class, () -> sortedList.addToEnd(50), 
            "addToEnd should throw UnsupportedOperationException.");
    }

    /**
     * Test if the iterator correctly moves forward through the sorted list.
     */
    @Test
    public void testIteratorNext() {
        sortedList.add(15);
        sortedList.add(25);
        sortedList.add(5);
        
        ListIterator<Integer> iterator = sortedList.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        assertEquals(5, iterator.next(), "First element should be 5.");
        assertEquals(15, iterator.next(), "Second element should be 15.");
        assertEquals(25, iterator.next(), "Third element should be 25.");
        assertFalse(iterator.hasNext(), "Iterator should have no further elements.");
    }
    
}
