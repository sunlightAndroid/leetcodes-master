package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode00017 {
    private void dfs(int index, String digits,
                     HashMap<String, String> map, StringBuffer buffer, List<String> result) {
        if (index == digits.length()) {
            result.add(buffer.toString());
        }else {
            char currentNum = digits.charAt(index);
            String zhStr = map.get(String.valueOf(currentNum));
            for (int i = 0; i < zhStr.length(); i++) {
                char a = zhStr.charAt(i);
                buffer.append(a);
                dfs(index+1, digits, map, buffer, result);
                buffer.deleteCharAt(index);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<String, String> map = createMap();
        List<String> result = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        if (digits == null || digits.equals("")) {
            return result;
        }
        dfs(0, digits, map, buffer, result);
        return result;
    }

    private HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return map;
    }
}
class Test{
    public static void main(String[] args) {
        Leetcode00017 code = new Leetcode00017();
        String digits = "2";
        List<String> resultList = code.letterCombinations(digits);
        System.out.print(resultList.toString());
    }
}
