//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 528 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        BinaryTreePreorderTraversal.TreeNode node1 = new BinaryTreePreorderTraversal.TreeNode(1);
        BinaryTreePreorderTraversal.TreeNode node2 = new BinaryTreePreorderTraversal.TreeNode(2);
        BinaryTreePreorderTraversal.TreeNode node3 = new BinaryTreePreorderTraversal.TreeNode(3);
        //BinaryTreePreorderTraversal.TreeNode node5 = new BinaryTreePreorderTraversal.TreeNode(4);
//        ListNode node5 = new ListNode(5);

//        node5.next = null;
//        node4.next = null;
        node2.left = node3;
        node1.right = node2;
        node1.left = null;

        List<Integer> ans = solution.preorderTraversal(node1);
        System.out.println("前序遍历后的结果为：");
        System.out.println("[");
        for(Integer i : ans){
            System.out.println(i+" ");
        }
        System.out.println("]");
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
        //前序遍历，中左右

        /*
        //1递归法
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> lint=new LinkedList<>();

            preorder(root, lint);

            return lint;
        }
        public void preorder(TreeNode root, List<Integer> lint){
            if(root==null)return;
            lint.add(root.val);
            preorder(root.left, lint);
            preorder(root.right, lint);
        }*/

        /*
        //2迭代法。非递归法，使用栈,栈优先使用Deque。当栈使用--用push（），pop（）
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> lint=new LinkedList<>();

            Deque<TreeNode> stack = new LinkedList<>();//Deque模拟Stack，不用Stack的原因是{首次创建堆栈时，它不包含任何项目。Deque接口及其实现提供了更完整和一致的LIFO堆栈操作集，应优先使用此类}
            TreeNode node=root;
            while(!stack.isEmpty()||node!=null){
                while(node!=null){//前序遍历，一定要保证左边的所有都先入栈。
                    lint.add(node.val);
                    stack.push(node);
                    node=node.left;
                }
                node=stack.pop();
                node=node.right;
            }

            return lint;
        }*/
        //3Morris 遍历法。非递归法,再说吧打扰了。
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> lint=new LinkedList<>();

            Deque<TreeNode> stack = new LinkedList<>();//Deque模拟Stack，不用Stack的原因是{首次创建堆栈时，它不包含任何项目。Deque接口及其实现提供了更完整和一致的LIFO堆栈操作集，应优先使用此类}
            TreeNode node=root;
            while(!stack.isEmpty()||node!=null){
                while(node!=null){//前序遍历，一定要保证左边的所有都先入栈。
                    lint.add(node.val);
                    stack.push(node);
                    node=node.left;
                }
                node=stack.pop();
                node=node.right;
            }

            return lint;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }