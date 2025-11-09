public class approach1{

    static int totalMaxProf(int prices[], int start, int end){

        int max = 0;
        
        for(int i=start; i<end;i++){
            for(int j = i+1; j<= end;j++){
                
                if(prices[j]>prices[i]){
                    int curr = (prices[j] - prices[i]) + totalMaxProf(prices, start, i-1 ) + totalMaxProf(prices, j+1, end);
                
                max = Math.max(max, curr);
                }
            }   
        }

        return max;
    }

    public static void main(String[] args){
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(totalMaxProf(prices, 0, prices.length-1));
    }
}