## Problem:

Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.

### Examples :

Input: `arr[] = [1, 2, 3, 4, 5], d = 2`

Output: `[3, 4, 5, 1, 2]`

Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.


Input: `arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3`

Output: `[8, 10, 12, 14, 16, 18, 20, 2, 4, 6]`

Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.

Input: `arr[] = [7, 3, 9, 1], d = 9`

Output:`[3, 9, 1, 7]`

Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.


## Solution:

### *Approach 1: Brute-force method*

Do a one element left shift across the array, saving the first element in a temporary element, and after the loop ends, set the last element equal to the value in the temp variable.

### *Approach 2: Juggling algorithm*


Step 1: 
Divide the array into blocks of  `size = gcd(size of array, d)`

Step 2: Swap consecutive blocks until you reach the end. You will have the desired array.

- Q) How to swap consecutive blocks?
    
        Step 1: Swap the first element of each consecutive block.
        Step 2: Swap the second element of each consecutive block.
        .
        .
        .
        And so on, this will continue for gcd(size of array, times as that is the size of each block.

## Code
```
class Solution {
    
    // Function to calculate GCD using the Euclidean algorithm

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    // Function to rotate an array by d elements in counter-clockwise direction.

    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        
        d = d % n;
        
        if (d == 0 || n <= 1) {
            return;
        }

        int numCycles = gcd(n, d);
        
        for (int i = 0; i < numCycles; i++) {

            int temp = arr[i];
            int currIdx = i;
            
            while (true) {

                int nextIdx = (currIdx - d + n) % n;
                

                if (nextIdx == i) {
                    break;
                }

                arr[currIdx] = arr[nextIdx];
                
                currIdx = nextIdx;
            }

            arr[currIdx] = temp;
        }
    }
}
```
### *Approach 3: Reversal algorithm*
By mathematical observation, we can see that effectively the desired outpute array is nothing but a series of reverse sortings.

`Step 1:` We first reverse 0 to d-1 elements.

`Step 2:` We then reverse d to n-1 elements (n -> size of array).

`Step 3:` Reverse the whole array.

These series of reversals will yield the final desired array.

## Code
```
class Solution {

    static void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
            
        }
    }

    // Function to rotate an array by d elements in counter-clockwise direction.

    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        
        d = d%n;
       
        reverse(arr, 0, d-1);
        reverse(arr,d, n-1);
        reverse(arr, 0, n-1);
 
    }
    
}
```

# Time and Space complexity

The overall time complexity for both approach 2 and approach 3 is O(n).

The space complexity for both approach 2 and approach 3 is O(1).