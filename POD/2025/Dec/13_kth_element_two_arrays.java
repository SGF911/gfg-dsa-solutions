/*
Problem: K-th Element of Two Sorted Arrays
Platform: GeeksforGeeks
Date: 29 Dec 2025
Difficulty: Hard

Description:
Given two sorted arrays a[] and b[] of sizes n and m, respectively, 
return the k-th element in the merged sorted array of a[] and b[] 
without actually merging them.

Example:
Input: a = {2, 3, 6, 7, 9}, b = {1, 4, 8, 10}, k = 5
Output: 6
Explanation: The merged array is [1,2,3,4,6,7,8,9,10]. The 5th element is 6.

Constraints:
1 ≤ n, m ≤ 10^5
1 ≤ k ≤ n + m
*/

class Solution {

    public int kthElement(int[] a, int[] b, int k) {
        // Ensure a is the smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n = a.length;
        int m = b.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int cutA = (low + high) /
