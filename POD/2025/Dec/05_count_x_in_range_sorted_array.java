/*
Problem: Count X in Range of a Sorted Array
Platform: GeeksforGeeks
Date: 21 Dec 2025
Difficulty: Medium

Description:
Given a sorted array arr[] and multiple queries of the form [l, r, x], 
return the count of occurrences of x in the subarray arr[l..r].

Example:
Input: arr = {1,2,2,4,5,5,5,8}, queries = {{0,7,5},{1,2,2},{0,3,7}}
Output: [3, 2, 0]

Constraints:
1 ≤ n ≤ 10^5
1 ≤ arr[i], x ≤ 10^4
*/

import java.util.*;

public class Solution {

    // Finds the first index >= x in arr[l..r]
    private static int lowerBound(int[] arr, int l, int r, int x) {
        int ans = r + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // Finds the first index > x in arr[l..r]
    private static int upperBound(int[] arr, int l, int r, int x) {
        int ans = r + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // Returns count of x in each query range
    public static ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            int left = lowerBound(arr, l, r, x);
            int right = upperBound(arr, l, r, x);
            result.add(right - left);
        }
        return result;
    }

    // Example test
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 5, 5, 8};
        int[][] queries = {
            {0, 7, 5},
            {1, 2, 2},
            {0, 3, 7}
        };

        ArrayList<Integer> res = Solution.countXInRange(arr, queries);
        System.out.println(res); // Output: [3, 2, 0]
    }
}

// Time Complexity: O(q * log n) per query (q = number of queries)
// Space Complexity: O(q) for storing results
