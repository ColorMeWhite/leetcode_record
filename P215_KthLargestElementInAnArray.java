//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 930 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray{
      public static void main(String[] args) {
           Solution solution = new KthLargestElementInAnArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //第K个最大的数

          /*
          //1快排法，递归，有改进
          //快排：分治的思想。
          // 分：计算下标 q 也是「划分」过程的一部分。
          // 选一个点nums[p],数组分为[1...p-1]和[p+1...n]两部分，其中[1...p-1]中的点都比nums[p]小，[p+1...n]中的点都比nums[p]大或等于。
          //合：因为子数组都是原址排序的，所以不需要进行合并操作，a[1⋯n] 已经有序.
          //改编：在分解的过程当中，我们会对子数组进行划分，如果划分得到的 q 正好就是我们需要的下标，就直接返回 a[q]；
          // 否则，如果 q 比目标下标小，就递归右子区间，否则递归左子区间。这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。
          Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quicksort(nums, 0, nums.length-1, nums.length-k);
    }
    //快排
    public int quicksort(int[] nums, int s, int e, int index){//int类型都是数组下标
        int q=randomPartition(nums, s, e);
        if(q==index)return nums[q];
        return q<index?quicksort(nums, q+1, e, index):quicksort(nums, s, q-1, index);
    }
    //交换数组中两个数的位置
    public void swap(int[] nums, int a, int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;
    }
    //负责将数组分为大于nums[q]和小于等于nums[q]两部分，其中nums[q]存放在该段数组最后一个位置
    public int partition(int[] nums, int s, int e){
        int x=nums[e];//记录对比对象nums[q]
        int low_index=s;//记录比nums[q]小的数组交换的下标
        for(int i=s; i<e; i++){
            if(nums[i]<=x)swap(nums, low_index++, i);
        }
        swap(nums,low_index, e);
        return low_index;
    }
    //选择随机的q,并分开数组
    public int randomPartition(int[] nums, int s, int e){
        int q=random.nextInt(e-s+1)+s;//随机一个[s...e]之间的数
        swap(nums, q, e);//将随机的nums[q]换到这一段数组的最后一个位置
        return partition(nums, s, e);

    }
           */
          //1堆排法
          //完全二叉树：如果一个二叉树与满二叉树前m个节点的结构相同，这样的二叉树被称为完全二叉树。完全二叉树适合使用顺序表存储
          // 先将数组构建成一个完全二叉树，然后将树调整为大顶堆
          // 求第k大的，则删除k-1次堆顶的元素，每删除一次，都将末尾节点放在堆顶，然后重新调整为大顶堆
          //调整为大顶堆的方法：将数组构建为完全二叉树将所有的非叶子节点调整为大顶堆，从最低的 非叶子节点开始
          //时间复杂度：O(nlogn)，建堆的时间代价是 O(n)，删除的总代价是 O(klogn)，因为 k<n，故渐进时间复杂为O(n+klogn)=O(nlogn)。
          //
          public int findKthLargest(int[] nums, int k) {
              int heapSize=nums.length;
              buildMaxHeap(nums, heapSize);//建初始大顶堆
              for(int i=nums.length-1; i>=nums.length-k+1; i--){
                  swap(nums, 0, i);//删除大顶堆的堆顶并将当前堆的最后一个节点放入堆顶，实质就是交换
                  maxHeapify(nums, 0, --heapSize);
              }
              return nums[0];
          }
          //建大顶堆
          public void buildMaxHeap(int[] nums, int heapSize){
              //对所有非叶子节点进行大顶堆的调整，从低的非叶子节点开始。
              for(int i=heapSize/2; i>=0; i--){
                  maxHeapify(nums, i, heapSize);
              }


          }
          //交换数组中的两个数
          public void swap(int[] nums, int a, int b){
              int t=nums[a];
              nums[a]=nums[b];
              nums[b]=t;
          }
          //将当前节点大顶堆化
          public void maxHeapify(int[] nums, int curr, int heapSize){
              int l=curr*2+1, r=curr*2+2, max=curr;//对于顺序存储的完全二叉树，非叶子节点curr的子节点若存在，则必定是2*curr+1和2*curr+2
              if(l<heapSize&&nums[l]>nums[max])max=l;
              if(r<heapSize&&nums[r]>nums[max])max=r;//判断三个点哪个点的数字最大，将当前节点与最大的那个交换
              if(max!=curr){
                  swap(nums, max, curr);
                  maxHeapify(nums, max, heapSize);//**重要！交换之后再进行下一层的大顶堆调整
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }