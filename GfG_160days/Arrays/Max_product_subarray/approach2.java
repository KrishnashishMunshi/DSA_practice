public class approach2{

    
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

    

    public static void main(String[] args){
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }
}