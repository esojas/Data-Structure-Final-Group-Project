package ArrayList;

public class MyArrayList<T> {
    private Object[] data;
    private int size;

    public MyArrayList(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    public MyArrayList() {
        this(10); // Set a default initial capacity
    }
    // To get the number of the list
    public int size() {
        return size;
    }
    // To check if empty
    public boolean isEmpty() {
        return size == 0;
    }
    // Method to resize internal array if needed
    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size); // Copy elements to new array
        data = newData;
    }
    // Method to add a new element to the list
    public void add(T element) {
        if (size == data.length) {
            resize(2 * data.length); // Double the capacity when full
        }
        data[size++] = element;
    }
    // Method to get the element at a specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }
    // Method to set a new value at a specific index
    public void set(int index, T value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        data[index] = value;
    }
    // Method to remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1); // Shift elements
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
