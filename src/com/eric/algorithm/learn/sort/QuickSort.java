package com.eric.algorithm.learn.sort;

public class QuickSort {

    public void sort(int[] nums) {
        Utils.printArray(nums);
        sort(nums, 0, nums.length - 1);
        Utils.printArray(nums);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(nums, lo, hi);
        sort(nums, lo, p);
        sort(nums, p + 1, hi);
    }


    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];   // 标定点，假如就取第一位作为参考
        int i = lo;
        int j = hi;
        while (i < j) {
            while (i < j && nums[j] >= v) {
                j--;
            }
            while (i < j && nums[i] <= v) {
                i++;
            }
            if (i < j) {
                Utils.swap(nums, i, j);
            }
        }
        Utils.swap(nums, lo, j);
        return j;
    }


    public static void main(String[] args) {
//        int[] array = {2, 1, 3, 5, 4};
        int[] array = {3, 2, 4, 5, 1, 8, 7};
        QuickSort Sort = new QuickSort();
        Sort.sort(array);
    }

}
