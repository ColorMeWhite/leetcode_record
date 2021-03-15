//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 784 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class InvertBinaryTree{
      public static class TreeNode{
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(){}
          TreeNode(int val){this.val=val;}
          TreeNode(int val, TreeNode left, TreeNode right){
              this.val=val;
              this.left=left;
              this.right=right;
          }
      }
      public static void main(String[] args) {
           Solution solution = new InvertBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //翻转二叉树
    //1递归，先翻转左右子树，再交换左右子树
    //时间复杂度：O(n),会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
    //空间复杂度：O(n),使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度,最坏情况下，树形成链状，空间复杂度为 O(N)。
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        TreeNode left=invertTree(root.left);//翻转左子树
        TreeNode right=invertTree(root.right);//翻转右子树
        root.left=right;//交换左右子树
        root.right=left;//交换左右子树
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }