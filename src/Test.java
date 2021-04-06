import com.eric.algorithm.model.TreeNode;

import java.util.*;

public class Test {


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(0, new ArrayList<>(),nums);
        return res;
    }

    private void backtrace(int start, List<Integer> cur , int[] nums) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrace(i + 1,  cur, nums);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {1, 2,3};
        List<List<Integer>> subsets = test.subsets(nums);
        System.out.println(subsets.toString());

    }

}
