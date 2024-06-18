package ArrayList;

public class SelectionSortArrayList {
    public static <T extends Comparable<T>> void selectionSort(MyArrayList<T> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the list
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            T temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}

