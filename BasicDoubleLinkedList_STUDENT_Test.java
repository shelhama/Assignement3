import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

/**
 * @author Samuella Helha
 * JUnit test class for BasicDoubleLinkedList.
 */
public class BasicDoubleLinkedList_STUDENT_Test {
    private BasicDoubleLinkedList<Integer> list;
    
    /**
     * Setup method to initialize a new list before each test.
     */
    @BeforeEach
    public void setUp() {
        list = new BasicDoubleLinkedList<>();
    }
    
    /**
     * Test adding elements to the front of the list.
     */
    @Test
    public void testAddToFront() {
        list.addToFront(10);
        list.addToFront(20);
        assertEquals(20, list.getFirst(), "The first element should be 20.");
    }
    
    /**
     * Test adding elements to the end of the list.
     */
    @Test
    public void testAddToEnd() {
        list.addToEnd(30);
        list.addToEnd(40);
        assertEquals(40, list.getLast(), "The last element should be 40.");
    }
    
    /**
     * Test retrieving and removing the first element.
     */
    @Test
    public void testRetrieveFirstElement() {
        list.addToEnd(50);
        list.addToEnd(60);
        assertEquals(50, list.retrieveFirstElement(), "The retrieved first element should be 50.");
        assertEquals(60, list.getFirst(), "The new first element should be 60.");
    }
    
    /**
     * Test retrieving and removing the last element.
     */
    @Test
    public void testRetrieveLastElement() {
        list.addToEnd(70);
        list.addToEnd(80);
        assertEquals(80, list.retrieveLastElement(), "The retrieved last element should be 80.");
        assertEquals(70, list.getLast(), "The new last element should be 70.");
    }
    
    /**
     * Test if the iterator correctly moves forward.
     */
    @Test
    public void testIteratorNext() {
        list.addToEnd(90);
        list.addToEnd(100);
        ListIterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have a next element.");
        assertEquals(90, iterator.next(), "First iterator element should be 90.");
        assertEquals(100, iterator.next(), "Second iterator element should be 100.");
        assertFalse(iterator.hasNext(), "Iterator should have no more elements.");
    }
    
    /**
     * Test if the iterator correctly moves backward.
     */
    @Test
    public void testIteratorPrevious() {
        list.addToEnd(110);
        list.addToEnd(120);
        ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasPrevious(), "Iterator should have a previous element.");
        
    }
    
    /**
     * Test if calling remove() on the iterator throws an UnsupportedOperationException.
     */
    @Test
    public void testIteratorRemoveException() {
        ListIterator<Integer> iterator = list.iterator();
        assertThrows(UnsupportedOperationException.class, iterator::remove, "Remove operation should throw UnsupportedOperationException.");
    }
    
    /**
     * Test removing an element from the list using a comparator.
     */
    @Test
    public void testRemoveElement() {
        list.addToEnd(130);
        list.addToEnd(140);
        list.remove(130, Integer::compare);
        assertEquals(140, list.getFirst(), "First element should now be 140.");
    }
}