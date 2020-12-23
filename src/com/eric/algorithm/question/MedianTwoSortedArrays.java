package com.eric.algorithm.question;

public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[] { 1, 2 };
        int[] num2 = new int[] { 3, 4 };
        double result = findMedianSortedArrays(num1, num2);
        System.out.println("结果是：" + result);
    }

    /**
     * nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =[1,2,3]
     * and median is 2.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 保证只有一种情况存在，就是右边是大数组，左边小数组
        if (nums1.length > nums2.length) {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // 确定分割线
        int m = nums1.length;
        int n = nums2.length;

        // 初始分割线位置 满足： i + j == (m + n + 1)/2
        // 第一个数组分割线 右边的第一个元素下标,也是分割线左边元素数量之和

        // 两个交叉数组的左边元素之和
        int leftTotal = (m + n + 1) / 2;

        int left = 0;
        int right = m; // 分割线只在第一个数组确定了，那么第二个数组必然就确定了 在区间[0,m]确定

        while (left < right) {
            // 二分查找
            int i = left + (right - left + 1) / 2; // 防止整型溢出 (left+right )/2
            int j = leftTotal - i;
            // 如果左边任意元素都比右边元素大，那么需要左移
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        // 找到了
        int i = left;
        int j = leftTotal - i;

        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int num2LeftMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 0) {
            System.out.println("左边最大值是：" + Math.max(num1LeftMax, num2LeftMax) + " num1LeftMax:" + num1LeftMax
                    + " num2LeftMax:" + num2LeftMax);

            System.out.println("右边最小值是：" + Math.min(num1RightMin, num2LeftMin) + " num1RightMin: " + num1RightMin
                    + " num2LeftMin:" + num2LeftMin);

            return (Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2LeftMin)) / 2.0f;
        } else {
            System.out.println("左边最大值是：" + Math.max(num1LeftMax, num2LeftMax));
            return Math.max(num1LeftMax, num2LeftMax);
        }
    }
}
