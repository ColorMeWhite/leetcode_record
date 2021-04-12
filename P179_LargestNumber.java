//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,2]
//输出："210"
//
// 示例 2：
//
//
//输入：nums = [3,30,34,5,9]
//输出："9534330"
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出："1"
//
//
// 示例 4：
//
//
//输入：nums = [10]
//输出："10"
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics 排序
// 👍 590 👎 0


  package com.zxf.leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber{
      public static void main(String[] args) {
           Solution solution = new LargestNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        //使用排序法，不过排序的重点在于比较两个数a和b,是ab更大还是ba更大，如果ab更大，那么a要排在b之前
//        String res="";
//        //1手写快排
//        quick_sort(nums, 0, nums.length-1);
//        if(nums[0]<=0)return "0";
//        for(int i=0; i<nums.length; i++){
//            res+=String.valueOf(nums[i]);
//        }
//        return res;

        //2使用comparator，重写compare
        //重点，要把数据类型转换成包装类才能传入comparator对象
        Integer[] numsInt=new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            numsInt[i]=nums[i];
        }
        Arrays.sort(numsInt, (a, b)->{
            long p=10;
            long q=10;
            //计算a是几位数
            while(p<=a){
                p=p*10;
            }
            //计算b是几位数
            while(q<=b){
                q=q*10;
            }
            return (int)(p*b+a-q*a-b);
            //鉴于原来是比较a和b的大小，若a>b,则返回正数，若a<b则返回负数，是按从小到大排列的
            //这里改变之后是比较ab和ba,若ab>ba,则a应该放在b之前，那么应该返回负数；若a应该放在b后面，则应返回正数。
            //此处不仅改变了比较大小的方式，同时改变了排列方式，改成由大到小排列的。
        });
        if(numsInt[0]==0)return "0";
        StringBuilder res=new StringBuilder();
        for(int i=0; i<nums.length; i++){
            res.append(numsInt[i]);
        }
        return res.toString();
    }

    public void quick_sort(int[] nums, int start, int end){
        if(start>=end)return;//重要！防止越界
        long p=10;
        long q=10;
        int mid=nums[end];//将最后一个数作为比较节点
        while(p<=mid){//计算mid是几位数
            p=p*10;
        }
        int index=start;//记录比mid大的元素的下标
        for(int i=start; i<end; i++){
            q=10;
            while(q<=nums[i]){//计算nums[i]是几位数
                q=q*10;
            }
            if(nums[i]*p+mid>mid*q+nums[i]){//将比mid“大”的元素放在前半部分
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index, end);//将 mid放在该在的位置
        quick_sort(nums, start, index-1);//递归排序
        quick_sort(nums, index+1, end);//递归排序
    }
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
