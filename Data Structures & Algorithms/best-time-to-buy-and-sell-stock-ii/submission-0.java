
class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int n = prices.length;
        int profit = 0;
        while(i<n){
        	int buy = prices[i];
        	int j = i+1;
        	while(j<n && prices[j]>buy){
        		buy = prices[j];
        		j++;
        	}
        	profit += prices[j-1] - prices[i];

        	i = j;
        }
        return profit;
    }
}