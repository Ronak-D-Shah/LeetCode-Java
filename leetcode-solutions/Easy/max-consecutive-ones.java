/**
 * LeetCode Problem: Max Consecutive Ones
 * Difficulty: Easy
 *
 * Link: https://leetcode.com/problems/max-consecutive-ones/
 *
 * Approach:
 * - This problem asks us to find the longest sequence of consecutive '1's in a binary array.
 * - We can solve this efficiently using a single pass (iteration) through the array.
 * - We maintain two variables:
 * 1. `max`: Stores the overall maximum number of consecutive ones found so far.
 * 2. `currMax`: Stores the current count of consecutive ones in the sequence we are currently examining.
 *
 * Algorithm:
 * 1. Initialize `max = 0` and `currMax = 0`.
 * 2. Iterate through each `num` in the input array `nums`:
 * a. If `num` is `1`:
 * - Increment `currMax` by 1.
 * - Update `max` to be the maximum of `max` and `currMax`. This ensures `max` always holds the largest consecutive count encountered up to that point.
 * b. If `num` is `0`:
 * - Reset `currMax` to `0`. A `0` breaks any sequence of consecutive `1`s.
 * 3. After iterating through the entire array, `max` will hold the maximum number of consecutive `1`s.
 *
 * Why this works:
 * - The `currMax` variable acts as a counter for the current streak of ones.
 * - When a `0` is encountered, the streak is broken, and `currMax` is reset, effectively discarding the previous streak and starting fresh.
 * - `max` continuously captures the highest value `currMax` ever reached, thus ensuring we store the longest consecutive sequence.
 *
 * Time Complexity: O(n), where n is the number of elements in `nums`. We iterate through the array once.
 * Space Complexity: O(1), constant extra space is used for variables `max` and `currMax`.
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currMax = 0;
        // boolean lastOne = false;

        for (int num : nums) {
            if (num == 1) {
                // lastOne = true;
                currMax += 1;
                max = Math.max(max, currMax);
            } else {
                currMax = 0;
                // lastOne = false;
            }
        }

        return max;
    }


/**
Alt attempt
 */
// int res = 0;
// int count = 0;

// for (int n : nums) {
//     if (n == 0) {
//         count = 0;
//     } else {
//         count++;
//     }

//     if (res < count) {
//         res = count;
//     }
// }

// return res;

 
}