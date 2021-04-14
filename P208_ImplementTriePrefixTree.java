//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。
//
// 请你实现 Trie 类：
//
//
// Trie() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。
//
//
//
//
// 示例：
//
//
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
//
//
//
//
// 提示：
//
//
// 1 <= word.length, prefix.length <= 2000
// word 和 prefix 仅由小写英文字母组成
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
//
// Related Topics 设计 字典树
// 👍 687 👎 0


  package com.zxf.leetcode.editor.cn;

import java.util.HashSet;

public class ImplementTriePrefixTree{
      public static void main(String[] args) {
           Trie solution = new ImplementTriePrefixTree().new Trie();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Trie {
//    //1字符串法，时间开销大
//    String res;
//    /** Initialize your data structure here. */
//    public Trie() {
//        res=",";//以，间隔每个字符串
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        res=res+word+",";
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        //扫描字符串
//        if(res.contains((","+word+",")))return true;
//        else return false;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        //扫描字符串
//        if(res.contains((","+prefix))) return true;
//        else return false;
//    }

//    //2二维数组构建字典树法，空间开销大，空间开销也大
//    //字典树：即从根节点开始的26叉树，子节点由每个字母构成。
//    //用二维数组构建字典树，需要提前估计字符串的长度，这里使用【100009】【26】的二维数组，并且，额外使用数组count[100009]记录当前层结束的个数
//    int N=100009;
//    int[][] tree;
//    int[] count;
//    int index;
//    /** Initialize your data structure here. */
//    public Trie() {
//        tree=new int[N][26];
//        count=new int[N];
//        index=0;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        int p=0;//记录当前索引到哪一层了
//        for(int i=0; i<word.length(); i++){
//            int u=word.charAt(i)-'a';
//            if(tree[p][u]==0)tree[p][u]=++index;
//            p=tree[p][u];
//        }
//        count[p]++;//在p层结束
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        int p=0;//记录当前索引到哪一层了
//        for(int i=0; i<word.length(); i++){
//            int u=word.charAt(i)-'a';
//            if(tree[p][u]==0)return false;//索引断了，则不存在该字符串
//            p=tree[p][u];
//        }
//        return count[p]!=0;//只有count[p]!=0才有字符串在p层结尾
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        int p=0;//记录当前索引到哪一层了
//        for(int i=0; i<prefix.length(); i++){
//            int u=prefix.charAt(i)-'a';
//            if(tree[p][u]==0)return false;//索引断了，则不存在该前缀
//            p=tree[p][u];
//        }
//        return true;//走完循环则存在该前缀
//    }

//    //3构建树节点构建字典树法，节省空间
//    //字典树：即从根节点开始的26叉树，子节点由每个字母构成。
//    //注意：树节点不存储值
//    private Trie[] tree;//子节点们
//    private boolean is_end;//是否是结束字符
//    /** Initialize your data structure here. */
//    public Trie() {
//        tree=new Trie[26];
//        is_end=false;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        //从第一个节点开始，可以看成是想象的
//        Trie node=this;
//        for(int i=0; i<word.length(); i++){
//            int u=word.charAt(i)-'a';
//            //如果当前节点的下一个字符还没有开辟，则开辟
//            if(node.tree[u]==null)node.tree[u]=new Trie();
//            //节点指针后移
//            node=node.tree[u];
//        }
//        //循环结束，当前节点指向的字符为结束字符
//        node.is_end=true;
//    }
//
////    /** Returns if the word is in the trie. */
////    public boolean search(String word) {
////        Trie node=this;
////        for(int i=0; i<word.length(); i++){
////            int u=word.charAt(i)-'a';
////            if(node.tree[u]==null)return false;
////            node=node.tree[u];
////        }
////        //字符全部匹配且最后一个字符为结束字符
////        return node.is_end;
////    }
////
////    /** Returns if there is any word in the trie that starts with the given prefix. */
////    public boolean startsWith(String prefix) {
////        Trie node=this;
////        for(int i=0; i<prefix.length(); i++){
////            int u=prefix.charAt(i)-'a';
////            if(node.tree[u]==null)return false;
////            node=node.tree[u];
////        }
////        return true;//字符全部匹配则存在该前缀
////    }
//
//      //优化一下：好像也没好到哪里去
//      public boolean search(String word) {
//          Trie cur = prefixSearch(word);
//          // 字符全部匹配，且最后一个字符为结束字符
//          return cur != null && cur.is_end;
//      }
//
//      public boolean startsWith(String prefix) {
//        // 字符全部匹配
//          return prefixSearch(prefix) != null;
//      }
//
//      // 方法抽取，复用重复代码
//      private Trie prefixSearch(String word) {
//          Trie cur = this;
//          int len = word.length();
//          for (int i = 0; i < len; i++) {
//              char ch = word.charAt(i);
//              // 如果当前节点的对应字符处尚未开辟，说明没有对应的word插入
//              if (cur.tree[ch-'a'] == null) return null;
//              cur = cur.tree[ch-'a'];
//          }
//          return cur;
//      }
    //4使用HashSet
    //一个前缀集合，一个字符串集合
    private HashSet<String> strset;
    private HashSet<String> prefixset;
    /** Initialize your data structure here. */
    public Trie() {
          strset=new HashSet<>();
          prefixset=new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(!strset.contains(word)){
            strset.add(word);
            for(int i=word.length()-1; i>=0; i--){
                if(!prefixset.contains(word.substring(0,i+1)))prefixset.add(word.substring(0,i+1));
            }
        }
    }

    public boolean search(String word) {
        if(strset.contains(word))return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
        if(prefixset.contains(prefix))return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }
