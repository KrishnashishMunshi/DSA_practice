public class approach{

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
    

    public static void main(String[] args){
        int[] array =  {3, 9, 12, 16, 20};
        int k = 3;
        System.out.println(getMinDiff(array, k));
    }
}