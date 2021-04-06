//通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 *
// 3 * 2 * 1。 
//
// 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)
//和减法(-)。 
//
// 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我
//们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。 
//
// 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。 
//
// 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。 
//
// 
//
// 示例 1： 
//
// 输入：4
//输出：7
//解释：7 = 4 * 3 / 2 + 1
// 
//
// 示例 2： 
//
// 输入：10
//输出：12
//解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10000 
// -2^31 <= answer <= 2^31 - 1 （答案保证符合 32 位整数。） 
// 
// Related Topics 数学 
// 👍 99 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class ClumsyFactorial{
      public static void main(String[] args) {
           Solution solution = new ClumsyFactorial().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int clumsy(int N) {
        //1使用栈模拟的思想
        //对于非加号的情况，将计算后的数字存入栈中
//        if(N<=1)return N;
//        int res=0;//结果
//        int curr=N;//每组的和
//        for(int i=N-1; i>0; i--){
//            //每组计算到加号后面那个数字的时候结束,当前这组数字计算的结果加到结果中去。
//            int label=(N-i)%4;//计算的是距离N的距离模4
//            switch(label){
//                case 1:
//                    curr=curr*i;
//                    break;
//                case 2:
//                    curr=curr/i;
//                    break;
//                case 3:
//                    curr=curr+i;
//                    res+=curr;
//                    break;
//                case 0:
//                    //在减号处，将数字变为负数
//                    curr=-i;
//                    break;
//                default:
//                    break;
//            }
//        }
//        if(N%4!=0)res=res+curr;
//        return res;
        //2数学方法
        //N=9,res=9*8/7+6-5*4/3+2
        //观察一下，9*8/7=10,8*7/6=9,7*6/5=8...
        //N*(N-1)/(N-2)=(N^2-N)/(N-2)=(N^2-2N+N)/(N-2)=N+N/(N-2)=N+(N-2+2)/(N-2)=N+1+2/(N-2)
        //对于地板除法，2/(N-2)只有当2>=N-2的时候才有值，所以N<=4,所以N>4时，N*(N-1)/(N-2)=N+1
        //所以当N>4时,(N+1)-N*(N-1)/(N-2)=0:
        // N/4==0时，res=N*(N-1)/(N-2)...+8*7/6+5-4*3/2+1,由于5-4*3/2+1=0,所以res=N*(N-1)/(N-2)=N+1;
        // N/4==1时，res=N*(N-1)/(N-2)...+9*8/7+6-5*4/3+2-1，由于6-5*4/3+2-1=1，所以res=N+2;
        // N/4==2时，res=N*(N-1)/(N-2)...+10*9/8+7-6*5/4+3-2*1，由于7-6*5/4+3-2*1=1，所以res=N+2;
        // N/4==3时，res=N*(N-1)/(N-2)...+11*10/9+8-7*6/5+4-3*2/1，由于8-7*6/5+4-3*2/1，所以res=N+1-2=N-1;
        //当N<=4时，N=4，res=4*3/2+1=7; N=3,res=3*2/1=6; N=2, res=2*1=2; N=1时，res=1.
        int res=0;
        //当N不是4的倍数，就会有遗留的数字，1或1、2或1、2、3
        if(N<=4){
            switch(N){
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 6;
                case 4:
                    return 7;
                default:
                    break;
            }
        }else{
            switch(N%4){
                case 0:
                    res=N+1;
                    break;
                case 1:
                    res=N+2;
                    break;
                case 2:
                    res=N+2;
                    break;
                case 3:
                    res=N-1;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }