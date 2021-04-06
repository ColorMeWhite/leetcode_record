//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 534 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi{
      public static void main(String[] args) {
           Solution solution = new SubsetsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //1二进制迭代法，但由于数字有重复的，所以有所改动
        //需要先将数组排序，再在每次判断重复的数字有没有已经循环过一次了
        List<List<Integer>> res =new ArrayList<>();
        //以nums.length=3为例，供循环000/001/010/011/100/101/110/111八次
        Arrays.sort(nums);
        for(int i=0; i<(1<<nums.length); i++){
            List<Integer> list=new ArrayList<>();
            //对于010从低位开始判断每一位是否是1
            boolean flag=true;//用于判断当前是否是重复的
            for(int j=0; j<nums.length; j++){
                if(((i>>j)&1)==1){//等于1、
                    //对于[1,2,2]的情况，001和010对应的子集都是[2],而且，001和010一般都是一个2在一个2不在的情况
                    //所以通过判断nums[j]==nums[j-1]可以判断是不是数字重复的情况，i>>(j-1)&1)==0判断是不是一个在一个不在的情况
                    //此外涉及到nums[j-1]所以要判断j>0才不会越界
                    if(j>0&&((i>>(j-1)&1)==0)&&nums[j]==nums[j-1]){
                        flag=false;
                        break;
                    }
                    list.add(nums[j]);
                }
            }
            if(flag)res.add(list);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }