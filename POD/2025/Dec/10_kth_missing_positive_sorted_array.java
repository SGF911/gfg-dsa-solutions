/*
Problem: Kth Missing Positive Number in a Sorted Array
Platform: GeeksforGeeks
Date: 26 Dec 2025
Difficulty: Medium

Description:
Given a sorted array arr[] of unique positive integers and an integer k, 
return the kth missing positive number that does not appear in arr.

Example:
Input: arr = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: The missing numbers are [1,5,6,8,9,10,...]. The 5th missing is 9.

Input: arr = [1, 2, 3, 4], k = 2
Output: 6
Explanation: Missing numbers are [5,6,...]. The 2nd missing is 6.

Constraints:
1 ≤ arr.length ≤ 10^5
1 ≤ arr[i], k ≤ 10^5
*/

class Solution {
    public int kthMissing(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k; // Kth missing number
    }
}

public class GFG {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        System.out.println("Kth missing number: " + sol.kthMissing(arr1, k1)); // Output: 9

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        System.out.println("Kth missing number: " + sol.kthMissing(arr2, k2)); // Output: 6
    }
}

// Time Complexity: O(log n) due to binary search
// Space Complexity: O(1)
