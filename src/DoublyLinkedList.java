public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    public boolean isEmpty() { return head == null; }

    public void insertBeginning(int value) {
        Node node = new Node(value);
        if (head == null) { head = tail = node; return; }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void insertEnd(int value) {
        Node node = new Node(value);
        if (tail == null) { head = tail = node; return; }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public boolean insertAtPosition(int value, int position) {
        if (position < 1) return false;
        if (position == 1) { insertBeginning(value); return true; }
        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) current = current.next;
        if (current == null) return false;
        if (current == tail) { insertEnd(value); return true; }
        Node node = new Node(value);
        node.next = current.next;
        node.prev = current;
        current.next.prev = node;
        current.next = node;
        return true;
    }

    public boolean insertAfter(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        if (current == tail) { insertEnd(value); return true; }
        Node node = new Node(value);
        node.next = current.next;
        node.prev = current;
        current.next.prev = node;
        current.next = node;
        return true;
    }

    public boolean insertBefore(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        if (current == head) { insertBeginning(value); return true; }
        Node node = new Node(value);
        node.prev = current.prev;
        node.next = current;
        current.prev.next = node;
        current.prev = node;
        return true;
    }

    public boolean deleteBeginning() {
        if (head == null) return false;
        if (head == tail) { head = tail = null; return true; }
        head = head.next;
        head.prev = null;
        return true;
    }

    public boolean deleteEnd() {
        if (tail == null) return false;
        if (head == tail) { head = tail = null; return true; }
        tail = tail.prev;
        tail.next = null;
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1 || head == null) return false;
        if (position == 1) return deleteBeginning();
        Node current = head;
        for (int i = 1; current != null && i < position; i++) current = current.next;
        if (current == null) return false;
        if (current == tail) return deleteEnd();
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
    }

    public boolean deleteValue(int value) {
        Node current = head;
        while (current != null && current.data != value) current = current.next;
        if (current == null) return false;
        if (current == head) return deleteBeginning();
        if (current == tail) return deleteEnd();
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
    }

    public int search(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) return position;
            current = current.next;
            position++;
        }
        return -1;
    }

    public boolean update(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) { current.data = newValue; return true; }
            current = current.next;
        }
        return false;
    }

    public void displayForward() {
        if (head == null) { System.out.println("List is empty."); return; }
        System.out.print("NULL <- ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            System.out.print(current == null ? " -> NULL" : " <-> ");
        }
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) { System.out.println("List is empty."); return; }
        System.out.print("NULL <- ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            current = current.prev;
            System.out.print(current == null ? " -> NULL" : " <-> ");
        }
        System.out.println();
    }

    public int count() {
        int count = 0;
        for (Node current = head; current != null; current = current.next) count++;
        return count;
    }

    public Integer maximum() {
        if (head == null) return null;
        int max = head.data;
        for (Node current = head.next; current != null; current = current.next)
            if (current.data > max) max = current.data;
        return max;
    }

    public Integer minimum() {
        if (head == null) return null;
        int min = head.data;
        for (Node current = head.next; current != null; current = current.next)
            if (current.data < min) min = current.data;
        return min;
    }

    public Integer middle() {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data; // For an even-sized list, returns the second middle.
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void sort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        for (Node current = head; current != null; current = current.next) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    Node duplicate = runner;
                    runner = runner.next;
                    if (duplicate.prev != null) duplicate.prev.next = duplicate.next;
                    if (duplicate.next != null) duplicate.next.prev = duplicate.prev;
                    if (duplicate == tail) tail = duplicate.prev;
                } else {
                    runner = runner.next;
                }
            }
        }
    }
}
