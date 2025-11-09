public class approach2{

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
    

    public static void main(String[] args){
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices));
    }
}