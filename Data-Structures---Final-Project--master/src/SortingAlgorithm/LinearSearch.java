package SortingAlgorithm;

public class LinearSearch {
    // Method to perform linear search on an array of integers
    // Returns the index of the first occurrence of x in arr, or -1 if not found
    public static int linearSearchInt(int arr[], int N, int x)
    {
        for (int i = 0; i < N; i++) { // Iterates through the whole array
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    // Method to perform linear search on an array of strings
    // Returns the index of the first occurrence of x in arr, or -1 if not found
    public static int linearSearchString(String arr[], int N, String x) {
        for (int i = 0; i < N; i++) { // Iterates through the whole array
            if (arr[i].equals(x))
                return i;
        }
        return -1;
    }
}


