## Problem:

The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

### Examples :

Input: `prices[] = [100, 180, 260, 310, 40, 535, 695]`

Output: `865`

Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.


Input: `prices[] = [4, 2, 2, 2, 4]`

Output: `2`

Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2. Maximum Profit = 2.

## Solution:

### *Approach 1: BRecursion method*

Use recursion, to find all possible Buy-Sell combinations to find out the maximum profit that can be made by analyzing all possible combinations and choosing the maximum profit ones and then adding them together.

Step 1: First, loop through each element in the array ,let's say we select some n'th element.

Step 2: Then, loop through all the elements that are ahead of n, and if they are greater than n then find their difference, let's say (m-n).

Step 3: Then use recursion to find all possible differences to the right of m, and all possible differences to the left of n, and add them together, and store the maximum result in each iteration.

Step 4: By the end of all iterations, we will have the maximum profit that can be made.

## Code
```
class Solution {
    
    static int totalMaxProf(int prices[], int start, int end){

        int max = 0;
        
        for(int i=start; i<end;i++){
            for(int j = i+1; j<= end;j++){
                
                if(prices[j]>prices[i]){
                    int curr = (prices[j] - prices[i]) + totalMaxProf(prices, start, i-1 ) + totalMaxProf(prices, j+1, end);
                
                max = Math.max(max, curr);
                }
            }   
        }

        return max;
    }

    public int maximumProfit(int prices[]) {
    
        return totalMaxProf(prices, 0, prices.length-1);
    }
}
```

### *Approach 2: Using Local Minima and Local Maxima*


Step 1: 
Start at the beginning of the array and try to find the first local minima (by travelling along a dip).

Step 2:
Next continue onwards from the minima, to find the first local maxima (by travelling along the climb).

Step 3: FInd the difference in values and add, and then begin travelling down the dip of the next minima and so on, repeating it until you reach the end of the array.


## Code
```
class Solution {
    
    public int maximumProfit(int prices[]) {
       
       int n = prices.length;
       int lMin = prices[0];
       int lMax = prices[0];
       int res = 0;
       
       int i = 0;
       while(i < n-1){
           while(i<n-1 && prices[i]>= prices[i+1]){
               i++;
           }
            lMin = prices[i];
            
            while(i<n-1 && prices[i] <= prices[i+1]){
                i++;
            }
            lMax = prices[i];
            
            res += lMax - lMin;
       }
       
       return res;
    }
}

```
### *Approach 3: Accumulating profit
We can observe that, in essence, we are just calculating the sum of all the differences in stock prices, everytime the stock price is more than the previous day.

So we can just use a simple for loop to calculate the overall sum based on this simple condition.
## Code
```
class Solution {
    
    public int maximumProfit(int prices[]) {
       int res = 0;
       for(int i=0; i<prices.length-1;i++){
           
            if(prices[i]<prices[i+1]){
               res += prices[i+1] - prices[i];
            }
        }
        return res;
       }      
}
```

# Time and Space complexity

The time complexity for Approach 1 is O(2^n).

The time complexity of Approach 2 and Approach 3 is O(n).

The space complexity of Approach 1 is O(n).

The space complexity of Approach 2 and Approach 3 is O{1}.