//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
//化后可能得到：
//
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
// 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
//
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
// 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
//
//
// 示例 3：
//
//
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums 中的所有整数 互不相同
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
// Related Topics 数组 二分查找
// 👍 441 👎 0


  package com.zxf.leetcode.editor.cn;
  public class FindMinimumInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        //二分查找。同样是通过判断mid和right的大小来判断最小值应当在哪一段
//        int left=0, right=nums.length-1;
//        if(nums.length<2)return nums[0];
//        while(left<=right){
//            int mid=(left+right)/2;
//            System.out.println(nums[mid]);
//            if(mid==0&&nums[mid]<nums[mid+1]&&nums[mid]<nums[nums.length-1])return nums[mid];//最小值是第一个
//            if((mid==nums.length-1)&&nums[mid]<nums[0]&&nums[mid]<nums[mid-1])return nums[mid];//最小值是最后一个
//            if(mid>0&&(mid<nums.length-1)&&nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1])return nums[mid];//最小值在中间
//            if(nums[mid]<nums[right]){//注意要比较mid和right，这样舍弃的时候才不会舍弃最小值。
//                right=mid;// 数据在一定范围内总是递增的，所以如果比较mid和left那么将有可能对于1234567就会舍弃左边部分，会舍弃掉最小值
//            }else{
//                left=mid+1;
//            }
//        }
//        return nums[left];
        //优化
        int left=0, right =nums.length-1;
        while(left<right){//在循环结束的时候left=right处就是最小值
            int mid=(left+right)/2;
            if(nums[mid]<nums[right])right=mid;
            else left=mid+1;
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
