/*
 * File: FlattenLinkedList.java
 * GFG POD: Jan 3
 *
 * Problem:
 * Given a linked list where every node has two pointers:
 * - next: points to the next node in the main list
 * - bottom: points to a sorted linked list
 * Flatten the linked list so that all nodes appear in a single sorted list using the bottom pointers.
 *
 * Approach:
 * - Recursively flatten the right side of the list
 * - Merge the current bottom-linked list with the flattened right list
 * - Use a helper 'merge' function similar to merging two sorted linked lists
 * - Set 'next' pointers to null in the final list to avoid cycles
 *
 * Example:
 * Input:  5 -> 10 -> 19 -> 28
 * Each node has its own bottom list (sorted)
 * Output: Flattened sorted linked list
 *
 * Usage:
 * - Compile: javac FlattenLinkedList.java
 * - Run: java FlattenLinkedList
 */

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class FlattenLinkedList {

    // Merge two sorted bottom-linked lists
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // Important for final flattened list
        return result;
    }

    // Flatten the linked list
    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the right side
        root.next = flatten(root.next);

        // Merge current list with flattened right list
        root = merge(root, root.next);

        return root;
    }

    // Example usage
    public static void main(String[] args) {
        FlattenLinkedList solution = new FlattenLinkedList();

        // Create a simple test case
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);

        Node flattened = solution.flatten(head);

        System.out.println("Flattened linked list:");
        Node temp = flattened;
        while (temp != null) {
            System.out.print(temp.data + " ");
