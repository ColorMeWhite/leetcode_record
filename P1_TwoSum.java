//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10482 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum{
      public static void main(String[] args) {
           Solution solution = new TwoSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /*
          //1枚举法
          //时间复杂度：O（n2)，最坏情况下是最后两个数
          //空间复杂度：O（1）
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]+nums[j]==target)return new int[]{i, j};
            }
        }

        return new int[0];
    }

           */
          //2哈希表
          //时间复杂度：O（n)，最坏情况下遍历数据
          //空间复杂度：O（n）
          public int[] twoSum(int[] nums, int target) {
              Map<Integer, Integer> resmap = new HashMap<>();
              for(int i=0; i<nums.length; i++){
                  if(resmap.containsKey(target-nums[i]))return new int[]{resmap.get(target-nums[i]), i};
                  resmap.put(nums[i], i);
              }

              return new int[0];
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }