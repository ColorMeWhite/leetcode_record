//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3070 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //三数之和，
          //快慢指针
          //时间复杂度：O(n2),除最外层指针外，second和third相当于双指针只遍历数组一次，故是O(n2)
          //空间复杂度：O(logN),排序所用
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<3)return res;
        //Arrays.sort(nums);
        //quickSort(nums, 0, nums.length-1);
        heapSort(nums);
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
        for(int first=0; first<nums.length-2; first++){
            //将third初始化放在这里是因为当first固定不变的时候，一次second的循环结束时，second++，则nums[second]++
            //此时符合条件的组合，智能出现在比当前nums[third]更小的地方，不需要再重新从nums[nums.length-1]的地方开始遍历
            int third=nums.length-1;
            if(first>0&&nums[first]==nums[first-1])continue;//避免重复
            for(int second=first+1; second<nums.length-1; second++){
                if(second==(first+1)||nums[second]!=nums[second-1]){//避免重复
                    //first和second固定不变，移动third
                    while(nums[first]+nums[second]+nums[third]>0&&third>second){
                        third--;
                    }
                    if(third>second&&(nums[first]+nums[second]+nums[third])==0){
                        List<Integer> group=new LinkedList<>();
                        group.add(nums[first]);
                        group.add(nums[second]);
                        group.add(nums[third]);
                        res.add(group);
                    }
                }
            }
        }
        return res;
    }
    /*
    //快排
    Random random=new Random();
    public void quickSort(int[] nums, int s, int e){
        if(s>=e)return;
        int q= random.nextInt(e-s+1)+s;
        swap(nums, q, e);
        q=partition(nums, s, e);
        quickSort(nums, s, q-1);
        quickSort(nums, q+1, e);
    }
    public void swap(int[] nums, int a, int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    public int partition(int[] nums, int s, int e){
        int qnum=nums[e];
        int leftindex=s;
        for(int i=s; i<e; i++){
            if(nums[i]<qnum)swap(nums, leftindex++, i);
        }
        swap(nums, leftindex, e);
        return leftindex;
    }
    */
    //堆排
    public void swap(int[] nums, int a, int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    public void maxHeapify(int[] nums, int curr, int end){
        int left=curr*2+1, right=curr*2+2, max=curr;
        if(left<end&&nums[left]>nums[max])max=left;
        if(right<end&&nums[right]>nums[max])max=right;
        if(max!=curr){
            swap(nums, max, curr);
            maxHeapify(nums, max, end);
        }
    }
    public void buildMinHeap(int[] nums){
        for(int i=nums.length/2; i>=0; i--){
            maxHeapify(nums, i, nums.length);
        }
    }
    public void heapSort(int[] nums){
        buildMinHeap(nums);
        int heapSize=nums.length;
        for(int i=nums.length-1; i>0; i--){
            swap(nums, 0, i);
            maxHeapify(nums, 0, --heapSize);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }