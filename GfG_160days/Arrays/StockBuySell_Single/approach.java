public class approach{

    public int maximumProfit(int prices[]) {
       
       int res =0;
        int minSoFar = prices[0];
        
        for(int i=0;i<prices.length;i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }
    

    public static void main(String[] args){
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
    }
}