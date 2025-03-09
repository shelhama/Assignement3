/**
 * @author Samuella Helha
 * @param <T>
 */import java.util.*;

/**
 * A generic doubly linked list that implements Iterable.
 * @param <T> The type of elements stored in the list.
 */
 public class BasicDoubleLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T>{
    
    /**
     * Inner Node class representing a node in the doubly linked list.
     */
    protected class Node {
        T data;  // Data stored in the node
        Node prev, next; // Pointers to previous and next nodes
        
        /**
         * Constructor to create a node with data.
         * @param data The data to be stored in the node.
         */
        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    /**
     * Inner iterator class implementing ListIterator to traverse the list.
     */
    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current = head; // Start at the head
        private Node lastReturned = null; // Keep track of last returned node

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) throw new NoSuchElementException();
            lastReturned = current; // Track last returned node
            T data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return lastReturned != null && lastReturned.prev != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = (current == null) ? lastReturned : current.prev; // Move back
            lastReturned = current;
            return current.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("Set operation is not supported.");
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("Add operation is not supported.");
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Next index operation is not supported.");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Previous index operation is not supported.");
        }
    }

    
    protected Node head, tail; // References to the first and last nodes
    protected int size; // Number of elements in the list
    
    /**
     * Constructor to initialize an empty doubly linked list.
     */
    public BasicDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Adds an element to the front of the list.
     * @param data The data to be added.
     */
    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    /**
     * Adds an element to the end of the list.
     * @param data The data to be added.
     */
    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    /**
     * Converts the linked list into an ArrayList.
     * @return An ArrayList containing all elements in the list from head to tail.
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
    
    /**
     * Retrieves and removes the first element from the list.
     * @return The first element in the list, or null if empty.
     */
    public T retrieveFirstElement() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }
    
    /**
     * Retrieves and removes the last element from the list.
     * @return The last element in the list, or null if empty.
     */
    public T retrieveLastElement() {
        if (tail == null) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return data;
    }
    
    /**
     * Returns the first element without removing it.
     * @return The first element in the list, or null if empty.
     */
    public T getFirst() {
        return (head != null) ? head.data : null;
    }
    
    /**
     * Returns the last element without removing it.
     * @return The last element in the list, or null if empty.
     */
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }
    
    /**
     * Removes the specified element from the list.
     * @param target The element to remove.
     * @param comparator The comparator to determine element equality.
     */
    public void remove(T target, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, target) == 0) {
                if (current == head) {
                    retrieveFirstElement();
                } else if (current == tail) {
                    retrieveLastElement();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }
    }
    
    /**
     * Returns an iterator to traverse the list.
     * @return A ListIterator for the list.
     */
    @Override 
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }
    
    /**
     * Returns the number of elements in the list.
     * @return The size of the list.
     */
    public int getSize() {
        return size;
    }
}
