package HashMaps;

public class SelectionSortHashMaps {
    // This method is for sorting by using the score value from lowest to highest
    public static void selectionSortInt(int[] list) {
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the list
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }
    // This method is for sorting by using the string value from lowest to highest
    public static void selectionSortString(String[] list) {
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the list
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            String temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }


}