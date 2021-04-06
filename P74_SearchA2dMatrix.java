//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 378 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class SearchA2dMatrix{
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
//        //1两次二分查找
//        //先二分查找确定结果在某一行，然后再这一行进行二分查找
//        int row=matrix.length;
//        int column=matrix[0].length;
//        if(row==0&&column==0)return false;
//        int start=0, end=row-1, mid=0;
//        while(start<end){//确定所在的行
//            mid=(end-start+1)/2+start;
//            if(matrix[mid][0]==target)return true;
//            else if(matrix[mid][0]>target)end=mid-1;
//            else start=mid;
//        }
//        row=start;//记录该行
//        start=0;
//        end=column-1;
//        while(start<=end){//确定所在的列
//            mid=(end-start)/2+start;
//            if(matrix[row][mid]==target)return true;
//            else if(matrix[row][mid]>target)end=mid-1;
//            else start=mid+1;
//        }
//        return false;
        //2一次二分查找
        //衔接每一行
        int row=matrix.length, column=matrix[0].length;
        int start=0, end=row*column-1;
        while(start<=end){
            int mid=(end-start)/2+start;
            int x=mid/column, y=mid%column;//计算点的横纵坐标
            if(matrix[x][y]==target)return true;
            else if(matrix[x][y]<target)start=mid+1;
            else end=mid-1;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }