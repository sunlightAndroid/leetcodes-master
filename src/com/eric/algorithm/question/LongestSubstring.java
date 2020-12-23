package com.eric.algorithm.question;

public class LongestSubstring {
    public static void main(String[] args) {

//		 String string = "abcabcbb";
//		String string = "bbbbb";

//		 String string = " ";

//		 String string = "au";
//		String string = "pwwkew";
        String string = "dvdf";
//		String string = "jbpnbwwd" ;  // 4

        int resultString = lengthOfLongestSubstring(string);
        System.out.println(string + "---" + resultString);
    }

    /**
     * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
     * length of 3. dvdf
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int temp = 0;
        int index = 0;
        StringBuffer container = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (container.toString().contains(String.valueOf(character))) {
                if (max < temp) {
                    max = temp;
                }
                temp = 0;
                container.delete(0, container.length());
                index ++ ;
                i = index - 1;
            } else {
                container.append(character);
                temp++;
            }
        }

        max = max < temp ? temp : max;
        return max;
    }

}
