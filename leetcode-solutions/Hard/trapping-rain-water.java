/**
 * LeetCode Problem: 42. Trapping Rain Water
 * Difficulty: Hard
 *
 * Link: https://leetcode.com/problems/trapping-rain-water/
 *
 * Approach:
 * - Use two-pointer technique to scan from both ends of the array.
 * - Maintain two variables, leftMaximum and rightMaximum, to track the highest bars seen so far from left and right.
 * - At each step, calculate the water that can be trapped at the current index based on the minimum of the two maxima.
 * - Move the pointer (left or right) with the smaller height inward.
 *
 * Time Complexity: O(n), where n is the length of the height array
 * Space Complexity: O(1), constant space
 */

class Solution {
    public int trap(int[] height) {
        if (height.length==0){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int rightMaximum = 0;
        int leftMaximum = 0;
        int water =0;
        while (right>left){
            if (height[left]<height[right]){
                if (height[left]>leftMaximum){
                    leftMaximum=height[left];
                } else {
                    water+=leftMaximum-height[left];
                }
                left++;
            } else {
                if (height[right]>rightMaximum){
                    rightMaximum=height[right];
                } else {
                    water+=rightMaximum-height[right];
                }
                right--;
            }
        }
        return water;
    }
}
