/*
Problem: Minimum Time to Fulfil All Orders
Platform: GeeksforGeeks
Date: 28 Dec 2025
Difficulty: Medium

Description:
Given an array rank[] representing ranks of cooks and an integer n for the 
number of orders, each cook i can prepare k dishes in time r[i]*k*(k+1)/2. 
Return the minimum time required to fulfil all orders.

Example:
Input: rank = {1,2,3,4}, n = 10
Output: 12
Explanation: The minimum time to complete 10 orders with the given cooks is 12.

Constraints:
1 ≤ n ≤ 10^5
1 ≤ rank[i] ≤ 10^3
*/

class Solution {

    // Check if n orders can be fulfilled in given time
    static boolean canMake(int[] rank, int n, int time) {
        int total = 0;

        for (int r : rank) {
            int k = (int)((-1 + Math.sqrt(1 + 8.0 * time / r)) / 2);
            total += k;
            if (total >= n)
                return true;
        }
        return false;
    }

    // Returns minimum time to fulfill n orders
    static int minTime(int[] rank, int n) {
        int minRank = Integer.MAX_VALUE;
        for (int r : rank)
            minRank = Math.min(minRank, r);

        int low = 0;
        int high = minRank * n * (n + 1) / 2;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(rank, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

public class GFG {
    public static void main(String[] args) {
        int[] rank = {1, 2, 3, 4};
        int n = 10;

        int result = Solution.minTime(rank, n);
        System.out.println("Minimum time to fulfill all orders: " + result); // Output: 12
    }
}

// Time Complexity: O(log(maxTime) * r) → binary search over time, r = number of cooks
// Space Complexity: O(1)
