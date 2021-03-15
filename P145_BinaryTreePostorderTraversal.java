//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 537 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal{
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
           Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
    //后序遍历，左右中
    /*
    //1排序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lint=new LinkedList<>();

        postorder(root, lint);

        return lint;
    }
    public void postorder(TreeNode root, List<Integer> lint){
        if(root==null)return;
        postorder(root.left, lint);
        postorder(root.right, lint);
        lint.add(root.val);
    }*/
    //2迭代，非递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lint=new LinkedList<>();

        Deque<TreeNode> myq = new LinkedList<>();
        TreeNode node = root,prev=null;
        while(!myq.isEmpty()||node!=null){
            while(node!=null){//找到当前节点的最左的没有遍历过的节点
                myq.push(node);
                node=node.left;
            }
            node=myq.pop();
            if(node.right==null||node.right==prev){//如果当前节点没有右节点或者，当前节点的右节点已将被遍历了
                lint.add(node.val);
                prev=node;
                node=null;//**非常重要，当前节点值加入列表后，说明其左右节点已经遍历过了，要继续朝父节点遍历，所以要置空，不要再朝左右节点深入了
            }
            else{//当前节点有右节点，则将当前节点入栈，并将右节点变为当前节点
                myq.push(node);
                node=node.right;
            }
        }

        return lint;
    }
    //3Morris遍历，不会哎
}
//leetcode submit region end(Prohibit modification and deletion)

  }