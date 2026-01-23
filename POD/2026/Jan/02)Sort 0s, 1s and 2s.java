/*
 * File: Sort012.java
 * GFG POD: Jan 2
 *
 * Problem:
 * Sort an array containing only 0s, 1s, and 2s (Dutch National Flag Problem)
 *
 * Approach:
 * - Use three pointers: low, mid, high
 * - Traverse the array with 'mid' pointer
 * - If arr[mid] == 0: swap with low, increment low and mid
 * - If arr[mid] == 1: just move mid
 * - If arr[mid] == 2: swap with high, decrement high
 * - This ensures a single-pass, in-place sort with O(n) time and O(1) space
 *
 * Example:
 * Input:  {0, 2, 1, 2, 0, 1, 1, 0}
 * Output: {0, 0, 0, 1, 1, 1, 2, 2}
 *
 * Usage:
 * - Compile: javac Sort012.java
 * - Run: java Sort012
 */

class Solution {

    // Function to sort the array containing 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } 
            else if (arr[mid] == 1) {
                mid++;
            } 
            else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 2, 1, 2, 0, 1, 1, 0};

        System.out.println("Before sorting:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        solution.sort012(arr);

        System.out.println("After sorting:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}
