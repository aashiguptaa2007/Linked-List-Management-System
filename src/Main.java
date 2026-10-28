import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final SinglyLinkedList singly = new SinglyLinkedList();
    private static final DoublyLinkedList doubly = new DoublyLinkedList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==================================");
            System.out.println("     LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: singlyMenu(); break;
                case 2: doublyMenu(); break;
                case 3: compareLists(); break;
                case 4: System.out.println("Thank you for using the system."); return;
                default: System.out.println("Invalid choice. Choose 1 to 4.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();
            try { return Integer.parseInt(line.trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid integer."); }
        }
    }

    private static void singlyMenu() {
        while (true) {
            System.out.println("\n--- Singly Linked List ---");
            System.out.println("1. Insert at Beginning   2. Insert at End");
            System.out.println("3. Insert at Position    4. Insert After a Node");
            System.out.println("5. Insert Before a Node  6. Delete from Beginning");
            System.out.println("7. Delete from End       8. Delete from Position");
            System.out.println("9. Delete by Value       10. Search");
            System.out.println("11. Update               12. Display");
            System.out.println("13. Count Nodes          14. Find Maximum");
            System.out.println("15. Find Minimum         16. Find Middle Element");
            System.out.println("17. Reverse              18. Sort");
            System.out.println("19. Remove Duplicates    20. Exit");
            int choice = readInt("Enter choice: ");
            int value, target, position;
            switch (choice) {
                case 1: singly.insertBeginning(readInt("Value: ")); done(); break;
                case 2: singly.insertEnd(readInt("Value: ")); done(); break;
                case 3:
                    value = readInt("Value: "); position = readInt("1-based position: ");
                    report(singly.insertAtPosition(value, position), "Inserted.", "Invalid position."); break;
                case 4:
                    target = readInt("Insert after which value? "); value = readInt("New value: ");
                    report(singly.insertAfter(target, value), "Inserted.", "Target not found."); break;
                case 5:
                    target = readInt("Insert before which value? "); value = readInt("New value: ");
                    report(singly.insertBefore(target, value), "Inserted.", "Target not found."); break;
                case 6: report(singly.deleteBeginning(), "First node deleted.", "List is empty."); break;
                case 7: report(singly.deleteEnd(), "Last node deleted.", "List is empty."); break;
                case 8:
                    position = readInt("1-based position: ");
                    report(singly.deleteAtPosition(position), "Node deleted.", "Invalid position or empty list."); break;
                case 9:
                    value = readInt("Value to delete: ");
                    report(singly.deleteValue(value), "First matching value deleted.", "Value not found."); break;
                case 10:
                    value = readInt("Value to search: "); position = singly.search(value);
                    System.out.println(position == -1 ? "Value not found." : "Found at position " + position + "."); break;
                case 11:
                    target = readInt("Existing value: "); value = readInt("New value: ");
                    report(singly.update(target, value), "Updated first matching value.", "Value not found."); break;
                case 12: singly.display(); break;
                case 13: System.out.println("Node count: " + singly.count()); break;
                case 14: printExtreme("Maximum", singly.maximum()); break;
                case 15: printExtreme("Minimum", singly.minimum()); break;
                case 16: printExtreme("Middle element", singly.middle()); break;
                case 17: singly.reverse(); done(); break;
                case 18: singly.sort(); done(); break;
                case 19: singly.removeDuplicates(); done(); break;
                case 20: return;
                default: System.out.println("Invalid choice. Choose 1 to 20.");
            }
        }
    }

    private static void doublyMenu() {
        while (true) {
            System.out.println("\n--- Doubly Linked List ---");
            System.out.println("1. Insert at Beginning   2. Insert at End");
            System.out.println("3. Insert at Position    4. Insert After a Node");
            System.out.println("5. Insert Before a Node  6. Delete from Beginning");
            System.out.println("7. Delete from End       8. Delete from Position");
            System.out.println("9. Delete by Value       10. Search");
            System.out.println("11. Update               12. Display Forward");
            System.out.println("13. Display Backward     14. Count Nodes");
            System.out.println("15. Find Maximum         16. Find Minimum");
            System.out.println("17. Find Middle Element  18. Reverse");
            System.out.println("19. Sort                 20. Remove Duplicates");
            System.out.println("21. Exit");
            int choice = readInt("Enter choice: ");
            int value, target, position;
            switch (choice) {
                case 1: doubly.insertBeginning(readInt("Value: ")); done(); break;
                case 2: doubly.insertEnd(readInt("Value: ")); done(); break;
                case 3:
                    value = readInt("Value: "); position = readInt("1-based position: ");
                    report(doubly.insertAtPosition(value, position), "Inserted.", "Invalid position."); break;
                case 4:
                    target = readInt("Insert after which value? "); value = readInt("New value: ");
                    report(doubly.insertAfter(target, value), "Inserted.", "Target not found."); break;
                case 5:
                    target = readInt("Insert before which value? "); value = readInt("New value: ");
                    report(doubly.insertBefore(target, value), "Inserted.", "Target not found."); break;
                case 6: report(doubly.deleteBeginning(), "First node deleted.", "List is empty."); break;
                case 7: report(doubly.deleteEnd(), "Last node deleted.", "List is empty."); break;
                case 8:
                    position = readInt("1-based position: ");
                    report(doubly.deleteAtPosition(position), "Node deleted.", "Invalid position or empty list."); break;
                case 9:
                    value = readInt("Value to delete: ");
                    report(doubly.deleteValue(value), "First matching value deleted.", "Value not found."); break;
                case 10:
                    value = readInt("Value to search: "); position = doubly.search(value);
                    System.out.println(position == -1 ? "Value not found." : "Found at position " + position + "."); break;
                case 11:
                    target = readInt("Existing value: "); value = readInt("New value: ");
                    report(doubly.update(target, value), "Updated first matching value.", "Value not found."); break;
                case 12: doubly.displayForward(); break;
                case 13: doubly.displayBackward(); break;
                case 14: System.out.println("Node count: " + doubly.count()); break;
                case 15: printExtreme("Maximum", doubly.maximum()); break;
                case 16: printExtreme("Minimum", doubly.minimum()); break;
                case 17: printExtreme("Middle element", doubly.middle()); break;
                case 18: doubly.reverse(); done(); break;
                case 19: doubly.sort(); done(); break;
                case 20: doubly.removeDuplicates(); done(); break;
                case 21: return;
                default: System.out.println("Invalid choice. Choose 1 to 21.");
            }
        }
    }

    private static void compareLists() {
        System.out.println("\nSINGLY LINKED LIST");
        System.out.println("- Each node stores data and a next reference.");
        System.out.println("- Traversal is forward only.");
        System.out.println("- Uses less link memory per node.");
        System.out.println("- Deleting the last node requires traversal from the head.");
        System.out.println("\nDOUBLY LINKED LIST");
        System.out.println("- Each node stores data, a previous reference, and a next reference.");
        System.out.println("- Traversal is possible in both directions.");
        System.out.println("- Uses more link memory per node.");
        System.out.println("- Tail reference makes deletion from the end O(1).");
    }

    private static void report(boolean success, String yes, String no) {
        System.out.println(success ? yes : no);
    }
    private static void printExtreme(String label, Integer value) {
        System.out.println(value == null ? "List is empty." : label + ": " + value);
    }
    private static void done() { System.out.println("Operation completed."); }
}
