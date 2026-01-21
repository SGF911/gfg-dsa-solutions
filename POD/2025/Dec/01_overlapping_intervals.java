/*
Problem: Overlapping Intervals
Platform: GeeksforGeeks
Date: 17 Dec 2025
Difficulty: Medium
Link: https://www.geeksforgeeks.org/overlapping-intervals/

Note:
This solution is written for the GeeksforGeeks platform
and uses predefined driver code. 
It merges overlapping intervals in a given set of intervals.
*/

import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {

        // Sort intervals based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end) {
                // Overlapping intervals, update end
                end = Math.max(end, arr[i][1]);
            } else {
                // Non-overlapping interval, add previous
                result.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result;
    }
}

// Time Complexity: O(n log n)  --> Sorting dominates
// Space Complexity: O(n)       --> For storing merged intervals
