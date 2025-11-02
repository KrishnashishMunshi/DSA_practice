## Problem:

Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.

Note: The returned array of majority elements should be sorted.

### Examples :

Input: `arr[] = [2, 2, 3, 1, 3, 2, 1, 1]`

Output: `[1, 2]`

Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).


Input: `[-5, 3, -5]`

Output: `[-5]`

Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 = 1).

Input: `[3, 2, 2, 4, 1, 4]`

Output:`[]`

There is no majority element.


## Solution:

### *Approach 1: Brute-force method*

Loop through the entire array, and for each element, loop through the entire array again to find its frequency, and if the count is more than n/3 and the elements is not present in the result arraylist, add it to the arraylist.

## Code 
```
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
       
        ArrayList<Integer> sol = new ArrayList<Integer>();

        int maj = arr.length / 3;
        int cnt = 0;

        for(int i=0; i<arr.length;i++){
            cnt= 0;
            for(int j =0; j<arr.length;j++ ){
                if(arr[i] == arr[j]){
                    cnt+=1;
                }
            }
            if(cnt>maj && !sol.contains(arr[i])){
                sol.add(arr[i]);
            }
        }

        Collections.sort(sol);
        return sol;
    }
}
```

**Issue:** The time complexity is O(n^2). (Space complexity is O(1)).

---
### *Approach 2: Using Hashmap*


`Step 1:` Loop through the array, if we encounter a new element, add it to the hashmap as a key and give it the value 1, if we encounter a known element, add 1 to its value in the hashmap.

`Step 2:` Loop through the hashmap to find the keys that have a frequency over n/3 and add them to the `sol` arraylist.


## Code
```
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here

    HashMap<Integer,Integer> hmap = new HashMap<>();
    ArrayList<Integer> sol = new ArrayList<>();
    int majority = arr.length/3;

    for(int i=0; i<arr.length;i++){
        if(!hmap.containsKey(arr[i])){
            hmap.put(arr[i], 1);
        }
        else{
            int val = hmap.get(arr[i]);
            val += 1;
            hmap.put(arr[i], val);
        }
    }
    
    for(Map.Entry<Integer, Integer> entry : hmap.entrySet()){
        Integer value = entry.getValue();
        if(value > majority){
            sol.add(entry.getKey());
        }
    }
    
    
    Collections.sort(sol);
    return sol;
    }
}
```

---
### *Approach 3: Moore's Voting Algorithm*

`Step 1:` Since the majority occurs at n/3, there can at most be 2 majority candidates. So let us take two variables `can1`, `can2` for the candidates and two variables `cnt1` and `cnt2` for their voting calculation. 

`Step 2:` Now we loop through the array, and for every instance of an element matching `can1` or `can2` we add 1 to their respective counts. If the element matches neither, then we decrement both their counts by 1.

`Step 3:` If the count ever becomes 0 for any of the two candidates, then replace that candidate with the current element.

`Step 4:` By the end this ensures, that `can1` and `can2` are the two most probable elements for majority.

`Step 5:` Traverse the array once more to find the actual frequency of both the candidates, and add them to the `sol` arraylist if it is more than n/3.

## Code
```
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
      
    int can1 = -1, can2 = -1, cnt1=0, cnt2=0;
    int majority = arr.length/3;
    ArrayList<Integer> sol = new ArrayList<>();

    for(int i=0; i<arr.length;i++){
        if(arr[i]==can1){
            cnt1 += 1;
        }
        else if(arr[i]==can2){
            cnt2 += 1;
        }
        else if(cnt1 == 0){
            can1 = arr[i];
            cnt1 = 1;
        }
        else if(cnt2 == 0){
            can2 = arr[i];
        }
        else{
            cnt1 -= 1;
            cnt2 -= 1;
        }
    }

    cnt1 =0;
    cnt2 = 0;

    for(int j=0; j<arr.length;j++){
        if(arr[j]==can1){
            cnt1+=1;
        }else if(arr[j] == can2 && can1 != can2){
            cnt2 += 1;
        }
    }
    
    if(cnt1>majority){
        sol.add(can1);
    }
    if(cnt2>majority){
        sol.add(can2);
    }
    
    Collections.sort(sol);
    return sol;
    }
}
```

# Time and Space complexity

The time compleixty for approach 2 and approach 3 is *O(n)*.

Space complexity for approach 2 is *O(n)* whereas space complexity for approach 3 is *O(1)*.