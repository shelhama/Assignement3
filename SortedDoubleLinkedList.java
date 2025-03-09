/**
 * @author Samuella Helha
 * @param <T>
 */import java.util.*;

/**
 * A generic sorted doubly linked list that extends BasicDoubleLinkedList.
 * Elements are stored in sorted order based on the provided Comparator.
 * @param <T> The type of elements stored in the list.
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator; // Comparator to determine order

    /**
     * Constructor to initialize a sorted doubly linked list with a comparator.
     * @param comparator The comparator used for sorting elements in the list.
     */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Adds an element to the sorted list in the correct position.
     * @param data The data to be added to the list.
     */
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node current = head;
            while (current != null && comparator.compare(current.data, data) < 0) {
                current = current.next;
            }
            if (current == head) { // Insert at the beginning
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) { // Insert at the end
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else { // Insert in the middle
                newNode.next = current;
                newNode.prev = current.prev;
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                current.prev = newNode;
            }
        }
        size++;
    }

    /**
     * Throws an UnsupportedOperationException because adding to the front is not supported.
     * @param data The data to be added (not used).
     * @throws UnsupportedOperationException When called.
     */
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("addToFront is not supported in a sorted list.");
    }

    /**
     * Throws an UnsupportedOperationException because adding to the end is not supported.
     * @param data The data to be added (not used).
     * @throws UnsupportedOperationException When called.
     */
    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("addToEnd is not supported in a sorted list.");
    }
    
    /**
     * Converts the sorted linked list into an ArrayList.
     * @return An ArrayList containing all elements in sorted order.
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }
}
