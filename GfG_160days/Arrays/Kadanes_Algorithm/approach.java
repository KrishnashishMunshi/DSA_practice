public class approach{

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
    

    public static void main(String[] args){
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}