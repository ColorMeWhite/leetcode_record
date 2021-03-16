//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1509 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class BestTimeToBuyAndSellStock{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStock().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {//1动态规划
        //状态转移方程：对于第n天时的获利，若第n天把股票卖出，则获利prices[n]-历史最低价格；若第n天之前已经把股票卖出去了，则获利f(n-1)
        //要获利最大：f(n)=max(prices[n]-minprice, f(n-1))
        //初始条件；n<=1,获利0； n等于2，获利为0或获利prices[1]-prices[0]
//        if(prices.length<=1)return 0;
//        int res=0, n_1=0, minprice=prices[0];
//        for(int i=1; i<prices.length; i++){
//            if(prices[i]<minprice)minprice=prices[i];
//            res=Math.max(prices[i]-minprice, n_1);
//            n_1=res;//随着n++, n-1也要前移
//        }
//         return res;
        //优化一下
        int min=Integer.MAX_VALUE, maxprofit=0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<min)min=prices[i];//历史最小价格
            if(prices[i]-min>maxprofit)maxprofit=prices[i]-min;//只记录历史最大利润
        }
        return maxprofit;
    }
    //2暴力法略，两层遍历
}
//leetcode submit region end(Prohibit modification and deletion)

  }