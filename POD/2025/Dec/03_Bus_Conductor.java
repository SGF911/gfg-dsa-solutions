/*
Problem: Bus Conductor
Platform: GeeksforGeeks
Date: 19 Dec 2025
Difficulty: Medium

Description:
You are the conductor of a bus. Given two arrays chairs[] and passengers[] 
of equal length, return the minimum number of moves required to seat all 
passengers such that each passenger occupies a unique chair. 

A move is increasing or decreasing a passenger's position by 1.

Example:
Input:  chairs = [3, 1, 5], passengers = [2, 7, 4]
Output: 4
Explanation: Move passengers to nearest chairs. Total moves = 4.

Constraints:
1 ≤ n ≤ 10^5
1 ≤ chairs[i], passengers[j] ≤ 10^4
*/

import java.util.*;

class Solution {
    public int minMovesToSeat(int[] chairs, int[] passengers) {
        Arrays.sort(chairs);       // Sort chair positions
        Arrays.sort(passengers);   // Sort passenger positions
        
        int moves = 0;
        for (int i = 0; i < chairs.length; i++) {
            moves += Math.abs(chairs[i] - passengers[i]);  // Distance for each passenger
        }
        return moves;
    }
}

public class GFG {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Sample Input 1
        int[] chairs1 = {3, 1, 5};
        int[] passengers1 = {2, 7, 4};
        System.out.println("Minimum moves: " + sol.minMovesToSeat(chairs1, passengers1));
        // Output: 4
        
        // Sample Input 2
        int[] chairs2 = {2, 2, 6, 6};
        int[] passengers2 = {1, 3, 2, 6};
        System.out.println("Minimum moves: " + sol.minMovesToSeat(chairs2, passengers2));
        // Output: 4
    }
}

// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) ignoring input arrays
