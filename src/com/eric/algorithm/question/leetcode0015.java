package com.eric.algorithm.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode0015 {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> resList = threeSum(nums);
        System.out.println(resList.toString());
    }

    /**
     * 15. 3Sum 3个数之和为0 [-1,0,1,2,-1,-4] ---> [[-1,-1,2],[-1,0,1]]
     *  解法1 时间复杂度为O(n3),会超时，主要是指针j k 同时从左边进行了
     */
    public static List<List<Integer>> threeSum1(int[] n) {
        int[] nums = quickSort(n, 0, n.length - 1);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return resultList;

        // -4 -1 -1 0 1 2
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = j + 1;
            while (j < nums.length - 1) {
                List<Integer> list = new ArrayList<Integer>();
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                }
                if (list.size() > 0) {
                    if (!resultList.contains(list))
                        resultList.add(list);
                }
                k++;
                if (k >= nums.length) {
                    j++;
                    k = j + 1;
                }
            }
        }
        return resultList;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length < 3)return resultList;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    j++; k--;
                    while (j < nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (k >j && nums[k] == nums[+1]) {
                        k--;
                    }
                    resultList.add(list);
                }
            }
        }
        return resultList;
    }

    /**
     * 快速排序
     */
    public static int[] quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return arr;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);

        return arr;
    }

    public static int partition(int[] arr, int l, int r) {
        int v = arr[l]; // 标定点
        int j = l;
        // i 索引
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swip(arr, i, j);
            }
        }
        // j 与 l的数据进行交换
        swip(arr, j, l);
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
