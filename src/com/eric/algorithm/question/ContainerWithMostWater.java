package com.eric.algorithm.question;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] h1 = new int[] { 4, 3, 2, 1, 4 };
        int[] h2 = new int[] { 1, 2, 4, 3 }; // 4
        int[] h3 = new int[] { 2,3,4,5,18,17,6 }; // 17

        int maxArea = maxArea(h3);
        System.out.println(maxArea);

    }

    /**
     * 盛更多的水 #11. Container With Most Water 1, 2, 4, 3
     */
    public static int maxArea(int[] height) {
        if (height.length < 2)
            return 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int lowH = height[leftIndex] < height[rightIndex] ? height[leftIndex] : height[rightIndex];
        int maxArea = lowH * (rightIndex - leftIndex);

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
                // 如果比上次的板子大 就计算面积
                if (height[leftIndex] > height[leftIndex - 1] ) {
                    int s =Math.min(height[leftIndex], height[rightIndex])  * (rightIndex - leftIndex);
                    if (maxArea < s)maxArea = s;

                }
            } else {
                rightIndex--;
                // 如果比上次的板子大 就计算面积
                if (height[rightIndex] > height[rightIndex + 1] ) {
                    int s = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
                    if (maxArea < s)maxArea = s;
                }
            }
        }
        return maxArea;
    }

    /**
     *   别人的解法
     */
    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i != j) {
            if (height[i] < height[j]) {
                max = height[i] * (j - i) > max ? height[i] * (j - i) : max;
                i++;
            }
            if (height[i] > height[j]) {
                max = height[j] * (j - i) > max ? height[j] * (j - i) : max;
                j--;
            }
        }
        return max;
    }
}
