package com.eric.algorithm.question;

public class LongestPalindromic {
    public static void main(String[] args) {
        String test1 = "babad";
        String test2 = "cbbd";
        String test3 = "ac";
        String test4 = "bb";
        String test5 = "dsqspnkrvrhqzqvovbofdzqishgtcrvckluzpwesvartjhljqdphdupktoxdffvoqupuxmehikegjnwuheoafgqrtvuzphkikaixnjmhepeqorzjzgnrxxxirhjvboijbzftxhvtrdmbcvysxscvqmgifipwujvvktithqthujpxwwgamwqkxnnxiymtuvtyzafbxybalnjboaiyrxedviesmzzwgagilndguylskdikiocvqmjmfykakuiihuqurgqqirjoccqoixegyspftktguitqtixcsywycutcaedusndombnfzpgoklqzzqlkogpzfnbmodnsudeactucywyscxitqtiugtktfpsygexioqccojriqqgruquhiiukakyfmjmqvcoikidkslyugdnligagwzzmseivdexryiaobjnlabyxbfazytvutmyixnnxkqwmagwwxpjuhtqhtitkvvjuwpifigmqvcsxsyvcbmdrtvhxtfzbjiobvjhrixxxrngzjzroqepehmjnxiakikhpzuvtrqgfaoehuwnjgekihemxupuqovffdxotkpudhpdqjlhjtravsewpzulkcvrctghsiqzdfobvovqzqhrvrknpsqsd";
        String result = longestPalindrome2(test4);
        System.out.println(test3 + " ----> " + result);
    }

    /**
     * 最长回文子串 #5 Input: "babad" Output: "bab"
     *
     * 解法一 暴力解法，穷举每一个字符串，判断是否是回文
     */
    public static String longestPalindrome(String s) {
        if (s != null && s.length() <= 1) {
            return s;
        }
        StringBuilder container = new StringBuilder();
        int max = 0;
        int temp = 0;
        String currentResultStr = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                container.append(String.valueOf(c));
                if (isPalindrome(container.toString())) {
                    temp++;
                    if (max < temp) {
                        max = temp;
                        currentResultStr = container.toString();
                    }
                } else {
                    temp++;
                }
                if (j == s.length() - 1) {
                    temp = 0;
                    container.delete(0, container.length());
                }
            }
        }
        return currentResultStr;
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    /**
     * 解法二 使用动态规划解决，画表格找规律
     */
    public static String longestPalindrome2(String s) {

        int len = s.length();
        if (len < 2)
            return s;

        int maxLen = 1;
        int beginIndex = 0;

        boolean[][] an = new boolean[len][len];

        // 对角线处 设置为true 因为单个字符肯定都是回文
        for (int i = 0; i < len; i++) {
            an[i][i] = true;
        }
        // a[i][j] = a[i+1]a[j-1] && j-i < 3
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    an[i][j] = false;
                } else {
                    if (j - i < 3) {
                        an[i][j] = true;
                    } else {
                        an[i][j] = an[i + 1][j - 1];
                    }
                }
                if (maxLen < j - i + 1 && an[i][j]) {
                    maxLen = j - i + 1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }
}
