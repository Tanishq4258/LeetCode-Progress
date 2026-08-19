class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit=0;
        int buyprice = prices[0]+fee;

        for(int i =1;i<prices.length;i++){
            if(prices[i]+fee < buyprice){
                buyprice = prices[i]+fee;
            }else if(prices[i]>buyprice){
                profit+=prices[i] - buyprice;
                buyprice = prices[i];
            }
        }
        return profit;
    }
}