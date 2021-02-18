package com.eric.algorithm.learn.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 5，4，3，2，1
     * 排序过程，两两比较，每一趟确定一个最大值
     * // 4 3 2 1 5
     * // 3 2 1 4 5
     * // 2 1 3 4 5
     * // 1 2 3 4 5
     * <p>
     * i指针扫描一次之后，最大的元素的位置就安排好了，为n-1.
     * 所以后面的j指针右区间也是逐渐减少的
     */
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (Utils.less(nums, j + 1, j)) {
                    Utils.swap(nums, j + 1, j);
                }
            }
        }
        Utils.printArray(nums);
    }

    /**
     * 递归函数 dfs，排序nums
     */
    public void dfs(int[] nums, int start, int end) {

    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {5, 4, 3, 2, 1};
        bubbleSort.sort(array);
    }
}
