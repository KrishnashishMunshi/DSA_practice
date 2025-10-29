public class approach2 {
    
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

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        rotateArr(arr, d);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}