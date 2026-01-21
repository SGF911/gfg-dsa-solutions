/*
Problem: Search Insert Position
Platform: GeeksforGeeks
Date: 20 Dec 2025
Difficulty: Medium

Description:
Given a sorted array arr[] and a target value k, return the index if the target is found.
If not, return the index where it would be inserted in order.

Example:
Input: arr = [1,3,5,6], k = 5
Output: 2

Input: arr = [1,3,5,6], k = 2
Output: 1

Constraints:
1 ≤ n ≤ 10^5
-10^4 ≤ arr[i], k ≤ 10^4
*/

class Solution {
    public int searchInsertK(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k)
                return mid;
            else if (arr[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low; // Position where k would be inserted
    }
}

public class GFG {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] arr1 = {1, 3, 5, 6};
        int k1 = 5;
        System.out.println("Insert position: " + sol.searchInsertK(arr1, k1));
        // Output: 2

        // Example 2
        int[] arr2 = {1, 3, 5, 6};
        int k2 = 2;
        System.out.println("Insert position: " + sol.searchInsertK(arr2, k2));
        // Output: 1
    }
}

// Time Complexity: O(log n) due to binary search
// Space Complexity: O(1)
