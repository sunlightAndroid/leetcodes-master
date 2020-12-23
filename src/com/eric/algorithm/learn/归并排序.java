package com.eric.algorithm.learn;

public class 归并排序 {
    // 参考链接 https://blog.csdn.net/k_koris/article/details/80508543
    public int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    // 12345 奇数 mid 为3， 123456 偶数mid为4
    private int[] sort(int[] array, int left, int right) {
        if (left >= right) {
            int value = array[left];
            return new int[] { value };
        }
        int mid = (left + right) / 2;
        int[] array1 = sort(array, left, mid);
        int[] array2 = sort(array, mid + 1, right);
        return merge(array1, array2);
    }

    private int[] merge(int[] array1, int[] array2) {
        System.out.println(array1.toString() + "  " + array2.toString());
        int[] temp = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                temp[k] = array1[i];
                k++;
                i++;
            } else if (array1[i] >= array2[j]) {
                temp[k] = array2[j];
                k++;
                j++;
            }
        }
        if (i < array1.length) {
            for (int l = i; l < array1.length; l++) {
                temp[k++] = array1[l];
            }
        } else if (j < array2.length) {
            for (int l = j; l < array2.length; l++) {
                temp[k++] = array2[l];
            }
        }
        return temp;
    }
}
