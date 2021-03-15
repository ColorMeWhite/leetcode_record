//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 622 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class BalancedBinaryTree{
      public static class TreeNode{
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode (){}
          TreeNode(int val){this.val=val;}
          TreeNode(int val, TreeNode left, TreeNode right){
              this.val=val;
              this.left=left;
              this.right=right;
          }
      }
      public static void main(String[] args) {
           Solution solution = new BalancedBinaryTree().new Solution();
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
    //定义：二叉树的每个节点的左右子树的高度差的绝对值不超过 1，则二叉树是平衡二叉树
    /*
    //1.自顶向下的递归
    //时间复杂度是O(n2),最坏的情况：二叉树是满二叉树，需要遍历二叉树中的所有节点，时间复杂度是 O(n)。
    //对于节点 p，如果它的高度是 d，则 height(p) 最多会被调用 d 次.
    //最坏的情况，二叉树形成链式结构，高度为 O(n)，此时总时间复杂度为 O(n2）
    //一般情况下，二叉树的高度是logn，此时总时间复杂度为O(nlogn)
    //空间复杂度是 O(n),空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        //当根节点左右子树高度差不超过1，且左右子树都是平衡二叉树时，该树是平衡二叉树
        else return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int height(TreeNode root){//求节点的深度
        if(root==null)return 0;
        else return Math.max(height(root.left), height(root.right))+1;
    }
     */
    //2.自底向上的递归
    //时间复杂度O(n):每个节点的计算高度和判断是否平衡都只需要处理一次，最坏情况下需要遍历二叉树中的所有节点，因此时间复杂度是 O(n)。
    //空间复杂度O(n):空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
    //自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡.
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;//当为不平衡二叉树的时候会返回-1
    }
    public int height(TreeNode root){//求节点的深度
        if(root==null)return 0;
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        if(rightheight==-1||leftheight==-1||Math.abs(leftheight-rightheight)>1)return -1;//若当前节点不是平衡二叉树则返回-1
        else return Math.max(leftheight, rightheight)+1;//否则返回树的高度
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }