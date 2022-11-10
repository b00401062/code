package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        var stack = new Stack<Character>() {{ push('('); }};
        var list = new ArrayList<String>();
        var nl = 1;
        var nr = 0;
        while (nl != 0) {
            while (nl < n) {
                stack.push('(');
                nl++;
            }
            while (nr < n) {
                stack.push(')');
                nr++;
            }
            list.add(stack.stream().map(String::valueOf).collect(Collectors.joining("")));
            while (nl == nr) {
                while (stack.pop() == ')') {
                    nr--;
                }
                nl--;
                if (nl == 0) break;
            }
            stack.push(')');
            nr++;
        }
        return list;
    }
}
