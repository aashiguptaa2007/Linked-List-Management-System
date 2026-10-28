# Project Report: Linked List Management System

## 1. Introduction
This project is a menu-driven console application that demonstrates operations on singly and doubly linked lists. It allows users to insert, delete, search, update, display, sort, reverse, and inspect nodes.

## 2. Objectives
- Understand node-based dynamic data structures.
- Implement singly and doubly linked lists without using built-in list collections.
- Practice pointer/reference updates during insertion and deletion.
- Compare traversal and memory characteristics of both structures.

## 3. Data Structure Design
A singly linked-list node stores an integer and a reference to the next node. The list maintains a head reference.
A doubly linked-list node stores an integer plus references to the previous and next nodes. The list maintains head and tail references.

## 4. Operations
The application includes the operations listed in the assignment menus. Positions are 1-based. Operations that search for a value act on the first matching node. The middle operation returns the second middle node when the list length is even.

## 5. Algorithms
- Reversal of the singly linked list uses previous, current, and next references.
- Reversal of the doubly linked list swaps previous and next references for each node and then swaps head and tail.
- Sorting uses Bubble Sort by swapping node data.
- Duplicate removal uses nested traversal and preserves the first occurrence.

## 6. Complexity
Insertion at the beginning and deletion at the beginning take O(1). Traversal-based operations such as search, count, minimum, maximum, and middle take O(n). Bubble Sort and the duplicate-removal algorithm take O(n^2). A tail reference allows insertion and deletion at the end of the doubly linked list in O(1).

## 7. Testing
Test cases should include an empty list, a one-node list, valid and invalid positions, absent values, duplicate values, zero and negative values, sorting an empty/single-node list, and reversing an empty/single-node list.

## 8. Conclusion
The project demonstrates the core mechanics of singly and doubly linked lists and provides a menu-driven interface for exercising their operations.

## 9. Student Details
Name - Aashi Gupta
System ID - 2025233159
Batch - 1
