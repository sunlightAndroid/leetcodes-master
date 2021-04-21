package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class leetcode00139 {

//    输入: s = "leetcode", wordDict = ["leet", "code"]
//    输出: true
//    解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

    // "bb"
    //["a","b","bbb","bbbb"]
    // true
    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            if(s.contains(wordDict.get(i))){
                s = s.replace(wordDict.get(i),"");
            }else {
                return false;
            }
        }
        return s.isEmpty();
    }


    public static void main(String[] args) {
        leetcode00139 solution = new leetcode00139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");
        boolean bb = solution.wordBreak("bb", wordDict);
        System.out.println(bb);
    }
}
