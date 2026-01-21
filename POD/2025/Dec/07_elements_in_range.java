/*
Problem: Elements in Range [a, b]
Platform: GeeksforGeeks
Date: 23 Dec 2025
Difficulty: Medium

Description:
Given an array arr[] and multiple queries of the form [a, b], 
return the count of elements in arr that lie in the inclusive range [a, b] for each query.

Example:
Input: arr = {1, 2, 3, 5, 7}, queries = {{2, 5}, {0, 3}}
Output: [3, 3]
Explanation:
- For query [2,5]: elements 2, 3, 5 → count = 3
- For query [0,3]: elements 1, 2, 3 → count = 3

Constraints:
1 ≤ n ≤ 10^5
1 ≤ arr[i], a, b ≤ 10^4
*/

import java.util.*;

class Solution {
    public static ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr); // Sort the array for binary search
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int a = q[0], b = q[1];
            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);
            result.add(right - left);
        }
        return result;
    }

    // First index >= target
    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // First index > target
    static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

public class GFG {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7};
        int[][] queries = {{2, 5}, {0, 3}};

        ArrayList<Integer> res = Solution.cntInRange(arr, queries);
        System.out.println(res); // Output: [3, 3]
    }
}

// Time Complexity: O(n log n + q log n)  -> sorting + binary search per query
// Space Complexity: O(q) for storing results
