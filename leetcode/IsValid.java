package leetcode;

import java.util.Stack;

class IsValid {
    public static boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (var c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push('('); break;
                case '[': stack.push('['); break;
                case '{': stack.push('{'); break;
                case ')': if (stack.isEmpty() || stack.pop() != '(') return false; break;
                case ']': if (stack.isEmpty() || stack.pop() != '[') return false; break;
                case '}': if (stack.isEmpty() || stack.pop() != '{') return false; break;
            }
        }
        return stack.isEmpty();
    }
}
