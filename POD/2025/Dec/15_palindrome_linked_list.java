/*
Problem: Palindrome Linked List
Platform: GeeksforGeeks
Date: 31 dec 2025
Difficulty: Medium

Description:
Given a singly linked list, determine if it is a palindrome. 
A list is a palindrome if it reads the same forward and backward.

Example:
Input: 1 -> 2 -> 3 -> 2 -> 1
Output: true

Input: 1 -> 2 -> 3 -> 4
Output: false

Constraints:
1 ≤ Number of nodes ≤ 10^5
0 ≤ Node.data ≤ 10^9
*/

class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class Solution {
    
    // Function to check whether the list is palindrome
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle of the linked list
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Step 3: Compare both halves
        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data) return false;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    // Helper function to reverse a linked list
    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}

public class GFG {
    // Helper method to print linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);

        Solution sol = new Solution();
        System.out.println("Is palindrome? " + sol.isPalindrome(head1)); // true

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        System.out.println("Is palindrome? " + sol.isPalindrome(head2)); // false
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
