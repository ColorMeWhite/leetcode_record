//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明： 
//
// 为什么返回数值是整数，但输出的答案是数组呢？ 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的
//元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
// Related Topics 数组 双指针 
// 👍 423 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class RemoveDuplicatesFromSortedArrayIi{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
//        int res=0;//指向实际的位置
//        //双指针，一个指针遍历数组，一个数组用来指向删除数组中元素后元素实际的长度
//        int index=0;//用来遍历数组
//        if(nums.length<2)return nums.length;
//        int curr=nums[0];
//        int count=1;//记录每个数字的个数
//        for(index=1; index<nums.length; index++){
//            if(nums[index]==curr)count++;//如果是一样的数字则记录数字个数
//            else{//如果是新的数字，则先将上一个数字处理成不大于两个的，然后记录新的数字并更新个数
//                if(count>=2){
//                    nums[res]=curr;
//                    nums[res+1]=curr;
//                    res=res+2;
//                }
//                else{
//                    nums[res]=curr;
//                    res=res+1;
//                }
//                curr=nums[index];
//                count=1;
//            }
//        }
//        //收尾，最后一个数字的累积。
//        if(count>=2){
//            nums[res]=curr;
//            nums[res+1]=curr;
//            res=res+2;
//        }
//        else{
//            nums[res]=curr;
//            res=res+1;
//        }
//        return res;
        //双指针优化
        int n=nums.length;
        if(n<=2)return n;//长度小于等于2，无需删除
        int slow=2, fast=2;
        while(fast<n){
            //遍历的时候只需要关注当前数字是否已经在处理过的数组中出现了两次，若没有直接放入数组 ，若有则不操作 ，继续下一个数字
            //因为即将要插入在slow位置处，通过比较是否与slow-2位置上的数字相同即可判断是否插入超过两个
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }