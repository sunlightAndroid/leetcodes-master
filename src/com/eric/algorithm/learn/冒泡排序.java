package com.eric.algorithm.learn;

public class 冒泡排序 {

    public static void main(String[] args) {
        int[] array = new int[] { 6, 5, 4, 3, 2, 1 };
        int[] array2 = new int[] { 6, 5, 3, 4, 3, 2, 1 };
        sort(array2);
    }

    /**
     * 6,5,4,3,2,1
     *
     * 第一轮 两两比较，左边的数据比右边的大就交换，第一轮结果如下，最大值就会确定好位置。以此类推，次大值的位置在第二轮确定好...
     *  5,6,4,3,2,1
     *  5,4,6,3,2,1
     *  5,4,3,6,2,1
     *  5,4,3,2,6,1
     *  5,4,3,2,1,6
     *
     *  时间复杂度O(n2)
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // 打印一下最终排序结果
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
