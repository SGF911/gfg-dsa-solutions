/*
Problem: Count Elements ≤ K in a Sorted Rotated Array
Platform: GeeksforGeeks
Date: 24 Dec 2025
Difficulty: Medium

Description:
Given a sorted rotated array arr[] and an integer x, return the number of 
elements in the array that are less than or equal to x.

Example:
Input: arr = {4,5,6,1,2,3}, x = 3
Output: 3
Explanation: Elements ≤ 3 are 1, 2, 3 → count = 3

Constraints:
1 ≤ n ≤ 10^5
1 ≤ arr[i], x ≤ 10^4
*/

class Solution {

    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;

        int low = 0, high = n - 1;

        // Find index of minimum element (pivot)
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int pivot = low;
        int count = 0;

        // Count in left sorted part
        count += binaryCount(arr, 0, pivot - 1, x);

        // Count in right sorted part
        count += binaryCount(arr, pivot, n - 1, x);

        return count;
    }

    // Count elements ≤ x in arr[l..r] using binary search
    private int binaryCount(int[] arr, int l, int r, int x) {
        int ans = -1;
        int start = l;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return (ans == -1) ? 0 : (ans - start + 1);
    }
}

public class GFG {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {4, 5, 6, 1, 2, 3};
        int x = 3;

        int result = sol.countLessEqual(arr, x);
        System.out.println("Count of elements ≤ " + x + ": " + result); // Output: 3
    }
}

// Time Complexity: O(log n) for pivot + O(log n) for binary count → O(log n)
// Space Complexity: O(1)
