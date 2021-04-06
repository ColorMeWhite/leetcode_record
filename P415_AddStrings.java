//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 330 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class AddStrings{
      public static void main(String[] args) {
           Solution solution = new AddStrings().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {//双指针，高位补0
        int index1=num1.length()-1, index2=num2.length()-1;
        String res="";
        int add=0;//进位
        while(index1>=0||index2>=0||add!=0){
            int i=index1>=0?num1.charAt(index1)-'0':0;//强制转换操作和补0
            int j=index2>=0?num2.charAt(index2)-'0':0;//强制转换操作和补0
            int sum=i+j+add;
            add=sum/10;
            sum=sum%10;
            res=Integer.toString(sum)+res;
            index1--;
            index2--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }