//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1534 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {//1动态规划
        //重点：弄清楚状态转移方程和初始化的边界条件。
        //状态转移方程：到达当前位置n只有两种方案，①从n-1位置处一次爬1个台阶到达位置n处。②从n-2位置处一次爬两个台阶到达位置n处。
        //即：f(n)=f(n-1)+f(n-2),所以到达n阶可以先到达n-1阶再一次爬1个台阶到达n阶，或者先到达n-2位置处再一次爬2个台阶到达n处。
        //初始化：n是正整数所以n!=0;f(1)=1;f(2)=2;...
        if(n<3)return n;
        int res=0, n_2=1,n_1=2;//n_1表示n-1阶的方案数，n_2表示n-2阶的方案数，初始化n=3.
        for(int i=3; i<=n; i++){
            res=n_1+n_2;
            n_2=n_1;
            n_1=res;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }