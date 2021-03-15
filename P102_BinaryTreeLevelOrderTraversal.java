//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 799 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
      public static class TreeNode{
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(){}
          TreeNode(int val) {this.val=val;}
          TreeNode(int val, TreeNode left, TreeNode right){
              this.val=val;
              this.left=left;
              this.right=right;
          }
    }
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
    //层序遍历
    //用队列Queue，先进先出，加元素是offer，删元素是poll
    //时间复杂度：每个节点遍历一次，故时间复杂度是O(n)
    //空间复杂度：队列中元素的个数不超过n个，故空间复杂度是O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levellist=new ArrayList<List<Integer>>();

        if(root==null)return levellist;//**判空很重要

        Queue<TreeNode> myq=new LinkedList<>();
        myq.offer(root);
        //每一层循环开始时，队列里是当前层的所有元素。
        while(!myq.isEmpty()){//遍历每一层
            List<Integer> onelevel = new LinkedList<>();
            int levelCount=myq.size();
            for(int i=0; i<levelCount; i++){//遍历当前层的节点
                TreeNode node = myq.poll();
                onelevel.add(node.val);
                if(node.left!=null)myq.offer(node.left);
                if(node.right!=null)myq.offer(node.right);
            }
            levellist.add(onelevel);
        }

        return levellist;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }