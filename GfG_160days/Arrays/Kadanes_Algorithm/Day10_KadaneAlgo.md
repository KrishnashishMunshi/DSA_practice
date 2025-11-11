## Problem:

You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].

Note : A subarray is a continuous part of an array.

### Examples :

Input: `arr[] = [2, 3, -8, 7, -1, 2, 3]`

Output: `11`

Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.


Input: `arr[] = [-2, -4]`

Output: `-2`

Explanation: The subarray [-2] has the largest sum -2.

Input: `arr[] = [5, 4, 1, 7, 8]`

Output: `25`

Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.

## Solution:

### *Approach: Kadane's Algorithm*

Since we need to find the maximum sum of a subarray, we can just continuouly make the decision to either continue increasing our sum with the current element, or consdier our subarray starting from current element based on whichever is maximum.


And then we set the max value based on whatever the earlier max sum of subarray value was, compared to the current sum.

## Code
```
class Solution {
    int maxSubarraySum(int[] arr) {
        
        int n=arr.length;
        int currSum = arr[0];
        int max = arr[0];
        
        for(int i=1; i < n ; i++){
            
        currSum = Math.max(currSum+arr[i], arr[i]);
        
        
        max = Math.max(max, currSum);

        }
        
        return max;
    }
}

```


# Time and Space complexity

The time complexity of this approach is O(n).

The space complexity of this approach is O(1).