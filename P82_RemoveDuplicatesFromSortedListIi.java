//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 542 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class RemoveDuplicatesFromSortedListIi{
      public class ListNode{
          int val;
          ListNode next;
          ListNode(){}
          ListNode(int val){this.val=val;}
          ListNode(int val, ListNode next){
              this.val=val;
              this.next=next;
          }
      }
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummynode=new ListNode(0,head);
        ListNode res=dummynode;//虚拟头节点
        while(res.next!=null&&res.next.next!=null){
            int num=res.next.val;
            if(res.next.val==res.next.next.val){//遇见相同值的节点，则记录该值，并删除链表中所有等于该值的节点
                while(res.next!=null&&res.next.val==num){//**这里一定要判空，有可能删节点会删到尽头
                    res.next=res.next.next;
                }
            }
            else res=res.next;//如果接下来两个不行同才移动指针
        }
        return dummynode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }