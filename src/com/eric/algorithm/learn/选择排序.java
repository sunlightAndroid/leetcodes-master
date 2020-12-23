package com.eric.algorithm.learn;

public class 选择排序 {
    public static void main(String[] args) {
        int[] array = new int[] {6,5,4,3,2,1};
        int[] array2 = new int[] {6,5,3,4,3,2,1};
        sort(array2);
    }

    /**
     *  选择排序在于“选择”二字，每一轮都选出数组中剩余部分最小数字
     *  定义minIndex 在一轮结束后才去交换数据。时间复杂度 O(n2)
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if(minIndex !=i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

        // 打印一下最终排序结果
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
