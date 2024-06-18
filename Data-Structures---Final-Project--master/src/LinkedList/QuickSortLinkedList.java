package LinkedList;
import java.util.Random;

public class QuickSortLinkedList {
    public MyLinkedList<Person2> list;
    public int start;
    public int end;

    public QuickSortLinkedList(MyLinkedList<Person2> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    public static void quickSort(MyLinkedList<Person2> list, int start, int end) {
        if (start >= end) { // this is so that the number won't compare itself over and over again
            return;
        }

        int pivotIndex = new Random().nextInt(end - start + 1) + start;
        Person2 pivot = list.get(pivotIndex); // choose pivot element

        int leftPointer = partition(list, start, end, pivot);

        quickSort(list, start, leftPointer - 1); // lower partition
        quickSort(list, leftPointer, end); // higher partition
    }

    private static int partition(MyLinkedList<Person2> list, int start, int end, Person2 pivot) {
        int leftPointer = start;
        int rightPointer = end;
        while (leftPointer <= rightPointer) {
            while (list.get(leftPointer).getNumber() < pivot.getNumber()) { // keeps incrementing if pivot is less
                leftPointer++;
            }
            while (list.get(rightPointer).getNumber() > pivot.getNumber()) { // keeps incrementing if pivot is bigger
                rightPointer--;
            }
            if (leftPointer <= rightPointer) { // Swap elements and move pointers
                swap(list, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        return leftPointer;
    }

    public static void swap(MyLinkedList<Person2> list, int index1, int index2) {
        Person2 temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
