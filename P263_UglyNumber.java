//给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 6
//输出：true
//解释：6 = 2 × 3
//
// 示例 2：
//
//
//输入：n = 8
//输出：true
//解释：8 = 2 × 2 × 2
//
//
// 示例 3：
//
//
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
//
//
// 示例 4：
//
//
//输入：n = 1
//输出：true
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// -231 <= n <= 231 - 1
//
// Related Topics 数学
// 👍 247 👎 0


  package com.zxf.leetcode.editor.cn;
  public class UglyNumber{
      public static void main(String[] args) {
           Solution solution = new UglyNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUgly(int n) {
        //使用数学方法，如果n是个丑数，那么它一定是2^p*3^q*5^l，所以让它除去所有的2,3,5;若n<=0，那么它一定不是丑数
        if(n<=0)return false;
        int[] factors={2,3,5};
        for(Integer fac:factors){
            while(n%fac==0){
                n=n/fac;
            }
        }
        if(n==1)return true;
        else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
