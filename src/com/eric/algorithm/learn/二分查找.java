package com.eric.algorithm.learn;

public class 二分查找 {

    public static void main(String[] args) {

        int[] array = new int[] { 1, 2, 3, 4, 5 };
        int value = 16;

        find(array, value);
    }

    private static void find(int[] array, int value) {
        int step = 0;
        int low = 0;
        int high = array.length - 1;
        int middle = (low + high) / 2;

        while (low < high) {
            int middleNum = array[middle];
            if (value > middleNum) {
                step++;
                low = middle;
                middle = (low + high + 1) / 2;
            } else if (value < middleNum) {
                step++;
                high = middle;
                middle = (low + high ) / 2;
            } else {
                System.out.println("找到了 " + middle +"  需要：" + step + " 步");
                break;
            }
        }
        System.out.println("没找到"+value );
    }
}
