/*
Problem: Find the Peak Element in a 2D Matrix
Platform: GeeksforGeeks
Date: 25 Dec 2025
Difficulty: Medium

Description:
Given a 2D matrix mat of size n x m, find any peak element. 
An element is a peak if it is greater than or equal to its neighbors (up, down, left, right).

Example:
Input: mat = {
    {1, 4, 3},
    {6, 7, 8},
    {5, 9, 2}
}
Output: [2,1] 
Explanation: mat[2][1] = 9 is greater than its neighbors.

Constraints:
1 ≤ n, m ≤ 500
*/

import java.util.*;

class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Find row index of max element in mid column
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int left = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
            int right = (mid + 1 < m) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;

            if (mat[maxRow][mid] >= left && mat[maxRow][mid] >= right) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(maxRow);
                ans.add(mid);
                return ans;
            } else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new ArrayList<>(); // fallback (won't happen)
    }
}

public class GFG {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat = {
            {1, 4, 3},
            {6, 7, 8},
            {5, 9, 2}
        };

        ArrayList<Integer> peak = sol.findPeakGrid(mat);
        System.out.println("Peak found at: " + peak); // Output: [2,1]
    }
}

// Time Complexity: O(n * log m) → binary search over columns, linear scan per column
// Space Complexity: O(1)
