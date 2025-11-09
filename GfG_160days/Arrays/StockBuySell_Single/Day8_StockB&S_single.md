## Problem:

Given an array prices[] of length N, representing the prices of the stocks on different days, the task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell.

Note: Stock must be bought before being sold.

### Examples :

Input: `prices[] = [7, 10, 1, 3, 6, 9, 2]`

Output: `8`

Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9. Hence, the profit is 8.


Input: `prices[] = [7, 6, 4, 3, 1]`

Output: `0`

Explanation: Here the prices are in decreasing order, hence if we buy any day then we cannot sell it at a greater price. Hence, the answer is 0.

Input: `prices[] = [1, 3, 6, 9, 11]`

Output: `10`

Explanation: Since the array is sorted in increasing order, we can make maximum profit by buying at price[0] and selling at price[n-1].

## Solution:

### *Approach: Single traversal method*

Loop through the array, and first check if current element is minimum element, if yes then set it as min, next check if the difference of the current element and minimum element is maximum, if yes set it to max, else move on to the next iteration.

## Code
```
class Solution {
    public int maximumProfit(int prices[]) {
        int res =0;
        int minSoFar = prices[0];
        
        for(int i=0;i<prices.length;i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }
}
```


# Time and Space complexity

The time complexity of this approach is O(n).

The space complexity of this approach is O(1).