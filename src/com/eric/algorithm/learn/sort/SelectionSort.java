package com.eric.algorithm.learn.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    /**
     * 选择排序跟冒泡排序很相似，目的也是每一趟 把最值找到，然后放在对应位置
     * 不同的时候，选择排序在比较过程中，不着急交换位置，而是j遍历完了，再把最小值与当前i的交换元素的值
     */
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (Utils.less(nums, j, minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.swap(nums, i, minIndex);
            }
        }
        Utils.printArray(nums);
    }

    public static void main(String[] args) {
        SelectionSort Sort = new SelectionSort();
        int[] array = {5, 4, 3, 2, 1};
        Sort.sort(array);
    }
}
