package edu.dsa.twop.first;

public class leet121 {
    /*
     * but and sell
     * only one transaction allowed
     * buy before sell
     * 
     * iterate through the prices array while maintaining the minimum price seen so far
     * for each price calculate the profit u could make if you sold at the curr price
     * keep track of max profit
     * return max
     * 
     */
    public int maxProfit(int[] prices) {

        //Edge case 
        if (prices == null && prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            //update the min price if the curr price is lower
            if (price < minPrice) {
                minPrice = price;
            }

            //calculate the profit
            int currProfit = price - minPrice;

            //Update maxProfit if the currProfit is higher
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }

        return maxProfit;

    }

}
