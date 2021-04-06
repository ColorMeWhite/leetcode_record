//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1102 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //1二进制迭代法，因为 对于每个数字，只有在子集和不在子集里两种情况，所以靠二进制000、001、010...来判断
        List<List<Integer>> res=new ArrayList<>();
        //以n=3为例，i<二进制数1000即i<8,有8种情况：000,001,010,011,100,101,110,111
        for(int i=0; i<(1<<nums.length); i++){
            List<Integer> list=new ArrayList<>();//每次要清空
            //以n=3为例，对于三位二进制数分别进行移位操作，依次判断每一位是否是1，如果是1则在当前子集中
            for(int j=0; j<nums.length; j++){
                if(((i>>j)&1)==1)list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }