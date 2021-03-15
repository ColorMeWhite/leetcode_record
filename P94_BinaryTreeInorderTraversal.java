//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 877 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal{
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val){this.val=val;}
          TreeNode(int val, TreeNode left, TreeNode right){
              this.val=val;
              this.left=left;
              this.right=right;
          }
      }
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    //中序遍历，左中右
    /*
    //1递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lint=new LinkedList<>();

        inorder(root, lint);

        return lint;
    }
    public void inorder(TreeNode root, List<Integer> lint){
        if(root==null)return;
        inorder(root.left, lint);
        lint.add(root.val);
        inorder(root.right,lint);
    }*/
    //2迭代法，非递归用栈Deque，后进先出，当栈使用--用push（），pop()
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lint=new LinkedList<>();

        Deque<TreeNode> myq=new LinkedList<>();
        TreeNode node = root;
        while (!myq.isEmpty()||node!=null){
            while(node!=null){//当前节点的所有左边节点都进栈
                myq.push(node);
                node=node.left;
            }
            node=myq.pop();//最左节点
            lint.add(node.val);
            node=node.right;
        }

        return lint;
    }
    //3Mirrors方法，再说吧

}
//leetcode submit region end(Prohibit modification and deletion)

  }