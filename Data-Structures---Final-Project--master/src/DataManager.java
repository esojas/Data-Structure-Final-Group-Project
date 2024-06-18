import ArrayList.MyArrayList;
import ArrayList.Person;
import HashMaps.MyHashmaps;
import LinkedList.MyLinkedList;
import LinkedList.Person2;

import java.util.Scanner;

public class DataManager {
    // Create instances of MyHashmaps, MyArrayList, and MyLinkedList
    MyHashmaps<String, Integer> myHashmaps = new MyHashmaps<>();
    MyArrayList<Person> myArrayList = new MyArrayList<>();
    MyLinkedList<Person2> myLinkedList = new MyLinkedList<>();
    // Handles operations on the HashMap using HashmapManager
    public void handleHashmapOperations(Scanner scanner) {
        HashmapManager.handleOperations(scanner, myHashmaps);
    }
    // Handles operations on the ArrayList using ArrayListManager
    public void handleArrayListOperations(Scanner scanner) {
        ArrayListManager.handleOperations(scanner, myArrayList);
    }
    // Handles operations on the LinkedList using LinkedListManager
    public void handleLinkedListOperations(Scanner scanner) {
        LinkedListManager.handleOperations(scanner, myLinkedList);
    }
}
