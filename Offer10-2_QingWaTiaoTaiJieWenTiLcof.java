//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 139 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class QingWaTiaoTaiJieWenTiLcof{
      public static void main(String[] args) {
           Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        //动态规划
        //青蛙到达第n阶台阶，可以从n-1阶跳一级，也可以从n-2阶跳2级，所以到达n阶的方法有f(n)=f(n-1)+f(n-2)
        //初始化
        if(n==0)return 1;
        if(n==1)return 1;
        int n_2=1;//f(0)=1
        int n_1=1;//f(1)=1
        //转移方程：f(n)=f(n-1)+f(n-2)
        int res=0;
        for(int i=2; i<=n; i++){
            res=(n_1+n_2)%1000000007;
            n_2=n_1;//更新f(n-2)
            n_1=res;//更新f(n-1)
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }