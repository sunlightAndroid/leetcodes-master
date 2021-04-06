package com.eric.algorithm.question;

import java.util.*;

public class LeetcodeOffer0038 {

    private Set<String> ans = new HashSet<>();
    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        backtrack(new StringBuilder(), s.toCharArray(), visited);
        return ans.toArray(new String[]{});
    }


    private void backtrack(StringBuilder cur, char[] array, boolean[] visited) {
        if (cur.length() == array.length) {
            ans.add(cur.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) continue;
            cur.append(array[i]);
            visited[i] = true;
            backtrack(cur, array, visited);
            visited[i] = false;
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public String[] permutation2(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }

    public void dfs(char[] arr, String s, boolean[] visited, Set<String> list) {
        if (s.length() == arr.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(arr, s + String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }

    public static class Test {
        public static void main(String[] args) {
            LeetcodeOffer0038 solution = new LeetcodeOffer0038();
            String s = "aab";
            String[] permutation = solution.permutation(s);
            String[] permutation2 = solution.permutation2(s);
            System.out.println(Arrays.toString(permutation));
            System.out.println(Arrays.toString(permutation2));
        }
    }
}
