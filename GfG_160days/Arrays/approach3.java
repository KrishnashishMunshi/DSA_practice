public class approach3 {

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

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        rotateArr(arr, d);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
}