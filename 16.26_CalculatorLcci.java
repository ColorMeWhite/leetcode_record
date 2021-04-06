//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串 
// 👍 34 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class CalculatorLcci{
      public static void main(String[] args) {
           Solution solution = new CalculatorLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int n=s.length();
        Deque<Integer> stack=new LinkedList<>();
        int i=0;
        while(i<n){//遍历一遍字符串，每次读取到运算符则寻找下一个数字。如果只有数字，则入栈
            if(i<n&&s.charAt(i)==' '){
                i++;
                continue;
            }
            char temp=s.charAt(i);
            if(temp=='*'||temp=='/'||temp=='+'||temp=='-'){//如果是运算符则将寻找下一个数字
                i++;
                while(i<n&&s.charAt(i)==' ')i++;//运算符和数字之间可能会有 空格
            }//不是则简单将数字入栈
            int num=0;
            while(i<n&&Character.isDigit(s.charAt(i))){
                num=num*10+(int)(s.charAt(i)-'0');
                i++;
            }//记录数字，不一定是一位数
            switch(temp){//如果有运算符则计算了之后再入栈
                case '-'://-号将存入负数
                    num=-num;
                    break;
                case '*'://乘号将计算之后再入栈
                    num=stack.pop()*num;
                    break;
                case '/'://除号同样
                    num=stack.pop()/num;
                    break;
                default:
                    break;
            }
            stack.push(num);//如果当前只有数字，则不做什么就入栈
        }
        int res=0;
        while(!stack.isEmpty()){//最后将栈中的元素加起来就好了
            int temp=stack.pop();
            res+=temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }