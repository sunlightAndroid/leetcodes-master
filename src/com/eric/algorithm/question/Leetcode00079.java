package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode00079 {

    private boolean exist = false;

    // TODO: 2021/2/22  待实现 
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> cur_ij = new ArrayList<>();
        cur_ij.add("0,0");
        backtrack(board, "", word, visited, cur_ij);
        return exist;
    }

    private void backtrack(char[][] board, String cur, String target, boolean[][] visited, List<String> cur_ij) {
        System.out.println(cur);
        if (cur.length() > target.length()) return;
        if (cur.equals(target)) {
            exist = true;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist) break;
                if (visited[i][j]) continue;
                String ij = cur_ij.get(cur_ij.size() - 1);
                String[] split = ij.split(",");
                if (!((Integer.parseInt(split[0]) == i && Math.abs(Integer.parseInt(split[1]) - j) == 1)
                        || (Integer.parseInt(split[1]) == j && Math.abs(Integer.parseInt(split[0]) - i) == 1)))
                    continue;
                cur += board[i][j];
                cur_ij.add(i + "," + j);

                visited[i][j] = true;
                backtrack(board, cur, target, visited, cur_ij);
                // 撤销选择
                cur = cur.substring(0, cur.length() - 1);
                cur_ij.remove(cur_ij.size() - 1);
                visited[i][j] = false;
            }
        }
    }


    public static class Test {
        public static void main(String[] args) {
            Leetcode00079 solution = new Leetcode00079();
            char[][] board = {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };

            String world = "ABCCED";
            String world1 = "SEE";
            String world2 = "ABCB";

            char[][] board1 = {
                    {'A', 'B'},
                    {'C', 'D'}
            };
            String world3 = "ABCD";
            String world4 = "ACDB";
            boolean exist = solution.exist(board, world1);
            System.out.println(exist);
        }
    }
}
