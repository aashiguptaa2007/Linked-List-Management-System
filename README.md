# Linked List Management System

## Objective
A menu-driven Java console application demonstrating singly and doubly linked lists and their common operations.

## Language
Java (uses standard Java features and `Scanner`; no arrays or built-in list collections are used to implement the data structures).

## Features
- Singly linked list: insertion at beginning/end/position/before/after; deletion at beginning/end/position/by value; search; update; display; count; maximum; minimum; middle; reverse; sort; remove duplicates.
- Doubly linked list: the same core operations, plus forward and backward display.
- Menu-driven interface and input validation for integer input.
- Handles empty lists, invalid positions, missing values, duplicates, zero and negative integers.

## Files
- `src/Main.java`: menus and program entry point.
- `src/SinglyLinkedList.java`: singly linked list implementation.
- `src/DoublyLinkedList.java`: doubly linked list implementation.
- `sample-output/output.txt`: illustrative sample run.

## How to Compile and Run
Install a JDK (Java 11 or newer is suitable). Open a terminal in the project folder and run:

```bash
javac -d out src/Main.java src/SinglyLinkedList.java src/DoublyLinkedList.java
java -cp out Main
```

On Windows, these commands work in Command Prompt or PowerShell if `javac` and `java` are on PATH.

## Design Notes
- Positions are 1-based.
- Search, update, insert-before/after, and delete-by-value operate on the first matching value.
- For even-length lists, the middle operation returns the second middle element.
- Sorting uses Bubble Sort by swapping node data.
- Duplicate removal preserves the first occurrence of each value.
- The data structures are implemented using custom nodes, not Java collection classes.

## Typical Time Complexity
| Operation | Singly linked list | Doubly linked list |
|---|---:|---:|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) with tail reference |
| Insert at position | O(n) | O(n) |
| Search / display / count | O(n) | O(n) |
| Delete from beginning | O(1) | O(1) |
| Delete from end | O(n) | O(1) with tail reference |
| Find minimum / maximum / middle | O(n) | O(n) |
| Reverse | O(n) | O(n) |
| Bubble Sort | O(n^2) | O(n^2) |
| Remove duplicates (nested traversal) | O(n^2) | O(n^2) |

## Sample Output
See `sample-output/output.txt`.

## Author
Aashi Gupta
2025233159
Batch 1
