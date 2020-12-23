package com.eric.algorithm.learn;

public class 快速排序 {

    public static void main(String[] args) {
        int[] array = new int[] { 6, 5, 4, 3, 2, 1 };
        int[] array2 = new int[] { 6, 5, 3, 4, 3, 2, 1 };

        int[] array3 = new int[] { 10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19 };

        int[] array4 = new int[] { 4, 2, 3, 6, 5,8, 7, 1};

        int[] array5 = new int[] {4,2,3,6,5};

        int[] array6 = new int[] {5,3,6,4,1,2};


        quickSort2(array6);
        for (int i = 0; i < array6.length; i++) {
            System.out.print(array6[i] + "  ");
        }
    }

    /**
     * https://blog.csdn.net/shujuelin/article/details/82423852
     * 快速排序，也叫分而治之，先选出一个基准值，比他小的放左边，大的放右边，然后将左右两个数组排序 最终合起来就是有序的数组
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // temp就是基准位
        temp = arr[low];

        while (i < j) {
            // 先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            // 再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            // 如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;

            }
        }
        // 最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        // 递归调用左半数组
        quickSort(arr, low, j - 1);
        // 递归调用右半数组
        quickSort(arr, j + 1, high);

    }

    /**
     * 快速排序 解法二, i j同时从左边出发 i作为索引一直遍历数组查找，j作为小于标定点的数组最后一个元素下标
     * https://www.jianshu.com/p/a68f72278f8f
     */
    public static void quickSort2(int[] arr) {
        quickSort2(arr,0,arr.length-1);
    }

    public static void quickSort2(int[] arr, int  l, int r) {
        if(l >= r) return;
        int p = partition(arr,l,r);
        quickSort2(arr,l,p -1 );
        quickSort2(arr,p+1,r);
    }

    public static int partition(int[] arr, int l, int r) {
        int v = arr[l]; // 标定点
        int j = l;
        // i 索引
        for (int i = l+1; i <= r; i++) {
            if(arr[i] < v) {
                j++ ;
                swip(arr, i,j);
            }
        }
        // j 与 l的数据进行交换
        swip(arr, j,l);
        return j;
    }

    /**
     * 交换数组的两个数据
     */
    private static void swip(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
