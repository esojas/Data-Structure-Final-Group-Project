package LinkedList;

public class MyLinkedList<T> {
    private Node<T> head; // Reference to the head node of the linked list
    private int size; // Size of the linked list
    // Node class representing each element in the linked list
    static class Node<T> {
        T value; // Value of the node
        Node<T> next; // Refrence to the next node

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
    // Constructor to initialize an empty linked list
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    // Method to get the size of the linked list
    public int size() {
        return size;
    }
    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add a new value to the linked list
    public void add(T value) {
        Node<T> newNode = new Node<>(value); // Create a new node with the given value
        if (head == null) { // If the list is empty, set the new node as the head
            head = newNode;
        } else { // Otherwise, traverse to the end of the list and add the new node
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++; // Increment the size of the list
    }

    // Method to get the value at a specific index in the linked list
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head; // Start from the head node
        for (int i = 0; i < index; i++) { // Traverse to the desired index
            current = current.next;
        }
        return current.value; // Return the value at the specified index
    }
    // Method to set a new value at a specific index in the linked list
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head; // Start from the head node
        for (int i = 0; i < index; i++) { // Traverse to the desired index
            current = current.next;
        }
        current.value = value; // Set the new value at the specified index
    }
    // Method to swap values at two indices in the linked list
    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index1 == index2) { // If the indices are the same, no swap needed
            return;
        }
        Node<T> node1 = head;
        Node<T> node2 = head;
        for (int i = 0; i < index1; i++) { // Traverse to the first index
            node1 = node1.next;
        }
        for (int i = 0; i < index2; i++) { // Traverse to the second index
            node2 = node2.next;
        }
        T temp = node1.value; // Swap the values
        node1.value = node2.value;
        node2.value = temp;
    }
    // Method to remove a value at a specific index in the linked list
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) { // If the index is 0, remove the head node
            head = head.next;
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) { // Traverse to the node before the desired index
                previous = previous.next;
            }
            previous.next = previous.next.next; // Remove the node at the specified index
        }
        size--; // Decrement the size of the list
    }
    // Method to return a string representation of the linked list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
