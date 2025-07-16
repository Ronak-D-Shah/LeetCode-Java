/**
 * LeetCode 3: Longest Substring Without Repeating Characters
 * Difficulty: Medium
 *
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach:
 * - Use a sliding window with two pointers (left and right).
 * - Use a HashSet to keep track of characters in the current window.
 * - If a character repeats, move left pointer and remove characters from the set.
 * - Keep updating the max length found.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset)) where charset is the size of the input alphabet (e.g. 128 for ASCII)
 */

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0){
            return 0;
        }
        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> iMap = new HashMap<>();
        for (int end=0; end <s.length();end++){
            char currentChar = s.charAt(end);
            if(iMap.containsKey(currentChar)){
                start=Math.max(start, iMap.get(currentChar)+1);
            }
            iMap.put(currentChar, end);
            maxLength=Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}
