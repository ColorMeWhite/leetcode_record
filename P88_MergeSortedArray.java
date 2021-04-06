//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 859 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new MergeSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //双指针
        //首先将nums1中的m个数移动到倒数m位置上，防止被覆盖
        for(int i=m+n-1; i>=n; i--){
            nums1[i]=nums1[i-n];
        }
        int i=n;//标记nums1比较到哪一步了
        int j=0;//标记nums2比较到哪一步了
        int index=0;//标记应该插入的位置
        while(i<m+n&&j<n){
            if(nums1[i]<nums2[j])nums1[index++]=nums1[i++];
            else nums1[index++]=nums2[j++];
        }
        while(j<n)nums1[index++]=nums2[j++];//如果nums2还有剩余，则按序列加入nums1中
        while(i<m+n)nums1[index++]=nums1[i++];//如果nums1还有剩余，则按序加入nums1中
    }
    //或者也可以 使用逆向双指针，即从最大的开始比较，这样就不用先移动nums1的元素了。
}
//leetcode submit region end(Prohibit modification and deletion)

  }