/*
Problem: Row with Maximum 1s
Platform: GeeksforGeeks
Date: 22 Dec 2025
Difficulty: Medium

Description:
Given a binary matrix arr[][] of size n x m, where each row is sorted, 
find the index of the row that contains the maximum number of 1s. 
Return -1 if no 1s are present.

Example:
Input: arr = {{0, 1, 1}, {1, 1, 1}, {0, 0, 0}}
Output: 1
Explanation: Row 1 has 3 ones, which is maximum.

Constraints:
1 ≤ n, m ≤ 10^3
arr[i][j] ∈ {0,1}
*/

class Solution {
    int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        int row = 0, col = m - 1;
        int ans = -1;
        
        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                ans = row; // Update row with a 1
                col--;     // Move left in the row
            } else {
                row++;     // Move down to next row
            }
        }
        
        return ans;
    }
}

public class GFG {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] arr = {
            {0, 1, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        int result = sol.rowWithMax1s(arr);
        System.out.println("Row with maximum 1s: " + result); // Output: 1
    }
}

// Time Complexity: O(n + m) because we traverse at most n rows and m columns
// Space Complexity: O(1)
