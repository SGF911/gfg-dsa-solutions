/*
Problem: Add Numbers in Linked Lists
Platform: GeeksforGeeks
Date: 30 DEc 2025
Difficulty: Medium

Description:
Given two non-empty linked lists representing two non-negative numbers, 
add the two numbers and return it as a linked list. The digits are stored 
in forward order (head is most significant digit).

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
Explanation: 7243 + 564 = 7807

Constraints:
1 ≤ Number of nodes ≤ 10^5
0 ≤ Node.data ≤ 9
*/

import java.util.Stack;

// Node definition
class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class Solution {
    static Node addTwoLists(Node head1, Node head2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Push digits of first list
        while (head1 != null) {
            s1.push(head1.data);
            head1 = head1.next;
        }

        // Push digits of second list
        while (head2 != null) {
            s2.push(head2.data);
            head2 = head2.next;
        }

        int carry = 0;
        Node result = null;

        // Add digits
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();

            Node newNode = new Node(sum % 10);
            newNode.next = result;
            result = newNode;

            carry = sum / 10;
        }

        // Remove leading zeros if any
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
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
        Node l1 = new Node(7);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = Solution.addTwoLists(l1, l2);
        System.out.print("Sum: ");
        printList(result); // Output: 7 -> 8 -> 0 -> 7
    }
}

// Time Complexity: O(max(n,m)) → n,m are lengths of two lists
// Space Complexity: O(n+m) for stacks
