package com.eric.algorithm.question;

public class AddTwoNumbers {

    public static void main(String[] args) {
//		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
//		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7)));
//		addTwoNumbers(l1, l2);


        System.out.print(sum("18", "0"));
    }

    public static String sum(String n1, String n2) {

        StringBuffer result = new StringBuffer();

        // 反转字符串
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();
        int maxLen = len1 > len2 ? len1 : len2;

        int c = 0;//进位
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                n2 += "0";
            }
        }

//			System.out.println(n1);
//			System.out.println(n2);

        for (int i = 0; i <maxLen; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) +"") + Integer.parseInt(n2.charAt(i) +"")+c;
            int ap = nSum%10;
            result.append(ap);
            c = nSum/10;


        }
        //最高位进位
        if(c>0) {
            result.append(c);
        }




        return result.reverse().toString();

//		// 12345678910929923 12345678910929924
//		String sumResultString = "";
//
//		char[] num1Array = num1.toCharArray();
//		char[] num2Array = num2.toCharArray();
//
//		int add = 0; // 是否进位
//		for (int i = num1Array.length - 1; i >= 0; i--) {
//			int value1 = (int) num1Array[i] - (int) ('0');
//			int value2 = (int) num2Array[i] - (int) ('0');
//
//			if (value1 + value2 > 9) {
//				int yu = (value1 + value2 + add) % 10;
//
//				sumResultString += yu;
//				add = 1;
//			} else {
//				sumResultString += value1 + value2 + add;
//				add = 0;
//			}
//		}
//
//		if(sumResultString.length() == 1) {
//			return add == 0 ?  new StringBuilder(sumResultString).toString()
//					: new StringBuilder(add + sumResultString).toString() ;
//		}
//
//		return add == 0 ?  new StringBuilder(sumResultString).reverse().toString()
//				: new StringBuilder(add + sumResultString).reverse().toString() ;
    }

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
     * 465 = 807.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();

        String a = "";
        String b = "";
        if (l1 != null && l2 != null) {
            a = a + l1.val;
            ListNode currentNode1 = l1.next;
            while (currentNode1 != null) {
                a = a + currentNode1.val;
                currentNode1 = currentNode1.next;
            }

            b = b + l2.val;
            ListNode currentNode2 = l2.next;
            while (currentNode2 != null) {
                b = b + currentNode2.val;
                currentNode2 = currentNode2.next;
            }
        }
        // 123 567
        String reverseA = new StringBuilder(a).reverse().toString();
        String reverseB = new StringBuilder(b).reverse().toString();

        // 321 + 765     = 18 60
        String sumInteger = sum(reverseA, reverseB);
        String result = new StringBuilder(String.valueOf(sumInteger)).reverse().toString();

        char[] resultArray = result.toCharArray();

        ListNode currentNode = resultNode;
        for (int i = 0; i < resultArray.length; i++) {
            int value = (int) resultArray[i] - (int) ('0');

            currentNode.val = value;
            if (i < resultArray.length - 1) {
                currentNode.next = new ListNode();
            } else {
                currentNode.next = null;
            }
            currentNode = currentNode.next;
        }

        return resultNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
