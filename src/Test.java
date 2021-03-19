import com.eric.algorithm.model.TreeNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        boolean valid = test.isValid("()");
        System.out.println(valid);
    }

    // ()[]{}
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                switch (cur) {
                    case ')':
                        if(pop != '(') return false;
                        break;
                    case ']':
                        if(pop != '[') return false;
                        break;
                    case '}':
                        if(pop != '{') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    private static TreeNode createNode() {
        TreeNode node = new TreeNode(1);
//        TreeNode left_two_node = new TreeNode(2, null, new TreeNode(3));
//        TreeNode right_two_node = new TreeNode(2, null, new TreeNode(3));
        TreeNode left_two_node = new TreeNode(2);
        TreeNode right_two_node = new TreeNode(2);


        node.left = left_two_node;
        node.right = right_two_node;
        return node;
    }
}
