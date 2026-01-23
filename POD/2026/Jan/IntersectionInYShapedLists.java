// IntersectionInYShapedLists.java
// Solved by me in GFG POD of Jan 1
// Java program to find intersection point in Y-shaped linked lists

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionInYShapedLists {

    // Function to find intersection point
    public static Node intersectPoint(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }
        return p1;  // returns intersection node
    }

    // Example usage
    public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        // Creating second linked list: 6 -> 3 (intersecting at node with data 3)
        Node head2 = new Node(6);
        head2.next = head1.next.next; // intersection at node 3

        Node intersection = intersectPoint(head1, head2);

        if (intersection != null) {
            System.out.println("Intersection at node with data: " + intersection.data);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}
