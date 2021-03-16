//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 1135 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class BestTimeToBuyAndSellStockIi{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int maxProfit(int[] prices) {//1动态规划
        //状态转移方程：每天有两种状态，①当天收市时，手里没有股票；②当天收市时，手里有一只股票。
        //①无股票，最大获益，max(当天卖的，之前卖的)
        //②有股票，最大获益，max(当天不卖，之前卖的当天再买)
        //初始状态：第一天，手里无，获益0；手里有，获益-prices[0]
        if(prices.length<1)return 0;
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;//第一天结束时手里没有
        dp[0][1]=-prices[0];//第一天结束时手里有一支股票
        for(int i=1; i<prices.length; i++){
            dp[i][0]=Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);//(手里有但当天卖的，手里无是之前卖的)
            dp[i][1]=Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);//(手里有但当天不卖， 手里无但当天买)
        }
        return dp[prices.length-1][0];//结束时手里无股票肯定比有股票获益大
    }
     */
    public int maxProfit(int[] prices) {//2贪心算法，计算所有上坡的值
        //今天的股票-昨天的股票只有正数0负数3种可能
        //贪心算法就是只加正数
        //仅仅用于计算，不是实际的交易
        //整个问题等价于寻找x个不想交的区间(li, ri)使得∑(ri-li)最大，故可用贪心
        if(prices.length<1)return 0;
        int res=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]-prices[i-1]>0)res+=prices[i]-prices[i-1];
        }
        return res;
    }
    //
}
//leetcode submit region end(Prohibit modification and deletion)

  }