package com.eric.algorithm.question;

import java.util.HashMap;
import java.util.Map;

public class Leetcode0070 {

    /**
     * 解法一： 使用暴力递归解法，超时了
     */
    int count = 0;
    public int climbStairs(int n) {
        dfs(n);
        return count;
    }
    public void dfs(int n) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            count++;
            return;
        }
        dfs(n - 1);
        dfs(n - 2);
    }


    /**
     * 解法二：仍然递归，可以这么理解：
     * 假如说，如果第一次跳了一个台阶 剩下n-1个台阶，那么方法数f(n-1);
     * 如果第一次跳了两个台阶 剩下n-2个台阶，那么方法数f(n-2);
     * 只能跳一个台阶或者两个台阶，所以呢，f（n） = f(n-1) + f(n-2);
     * <p>
     * 其实也就是斐波那契数列问题，可以对其进行优化，使用备忘录方式记录f(i)
     * 的结果，避免重复计算。
     */
    Map<Integer, Integer> hashtable = new HashMap<>();
    public int f(int n) {
        if (n <= 2) return n;
        if (!hashtable.containsKey(n - 1)) {
            hashtable.put(n - 1, f(n - 1));
        }
        if (!hashtable.containsKey(n - 2)) {
            hashtable.put(n - 2, f(n - 2));
        }
        return hashtable.get(n - 1) + hashtable.get(n - 2);
    }

    public int ff(int n) {
        if (n <= 2) return n;
        return ff(n-1) + ff(n - 2);
    }

    /**
     * 解法三： 动态规划
     */
    public int fun(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 解法三： 动态规划
     * 优化，明明只跟前两个数据有关系，为啥要开辟这么长的数组
     */
   public int fun2(int n) {
        if (n <= 2) return n;
        int beforeLast = 1;
        int last = 2;
        int current = -1;
        for (int i = 3; i <= n; i++) {
            current = beforeLast + last;
           beforeLast = last;
           last = current;
        }
        return current;
    }

    static class Test {
        public static void main(String[] args) {
            Leetcode0070 solution = new Leetcode0070();
            int result = solution.climbStairs(44);
//            int result = model.climbStairs(3);
            System.out.println(result);

            System.out.println("=======================");
            System.out.println(solution.f(44));
            System.out.println("=======================");
            System.out.println(solution.fun(44));
            System.out.println("=======================");
            System.out.println(solution.fun2(44));


        }
    }
}
