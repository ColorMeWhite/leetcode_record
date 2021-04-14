//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 100] 内
// 0 <= Node.val <= 105
//
//
//
// Related Topics 树 深度优先搜索 递归
// 👍 131 👎 0


  package com.zxf.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDistanceBetweenBstNodes{
      public class TreeNode {
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
           Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
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
//    int res;
//    int pre;
//    public int minDiffInBST(TreeNode root) {
//        //寻找二叉搜索树的最小距离，由于二叉搜索树在中序遍历时时递增的，所以可以中序遍历并在遍历过程中比较相邻两个点的距离
//        res=Integer.MAX_VALUE;
//        pre=-1;
//        inOrder_BST(root);
//        return res;
//    }
//    public void inOrder_BST(TreeNode node){//递归法
//        if(node==null)return;
//        inOrder_BST(node.left);
//        if(pre==-1)pre=node.val;
//        else{
//            res=Math.min(res, node.val-pre);
//            pre=node.val;
//        }
//        inOrder_BST(node.right);
//    }
    public int minDiffInBST(TreeNode root) {
        //迭代法
        int res=Integer.MAX_VALUE;//记录结果
        int pre=-1;//记录上一个节点的值
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode node = root;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){//先让左边的节点都入栈
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();//然后逐个弹出
            //判断距离是否最小
            if(pre==-1)pre=node.val;
            else{
                res=Math.min(res, node.val-pre);
                pre=node.val;
            }
            //当前节点判断结束，转向其右子节点
            node=node.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
