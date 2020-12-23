package com.eric.algorithm.learn;

public class 插入排序 {

    public static void main(String[] args) {
        Comparable[] a = {8, 2, 4, 5, 6, 7};
        sort(a);
    }

    /**
     * 注意：
     * 插入排序不会访问索引右侧的元素，
     * 而选择排序不会 访问索引左侧的元素
     */

    /**
     * 插入排序，双指针i j移动，第i趟 通过移动指针j，将i左边的元素都变成有序的
     * <p>
     * 插入排序适用于，大部分数据是有序的了，通过插入排序使得最终有序
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
        print(a);
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void print(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
