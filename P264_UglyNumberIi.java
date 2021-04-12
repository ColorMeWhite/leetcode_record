//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1690
//
// Related Topics 堆 数学 动态规划
// 👍 593 👎 0


  package com.zxf.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberIi{
      public static void main(String[] args) {
           Solution solution = new UglyNumberIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
//        //1动态规划方法
//        //使用三个指针，分别对每个丑数进行*2，*3，*5的操作，判断当前得出的三个数哪个数最小，则加入dp[i],并且移动该指针，其他指针不变，再进行下一波的比较
//        int[] dp=new int[n];
//        //初始化，最开始丑数为1
//        dp[0]=1;
//        int i2=0, i3=0, i5=0;//最开始三个指数都指向第一个丑数
//        for(int i=1; i<n; i++){
//            int num2=dp[i2]*2, num3=dp[i3]*3, num5=dp[i5]*5;
//            if(num2<=num3&&num2<=num5){
//                i2++;
//                dp[i]=num2;
//            }
//            if(num3<=num2&&num3<=num5){
//                i3++;
//                dp[i]=num3;
//            }
//            if(num5<=num2&&num5<=num3){
//                i5++;
//                dp[i]=num5;
//            }
//        }
//        return dp[n-1];
        //2最小堆
        //思想：使用最小堆（优先队列）存储丑数，为避免重复，使用hash集合判断是否重复
        //优先队列 PriorityQueue:最小堆，保证每次取出的元素都是队列中权值最小的。
        int[] factors={2, 3, 5};
        Set<Long> set=new HashSet<>();
        PriorityQueue<Long> pqueue=new PriorityQueue<>();
        set.add(1L);//此处是加入long类型的
        pqueue.offer(1L);
        int ugly=0;
        for(int i=0; i<n; i++){
            long curr=pqueue.poll();//注意这里不要写成引用类型Long了
            ugly= (int) curr;
            for(Integer fac:factors){
                long next=curr*fac;//存入的是long类型的，应该用实际拿出的long类型乘以factor
                if(set.add(next)){//如果集合中没有出现过该元素，再加入优先队列中
                    pqueue.offer(next);
                }
            }
        }
        return ugly;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
