import com.eric.algorithm.model.TreeNode;

import java.util.*;

public class Test {

    //  15. 3Sum 3个数之和为0 [-1,0,1,2,-1,-4] ---> [[-1,-1,2],[-1,0,1]]
    //  15. 3Sum 3个数之和为0 [-4,-1,-1,0,1,2] ---> [[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[j] + nums[k] > target) {
                    // 太大了，右指针左移
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    // 太小了，左指针右移
                    j++;
                } else {
                    // 正好符合条件
                    List<Integer> cur = new ArrayList<>();
                    cur.add(-target);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    res.add(cur);
                    j++;
                    k--;

                    // 还需要继续寻找满足条件的
                    while (j < nums.length && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j + 1 && nums[k - 1] == nums[k]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {-2, 0, 1, 1, 2};
        List<List<Integer>> lists = test.threeSum(nums1);
        System.out.println(lists.toString());

    }

}
