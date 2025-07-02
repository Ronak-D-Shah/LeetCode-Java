/**
 * LeetCode Problem: 121. Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Approach:
 * - Track the minimum price seen so far (to simulate buying at the lowest point)
 * - At each index, calculate profit if we sold at today's price
 * - Update maxProfit accordingly
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfits = 0;

        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            } else {
                maxProfits = Math.max(maxProfits, price - minValue);
            }
        }

        return maxProfits;
    }
}