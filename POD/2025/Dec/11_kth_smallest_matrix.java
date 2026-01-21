/*
Problem: Kth Smallest Element in a Matrix
Platform: GeeksforGeeks
Date: 27 Dec 2025
Difficulty: Medium

Description:
Given an n x n matrix mat where each row and column is sorted in ascending order, 
return the kth smallest element in the matrix.

Example:
Input: mat = {
    {1, 5, 9},
    {10, 11, 13},
    {12, 13, 15}
}, k = 8
Output: 13
Explanation: The sorted elements are [1,5,9,10,11,12,13,13,15]. The 8th smallest is 13.

Constraints:
1 ≤ n ≤ 300
-10^9 ≤ mat[i][j] ≤ 10^9
1 ≤ k ≤ n^2
*/

class Solution {
    public static int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(mat, mid);
            
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    // Counts elements ≤ mid in the matrix
    private static int countLessEqual(int[][] mat, int mid) {
        int n = mat.length;
        int count = 0;
        int i = 0, j = n - 1;
        
        while (i < n && j >= 0) {
            if (mat[i][j] <= mid) {
                count += (j + 1);
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}

public class GFG {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;

        int result = Solution.kthSmallest(mat, k);
        System.out.println("Kth smallest element: " + result); // Output: 13
    }
}

// Time Complexity: O(n log(max-min)) where max and min are the largest and smallest elements
// Space Complexity: O(1)
