public class approach1{

    
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

    

    public static void main(String[] args){
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }
}