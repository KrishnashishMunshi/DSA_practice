## Problem:

Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

Note:  A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

### Examples :

Input: `arr[] = [2, 4, 1, 7, 5, 0]`

Output: `[2, 4, 5, 0, 1, 7]`

Explanation: The next permutation of the given array is [2, 4, 5, 0, 1, 7].

Input: `arr[] = [3, 2, 1]`

Output: `[1, 2, 3]`

Explanation: As arr[] is the last permutation, the next permutation is the lowest one.

Input: `arr[] = [3, 4, 2, 5, 1]`

Output: `[3, 4, 5, 1, 2]`

Explanation: The next permutation of the given array is [3, 4, 5, 1, 2].


## Solution:

### *Understanding the problem*

Pretty much for a given array, there will always beN permutations for it, ordered from least to greatest (ascending order for integers or lexographical order for characters).

What we need to find is the next element in that ordered list of possible permutations for the given array.

We divide the solution into 3 steps:
 
Step 1: First, find the "pivot" position. The first element from the right, that does not follow the strictly descending order.

    For eg. [2,1,3,7,5,0]

    Here, 3 is the pivot since [7,5,0] are strictly decreasing from right.

Step 2: Next, we will swap the pivot element, with the lowest  number greater than pivot element from the right.

    For eg. [2,1,5,7,3,0]

    Here, 5 is the lowest numeber that is greater than 3, so we swap the two numbers.

Step 3: Reverse the sub-array to the right of the pivot element
    For eg. [2,1,5,0,3,7]


*Note: If the given array is already completely in descending order i.e. it is the last element of the ordered permutation set, then the entire array needs to be reversed.*


## Code
```
class Solution {
    void nextPermutation(int[] arr) {
       int n = arr.length;

       int pivot_index = -1;

       //Step 1

       for(int i = n-2; i>=0;i--){
           if(arr[i]<arr[i+1]){
               pivot_index = i;
               break;
           }
         }
         
        int left = pivot_index+1;
        int right = n-1;
         
        if(pivot_index == -1){
            left=0;
            while(left<right){
                int buff = arr[left];
                arr[left] = arr[right];
                arr[right] = buff;
                left++;
                right--;
            }
            return;
        }

        //Step 2

        for(int j = n-1; j>= 0; j--){
            if(arr[j]>arr[pivot_index]){
                int piv = arr[pivot_index];
                arr[pivot_index] = arr[j];
                arr[j]= piv;
                break;
            }
        }

        //Step 3       
        
        while(left<right){
            int buff = arr[left];
            arr[left] = arr[right];
            arr[right] = buff;
            left++;
            right--;
        }
        
        
    }
}
```
