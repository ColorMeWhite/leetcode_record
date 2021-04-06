//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 224 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class VolumeOfHistogramLcci{
      public static void main(String[] args) {
           Solution solution = new VolumeOfHistogramLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
//        //1动态规划
//        //维护一个leftmax数组和一个rightmax数组，分别记录包括每个点的左右的最大的高度，则当前点的蓄水量就是min[leftmax,rightmax]-height[i]
//        int res=0;
//        if(height.length<=1)return 0;
//        //初始化leftmax和rightmax
//        int[] leftmax=new int[height.length];
//        int[] rightmax=new int[height.length];
//        leftmax[0]=height[0];
//        rightmax[height.length-1]=height[height.length-1];
//        //初始化leftmax
//        for(int i=1; i<height.length; i++){
//            if(height[i]>leftmax[i-1])leftmax[i]=height[i];
//            else leftmax[i]=leftmax[i-1];
//        }
//        //初始化rightmax
//        for(int i=height.length-2; i>=0; i--){
//            if(height[i]>rightmax[i+1])rightmax[i]=height[i];
//            else rightmax[i]=rightmax[i+1];
//        }
//        //状态转移
//        for(int i=0; i<height.length; i++){
//            res+=Math.min(leftmax[i], rightmax[i])-height[i];
//        }
//        return res;
//        //2双指针-优化动态规划
//        //动态规划维护leftmax和rightmax数组，空间复杂度是O(n)
//        //注意到下标i处能接的水的量由leftMax[i]和rightMax[i]中的最小值决定。
//        //由于数组leftMax是从左往右计算,数组rightMax是从右往左计算，因此可以使用双指针和两个变量代替两个数组。
//        //这里使用双指针，在移动过程中维护变量leftmax和rightmax
//        //双指针初始化left=0和right=n-1,在left和right没有相遇的时候
//        //如果height[left]<heigth[right]那么必有leftmax<rightmax,此时可以计算left处的水量是leftmax-height[left],left右移
//        //如果height[left]>=height[right]那么必有leftmax>=rightmax,此时可以计算right处的水量是rightmax-height[right],right左移
//        //注意在left处leftmax就是整个数组中了left处的leftmax,right处的rightmax就是整个数组中right处的rightmax，所以才能得出上述结论
//        int res=0;
//        int left=0, right=height.length-1;
//        int leftmax=0, rightmax=0;
//        while(left<right){
//            if(leftmax<height[left])leftmax=height[left];
//            if(rightmax<height[right])rightmax=height[right];
//            if(height[left]<height[right])res+=leftmax-height[left++];
//            else res+=rightmax-height[right--];
//        }
//        return res;
        //3单调栈
        //维护一个单调栈，栈中存储的是元素的下标，栈中下标对应的元素从栈底到栈顶递减
        //当栈为空的时候，将当前元素加入栈；
        //当栈不为空的时候，比较栈顶指向的元素和height[i]的大小，当栈顶指向的元素小于height[i]的时候再进行如下操作：
        //  pop出栈顶元素记为top，如果栈为空，则跳出这一次
        //  如果栈不为空，记录栈中下一个元素为left，则必有height[left]>height[top],
        //  此时蓄水量为(i-left-1)*(min(height[i],height[left])-height[top]),
        //  left变为新的top, 继续计算，直到不符合(栈顶指向的元素小于height[i]的时候)
        int res=0;
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0; i<height.length; i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peekFirst()]){
                int top=stack.pop();
                if(stack.isEmpty())break;
                int left=stack.peekFirst();
                res+=(i-left-1)*(Math.min(height[i], height[left])-height[top]);
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }