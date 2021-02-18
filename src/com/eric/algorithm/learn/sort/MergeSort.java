package com.eric.algorithm.learn.sort;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 归并排序
     * 两个过程
     * 1.先分 再 2.合并
     */
    public void sort(int[] nums) {
        Utils.printArray(sort(nums, 0, nums.length - 1));
    }

    public int[] sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return new int[]{nums[lo]};
        } else {
            int middle = (lo + hi) / 2;
            return merge(sort(nums, lo, middle), sort(nums, middle + 1, hi));
        }
    }

    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        if (i < a.length) {
            while (i < a.length) {
                result[k++] = a[i++];
            }
        }
        if (j < b.length) {
            while (j < b.length) {
                result[k++] = a[j++];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MergeSort Sort = new MergeSort();
        int[] array = {5, 4, 3, 2, 1};
        Sort.sort(array);
    }
}
