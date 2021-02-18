package com.eric.algorithm.learn.sort;

/**
 * 归并排序 第二个版本
 */
public class MergeSort2 {

    /**
     * 归并排序
     * 两个过程
     * 1.先分 再 2.合并
     */
    public void sort(int[] nums) {
        Utils.printArray(nums);
        sort(nums, 0, nums.length - 1);
        Utils.printArray(nums);
    }

    public void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int middle = (lo + hi) / 2;
        sort(nums, lo, middle);
        sort(nums, middle + 1, hi);
        merge(nums, lo, middle, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] copyA = new int[mid - lo + 1];
        int[] copyB = new int[hi - mid];
        int[] auxArray = new int[hi - lo + 1]; // 辅助数组，最后再复制到原数组nums中

        for (int i = lo; i <= mid; i++) {
            copyA[i - lo] = nums[i];
        }
        for (int i = mid + 1; i <= hi; i++) {
            copyB[i - mid - 1] = nums[i];
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < copyA.length && j < copyB.length) {
            if (copyA[i] < copyB[j]) {
                auxArray[k] = copyB[i];
                i++;
            } else {
                auxArray[k] = copyB[j];
                j++;
            }
            k++;
        }
        if (i < copyA.length) {
            while (i < copyA.length) {
                auxArray[k++] = copyA[i++];
            }
        }
        if (j < copyB.length) {
            while (j < copyB.length) {
                auxArray[k++] = copyB[j++];
            }
        }

        for (int l = 0; l < auxArray.length; l++) {
            nums[lo + l] = auxArray[l];
        }
    }


    public static void main(String[] args) {
        MergeSort2 Sort = new MergeSort2();
        int[] array = {5,4,3,2,1};
        Sort.sort(array);
    }
}
