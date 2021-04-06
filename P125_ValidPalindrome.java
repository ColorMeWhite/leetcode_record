//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 351 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class ValidPalindrome{
      public static void main(String[] args) {
           Solution solution = new ValidPalindrome().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //双指针
        int n=s.length();
        int head=0;//头指针
        int tail=n-1;//尾指针
        while(head<tail){
            //每次比较要将tail和head指向数字或字母，而不是空格或者符号
            while(head<tail&&!Character.isLetterOrDigit(s.charAt(head)))head++;
            while(head<tail&&!Character.isLetterOrDigit(s.charAt(tail)))tail--;
            //有可能字符串里没有字母和数字，那么将不用比较
            if(head<tail){
                if(Character.toLowerCase(s.charAt(head))!=Character.toLowerCase(s.charAt(tail)))return false;
                head++;
                tail--;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }