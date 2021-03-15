//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1225 👎 0

  
  package com.zxf.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.util.HashMap;
import java.util.Map;

public class LruCache{

      //leetcode submit region begin(Prohibit modification and deletion)
    //最近最少使用
    //1双向链表+hash表
    //时间复杂度：对于 put 和 get 都是 O(1)。
    //空间复杂度：O(capacity)，因为哈希表和双向链表最多存储capacity+1 个元素。
class LRUCache {
          private class BiLinkNode{
              int key;
              int val;
              BiLinkNode prev;//虚拟头结点
              BiLinkNode next;//虚拟尾结点
              BiLinkNode(){}
              BiLinkNode(int key, int val){this.key=key; this.val=val;}
          }
          private int capa;//缓存容量
          private int size;//当前节点个数
          private Map<Integer, BiLinkNode> cache = new HashMap<>();
          private BiLinkNode head;
          private BiLinkNode tail;

          //删除双向链表中的一个节点
          private void removeNode(BiLinkNode node){
              node.prev.next=node.next;
              node.next.prev=node.prev;
          }
          //删除双向链表中最后一个节点并返回该节点
          private BiLinkNode deleteTail(){
              BiLinkNode node=tail.prev;
              removeNode(node);
              return node;
          }
          //将一个新的节点添加至链表的表头
          private void addToHead(BiLinkNode node){
              node.next=head.next;
              head.next.prev=node;
              node.prev=head;
              head.next=node;
          }
          //讲一个链表中某一个节点移动至表头
          private void moveToHead(BiLinkNode node){
              node.prev.next=node.next;
              node.next.prev=node.prev;
              addToHead(node);
          }

    public LRUCache(int capacity) {//初始化一个缓存，不仅要初始化花村容量，还要初始化节点个数为0，同时初始化双向链表
        capa = capacity;
        size = 0;
        head = new BiLinkNode();
        tail = new BiLinkNode();
        head.prev=null;
        head.next=tail;
        tail.prev=head;
        tail.next=null;
    }

    //get操作，确认缓存中是否存在该<key,value>，不存在则返回-1，存在则将该节点移至表头并范围节点的value
    public int get(int key) {
        BiLinkNode node=cache.get(key);
        if(node==null)return -1;
        moveToHead(node);
        return node.val;
    }

    //put操作，先判断缓存中是否已经存在该键值对，如果存在，则先更新value再移至表头；
          //如果不存在，则先将节点加入表头和hash表，然后判断是否溢出，若溢出则删除链表尾部的节点，并从hash表中移除
    public void put(int key, int value) {
        BiLinkNode node=cache.get(key);
        if(node==null){
            BiLinkNode newnode=new BiLinkNode(key, value);
            cache.put(key, newnode);
            addToHead(newnode);
            size++;
            if(size>capa){
                BiLinkNode tail=deleteTail();
                cache.remove(tail.key);
            }
        }
        else{
            node.val=value;//**重要！先更新value值再移至表头
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }