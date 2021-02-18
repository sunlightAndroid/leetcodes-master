package com.eric.algorithm.learn.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    /**
     * 插入排序
     * 插入排序适用于，大部分数据是有序的了，通过插入排序使得最终有序
     * <p>
     * i指针向右 j指针向左
     */
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (Utils.less(nums, j, j - 1)) {
                    Utils.swap(nums, j, j - 1);
                }
            }
        }
        Utils.printArray(nums);
    }

    public static void main(String[] args) {
        InsertionSort Sort = new InsertionSort();
        int[] array = {5, 4, 3, 2, 1};
        Sort.sort(array);
    }
}
