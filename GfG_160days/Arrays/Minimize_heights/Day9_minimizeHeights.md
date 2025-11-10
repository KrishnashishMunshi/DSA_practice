## Problem:

Given an array arr[] denoting heights of n towers and a positive integer k.

For each tower, you must perform exactly one of the following operations exactly once.

    Increase the height of the tower by k
    Decrease the height of the tower by k

Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by k for each tower. After the operation, the resultant array should not contain any negative integers.

### Examples :

Input: `k = 2, arr[] = [1, 5, 8, 10]`

Output: `5`

Explanation: The array can be modified as [1+k, 5-k, 8-k, 10-k] = [3, 3, 6, 8]. The difference between the largest and the smallest is 8-3 = 5.


Input: `k = 3, arr[] = [3, 9, 12, 16, 20]`

Output: `11`

Explanation: The array can be modified as [3+k, 9+k, 12-k, 16-k, 20-k] = [6, 12, 9, 13, 17]. The difference between the largest and the smallest is 17-6 = 11. 

## Solution:

### *Approach: Sorting solution*

Fundamentally what you need to do is perform +k/-k operations across the array such that, the minimum and maximum elements are as close in value as possible.

How to achieve that?

We need to find the optimal splitting point such that adding k to all the elements before it, and subtracting k from all the elements after it, yields the closest pair of max and min.


Step 1: Sort the array in ascending order.

Step 2: For initial difference assume minimum element => (first element+k)
and maximum element => (last element-k).


Step 3: Loops through each element, and identify whether (arr[i-1]-k) is smaller than initial assumption, and whether (arr[i]+k) is greater than initial assumption.

Step 4: If (arr[i]-k) is negative, then suspend all operations for current iteration and move on to the next iteration.

Step 4: Set the new max and min values, and find their difference, if it is smaller than previous difference then update the result or continue to the next iteration.
## Code
```
class Solution {
    public int getMinDiff(int[] arr, int k) {
        
        Arrays.sort(arr);
        
        int n = arr.length;
        int res = arr[n-1] - arr[0];
        int minM, maxM;
        for(int i=1; i<n;i++){
            
            if((arr[i]-k)<0){
                continue;
            }
            
            minM = Math.min(arr[0]+k, arr[i] - k);
            
            maxM = Math.max(arr[i-1]+k, arr[n-1]-k);
            
            res = Math.min(res, maxM-minM);
        }
        return res;
    }
}

```


# Time and Space complexity

The time complexity of this approach is O(n logn).

The space complexity of this approach is O(1).