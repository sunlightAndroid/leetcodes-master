package com.eric.algorithm.learn.sort;

public class Utils {

    /**
     * 打印数组
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 交换数组 下标a与下标b的位置
     */
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     *  返回 位置a的元素 是否 小于位置b的元素
     */
    public static boolean less(int[] array, int a, int b) {
        return array[a] < array[b];
    }
}
