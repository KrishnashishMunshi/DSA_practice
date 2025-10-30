public class solution {
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

    public static void main(String[] args) {
        solution sol = new solution();
        int[] arr = {5, 3, 1, 2, 9, 8, 1};
        sol.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}