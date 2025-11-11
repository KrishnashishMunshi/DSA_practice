## Problem:

Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

Note: It is guaranteed that the answer fits in a 32-bit integer.

### Examples :

Input: `arr[] = [-2, 6, -3, -10, 0, 2]`

Output: `180`

Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.


Input: `arr[] = [-1, -3, -10, 0, 6]`

Output: `30`

Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.

Input: `arr[] = [2, 3, 4] `

Output: `24`

Explanation: For an array with all positive elements, the result is product of all elements. 

## Solution:

### *Approach 1: Greedy Min-Max Product*

Keep track of the maximum subarray product and minimum subarray product, and for each new element in the array, check the max and min out of the set of values (arr[i], currMax * arr[i], currMin * arr[i]), and set the maxProd bu comparing it with currMax.

This strategy ensures, that for an even no. of negative elements, we still consider them as contenders for maxProd. given they are made postive and their magnitude exceeds the current max.

## Code
```
class Solution {
    int maxProduct(int[] arr) {
        // code here
        int currMax = arr[0];
        int currMin = arr[0];
        int maxProd = arr[0];
        
        for(int i =1; i< arr.length; i++){
            int temp = Math.max(arr[i], Math.max(currMin * arr[i], currMax * arr[i]));
            
            currMin =   Math.min(arr[i], Math.min(currMin*arr[i], currMax*arr[i]));
            
            currMax = temp;
            maxProd = Math.max(currMax, maxProd);
        }
        
        return maxProd;
        
    }
}
```

### *Approach 2: Traversing in both directions*

By simple observation we can see that, as long as we deal with an odd no. of negative elements and 0, the max product of subarray is just the product of all the elements.

So how do we deal with the two issues?

1) When zero comes:
Set the running product to that point as 1, as the running product gets reset at that point.

2) When odd no. of negative elements occur:
We need to drop one negative element, either from the beginning, or the end, to identify dropping which one gives the greater value, we traverse in both directions, so that we can choose between dropping the element from the end or from the beginning.

We consistently compare the current max value with the running product to identify the max most value so far.

## Code
```
class Solution {
    int maxProduct(int[] arr) {
       
       
       int n = arr.length;
       
       int startProd = 1;
       int endProd = 1;
       int maxProd = Integer.MIN_VALUE;
       
       
       for(int i =0; i<n; i++){
           
           int j = n-i-1;
           
           if(startProd == 0){
               startProd = 1;
           }
           if(endProd ==0){
               endProd = 1;
           }
           
           startProd*=arr[i];
           endProd *= arr[j];
           
           maxProd = Math.max(maxProd, Math.max(startProd, endProd));
           
       }
       
       return maxProd;
    }
}
```

# Time and Space complexity

The time complexity of both the approaches is O(n).

The space complexity of both the approaches is O(1).