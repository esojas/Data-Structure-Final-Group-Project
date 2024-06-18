import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Hashmap");
            System.out.println("2. ArrayList");
            System.out.println("3. LinkedList");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            // Give options to choose one of the 3 Data structure
            switch (mainChoice) {
                case 1:
                    dataManager.handleHashmapOperations(scanner);
                    break;
                case 2:
                    dataManager.handleArrayListOperations(scanner);
                    break;
                case 3:
                    dataManager.handleLinkedListOperations(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
