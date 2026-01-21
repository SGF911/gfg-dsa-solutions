/*
Problem: Sort in Specific Order
Platform: GeeksforGeeks
Date: 18 Dec 2025
Difficulty: Medium
Link: https://www.geeksforgeeks.org/sort-in-specific-order/

Note:
This solution is written for the GeeksforGeeks platform
and uses predefined driver code.
*/

import java.util.*;

class Solution {
    void sortIt(int[] arr) {

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int x : arr) {
            if (x % 2 == 0)
                even.add(x);
            else
                odd.add(x);
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);

        int index = 0;
        for (int x : odd)
            arr[index++] = x;

        for (int x : even)
            arr[index++] = x;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n)
