//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 421 👎 0

  
  package com.zxf.leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTreeRightSideView{
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
           Solution solution = new BinaryTreeRightSideView().new Solution();
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
    /*
    //1深度优先搜索,非递归
    //时间复杂度，O(n),深度优先搜索最多访问每个结点一次
    //空间复杂度，O(n),最坏情况下，栈内会包含接近树高度的结点数量，占用 O(n) 的空间
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new LinkedList<>();

        Map<Integer, Integer> right_first = new HashMap<>();
        int max_depth=-1;
        Deque<TreeNode> nodestack = new LinkedList<>();//记录节点
        Deque<Integer> depthstack = new LinkedList<>();//记录每个节点对应的深度
        //输入根节点以及根节点的深度
        nodestack.push(root);
        depthstack.push(0);

        while(!nodestack.isEmpty()){
            TreeNode node=nodestack.pop();
            int depth=depthstack.pop();
            if(node!=null){//防止空指针
                if(max_depth<depth){
                    max_depth=depth;//记录最大深度
                }
                if(!right_first.containsKey(depth)){//如果不存在对应深度的节点才插入到hashmap
                    right_first.put(depth,node.val);
                }
                nodestack.push(node.left);//模拟栈，后进先出,使用push，pop
                nodestack.push(node.right);
                depthstack.push(depth+1);
                depthstack.push(depth+1);
            }
        }
        for(int i=0; i<=max_depth; i++){//因为把根节点当0层
            res.add(right_first.get(i));
        }

        return res;
    }
     */
    /*
    //2深度优先搜索,递归, 中序遍历一般是中左右，此时为了每一层最先访问最右的元素，采用中右左。
    List<Integer> res=new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {

        dfs(root, res, 0);

        return res;
    }
    public void dfs(TreeNode root, List<Integer> res, int depth){
        if(root==null)return;
        if(depth==res.size())res.add(root.val);
        dfs(root.right, res, depth+1);//为了最先访问每一层的最右的元素
        dfs(root.left, res, depth+1);
    }
     */
    //3广度度优先搜索
    //时间复杂度：O(n),每个节点最多进队列一次，出队列一次
    //空间复杂度：O(n),每个节点最多进队列一次，所以队列长度最大不不超过 n
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if(root==null)return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){//每一次循环栈中存放的是当前层的所有元素
            int level=queue.size();
            for(int i=0; i<level; i++){
                TreeNode node=queue.poll();
                if(i==0)res.add(node.val);//每一层都是从右到左存的，所以输出将每一层第一个放入列表
                if(node.right!=null)queue.offer(node.right);//从右到左存
                if(node.left!=null)queue.offer(node.left);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }