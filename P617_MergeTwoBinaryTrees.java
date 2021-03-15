//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 636 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees{
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
           Solution solution = new MergeTwoBinaryTrees().new Solution();
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
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {//1递归法，深度优先
//        if(root1==null)return root2;
//        if(root2==null)return root1;
//        TreeNode node=new TreeNode(root1.val+root2.val);//**重要！需要创建新的节点！
//        node.left=mergeTrees(root1.left, root2.left);
//        node.right=mergeTrees(root1.right, root2.right);
//        return node;
//    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {//2迭代法，层序遍历，需要用到队列
        //层序遍历，只要队列不为空，则循环，判断每一个节点对应两者是否为空。
        //都不为空，则需要创建新的节点，并更新值。
        //其中一个为空，合并后为另一个。
        if(root1==null)return root2;
        if(root2==null)return root1;
        TreeNode node=new TreeNode(root1.val+root2.val);//**重要！需要创建新的节点！
        Queue<TreeNode> queue=new LinkedList<>();//存储合并后的二叉树
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue.offer(node);
        queue1.offer(root1);
        queue2.offer(root2);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode mainnode=queue.poll(), node1=queue1.poll(), node2=queue2.poll();
            TreeNode left1=node1.left, right1=node1.right, left2=node2.left, right2=node2.right;
            if(left1!=null||left2!=null){
                if(left1!=null&&left2!=null){
                    TreeNode left=new TreeNode(left1.val+left2.val);
                    mainnode.left=left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                }
                else if(left1!=null){
                    mainnode.left=left1;//当其中一个左节点不存在的时候，合并的二叉树的对应节点直接等于另一个，不需要再迭代，所以不需要入队列
                }else if(left2!=null){
                    mainnode.left=left2;
                }
            }
            if(right1!=null||right2!=null){
                if(right1!=null&&right2!=null){
                    TreeNode right=new TreeNode(right1.val+right2.val);
                    mainnode.right=right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                }
                else if(right1!=null){//当其中一个右节点不存在的时候，合并的二叉树的对应节点直接等于另一个，不需要再迭代，所以不需要入队列
                    mainnode.right=right1;
                }else if(right2!=null){
                    mainnode.right=right2;
                }
            }

        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }