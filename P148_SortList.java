//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1024 👎 0

  
  package com.zxf.leetcode.editor.cn;
  public class SortList{
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public static void main(String[] args) {
          Solution solution = new SortList().new Solution();
          ListNode node1 = new ListNode(4);
          ListNode node2 = new ListNode(2);
          ListNode node3 = new ListNode(1);
          ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(5);

//        node5.next = null;
          node4.next = null;
          node3.next = node4;
          node2.next = node3;
          node1.next = node2;

          ListNode ans = solution.sortList(node1);
          System.out.println("排序后的结果为：");
          System.out.println(ans.val);
          System.out.println(ans.next.val);
          System.out.println(ans.next.next.val);
          System.out.println(ans.next.next.next.val);
//        ListNode mid = findMid(node1);
//        System.out.println("中点为：" + mid.val);
      }      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        int n=1;
        ListNode temp=head;
        while(temp.next!=null){
            n++;
            temp=temp.next;
        }
        head=sort(head, temp, n);
        return head;
    }
    //分
    public ListNode sort(ListNode start, ListNode end, int length){
        if(length>1){
            ListNode rights=start, righte=start, lefts=start, lefte=end;
            for(int i=0; i<length/2; i++){
                righte=lefts;
                lefts=lefts.next;
            }
            rights=sort(rights, righte, length/2);
            lefts=sort(lefts, lefte, (length-(length/2)));
            righte.next=null;
            //lefte.next=null;
            return merge(rights, lefts);
        }
        return start;
    }
    //合并
    public ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null) {return l2;}
        else if (l2 == null) {return l1;}
        else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
 */
 class Solution {
    //自底向上归并
    //自底向上即将链表的每一个节点开始合并，先两个两个，在四个四个。。。
    //注意链表的断开
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        int n=0;//计数链表的总数.
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        ListNode virtualnode=new ListNode(0, head);//虚拟头结点
        for(int sublength=1; sublength<n; sublength*=2){//链表节点的个数决定了最外层循环的次数
            ListNode prev=virtualnode, curr=prev.next;
            while(curr!=null){//遍历一次链表

                //获取要合并的第一段
                ListNode head1=curr;
                for(int i=1; i<sublength&&curr.next!=null; i++){
                    curr=curr.next;
                }//循环结束curr指向第一段的最后一个节点
                ListNode head2=null;
                if(curr.next!=null)head2=curr.next;//判断第一段结束后是否有第二段存在
                curr.next=null;//断开第一段
                curr=head2;

                //获取要合并的第二段，若不存在，则head2是null
                for(int i=1; i<sublength&&curr!=null&&curr.next!=null; i++){
                    curr=curr.next;
                }//若第二段存在则循环结束curr指向第二段的最后一个节点

                ListNode next=null;
                if(curr!=null){//判断第二段是否存在，防止空指针
                    next=curr.next;
                    curr.next=null;//断开第二段
                }

                prev.next=merge(head1, head2);//合并
                while(prev.next!=null)prev=prev.next;//合并一次后将prev指向当前合并的最后一个节点
                curr=next;//继续遍历节点
            }
        }
        return virtualnode.next;
    }
    //合并
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode virtualnode = new ListNode(0);
        ListNode temp=virtualnode, temp1=l1, temp2=l2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null)temp.next=temp1;
        if(temp2!=null)temp.next=temp2;
        return virtualnode.next;
    }

 }


  }