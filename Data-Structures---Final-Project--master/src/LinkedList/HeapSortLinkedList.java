package LinkedList;


public class HeapSortLinkedList {

    public static void sort(MyLinkedList<Person2> arr) {
        int N = arr.size();

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            Person2 temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(MyLinkedList<Person2> arr, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr.get(l).getNumber() > arr.get(largest).getNumber())
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr.get(r).getNumber() > arr.get(largest).getNumber())
            largest = r;


        // If largest is not root
        if (largest != i) {
            Person2 swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

}