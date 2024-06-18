import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import HashMaps.SelectionSortHashMaps;
import LinkedList.*;
import SortingAlgorithm.BinarySearch;

public class LinkedListManager {
    // Handles the operations of the linked list
    static void handleOperations(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        while (true) {
            // Display options
            System.out.println("1. Load data from file");
            System.out.println("2. Add");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            System.out.println("5. Sort");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            // Handles user choice
            switch (choice) {
                case 1:
                    loadDataFromFile(scanner, myLinkedList);
                    break;
                case 2:
                    addData(scanner, myLinkedList);
                    break;
                case 3:
                    removeData(scanner, myLinkedList);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                case 5:
                    sort(scanner, myLinkedList);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // Load data from Data package to linked list
    private static void loadDataFromFile(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        long startTime = System.nanoTime();
        // Read the data from the Data Package and split the score and name
        try (BufferedReader reader = new BufferedReader(new FileReader("Data-Structures---Final-Project--master/src/Data/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int number = Integer.parseInt(parts[1].trim());
                    myLinkedList.add(new Person2(name, number));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("Data loaded from " + fileName);
        System.out.println("It took " + (endTime - startTime) + " nanos");
    }
    // Add data to the linked list and updates if duplicate found
    private static void addData(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("Enter key to add:");
        String name = scanner.nextLine();
        System.out.println("Enter value to add:");
        int number = Integer.parseInt(scanner.nextLine());
        Person2 person = new Person2(name, number);
        int index = 0;
        boolean isDuplicate = false;
        // Check if the name already exists in the list
        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getName().equals(name)) {
                index = i;
                isDuplicate = true;
            }
        }

        long startTime = System.nanoTime();
        // If duplicate is found update the existing data or if doesnt exist add new
        if (isDuplicate) {myLinkedList.set(index, person);}
        else {myLinkedList.add(person);}

        long endTime = System.nanoTime();
        System.out.println("Updated Array List: " + myLinkedList);
        System.out.println("It took " + (endTime - startTime) + " nanos");
    }
    // Remove data from linked list using key
    private static void removeData(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("Enter key to remove:");
        String key = scanner.nextLine();
        int index = 0;
        // Find index of the key to remove
        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getName().equals(key)) {
                index = i;
            }
        }

        long startTime = System.nanoTime();
        // Remove the element at the found index
        myLinkedList.remove(index);

        long endTime = System.nanoTime();
        System.out.println("Updated Hashmap: " + myLinkedList);
        System.out.println("It took " + (endTime - startTime) + " nanos");
    }
    // Handles the sorting of the linked list
    private static void sort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        // Display the options
        System.out.println("1. Selection Sort");
        System.out.println("2. Heap Sort");
        System.out.println("3. Quick Sort");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        // Provide the options
        switch (sortChoice) {
            case 1:
                handleSelectionSort(scanner, myLinkedList);
                break;
            case 2:
                handleHeapSort(scanner, myLinkedList);
                break;
            case 3:
                handleQuickSort(scanner, myLinkedList);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    // Performs selection sort on the linked list
    private static void handleSelectionSort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.nanoTime();
        // Perform the sorting
        SelectionSortLinkedList.selectionSort(myLinkedList);

        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " nanos");
        System.out.println(myLinkedList);

        // Perform search in sorted list
        searchInSortedArray(scanner, myLinkedList);
    }
    // Performs Heap sort on the linked list
    private static void handleHeapSort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.nanoTime();

        HeapSortLinkedList.sort(myLinkedList);

        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime)  + " nanos");
        System.out.println(myLinkedList);
        // Perform search in sorted list
        searchInSortedArray(scanner, myLinkedList);
    }
    // Performs Quick sort on the linked list
    private static void handleQuickSort(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        long startTime = System.nanoTime();

        QuickSortLinkedList.quickSort(myLinkedList, 0, myLinkedList.size() - 1);

        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " nanos");
        System.out.println(myLinkedList);
        // Perform search in the sorted list
        searchInSortedArray(scanner, myLinkedList);
    }
    // Prompts the user to search in the sorted list
    private static void searchInSortedArray(Scanner scanner, MyLinkedList<Person2> myLinkedList) {
        System.out.println("Enter the username you want to find:");
        String targetName = scanner.nextLine();
        // Convert the linked list to an array of string
        String[] stringArray = new String[myLinkedList.size()];
        for (int i = 0; i < myLinkedList.size(); i++) {
            stringArray[i] = myLinkedList.get(i).getName();
        }
        SelectionSortHashMaps.selectionSortString(stringArray);
        // Display the options
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        // Handles the user choice
        switch (searchChoice) {
            case 1:
                performLinearSearch(myLinkedList, targetName);
                break;
            case 2:
                performBinarySearch(myLinkedList, stringArray, targetName);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    // Performs linear search in the linked list
    private static void performLinearSearch(MyLinkedList<Person2> myLinkedList, String targetName) {
        long startTime = System.nanoTime();
        boolean test = false;
        int score = 0;

        // Iterate through the list to find the target
        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getName().equals(targetName)) {
                test = true;
                score = myLinkedList.get(i).getNumber();
            }
        }
        // If target found display the score
        if (test) {
            System.out.println("This person's score is " + score);
        } else {
            System.out.println("Not found");
        }

        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " nanos");
    }
    // Performs binary search in the linked list
    private static void performBinarySearch(MyLinkedList<Person2> myLinkedList, String[] stringArray, String targetName) {
        long startTime = System.nanoTime();
        // Perform Binary search on the array
        int index = BinarySearch.binarySearch(stringArray, targetName);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("This person's score is " + myLinkedList.get(index).getNumber());
        }
        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " nanos");
    }
}
