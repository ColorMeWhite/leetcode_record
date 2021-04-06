//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。 
//
// 返回森林中兔子的最少数量。 
//
// 
//示例:
//输入: answers = [1, 1, 2]
//输出: 5
//解释:
//两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//设回答了 "2" 的兔子为蓝色。
//此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//输入: answers = [10, 10, 10]
//输出: 11
//
//输入: answers = []
//输出: 0
// 
//
// 说明: 
//
// 
// answers 的长度最大为1000。 
// answers[i] 是在 [0, 999] 范围内的整数。 
// 
// Related Topics 哈希表 数学 
// 👍 120 👎 0

  
  package com.zxf.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest{
      public static void main(String[] args) {
           Solution solution = new RabbitsInForest().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRabbits(int[] answers) {
        int res=0;

        //贪心思想
        //计算每个数字n相同的兔子的个数m，认为他们都是同一个颜色x
        //但实际情况是颜色为x的兔子个数为n+1,所以需要比较m和n+1的大小
        //如果m是n+1的倍数，那说明answers包含了所有兔子的情况，否则就只是包含了部分兔子的情况
        //包含所有兔子的情况，意味着所有数字为n的兔子
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<answers.length; i++){
            if(map.containsKey(answers[i]))map.put(answers[i], map.get(answers[i])+1);
            else map.put(answers[i], 1);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int count=entry.getValue();
            if(count%(key+1)==0)res+=(key+1)*(count/(key+1));
            else res+=(key+1)*(count/(key+1)+1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }