package leetcode;

import java.util.Stack;

class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        var stack = new Stack<ListNode>();
        var root = new ListNode(0);
        root.next = head;
        var prv = root;
        var ptr = head;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.next;
            if (stack.size() == k) {
                for (var i = 0; i < k; i++) {
                    prv.next = stack.pop();
                    prv = prv.next;
                }
                prv.next = ptr;
            }
        }
        return root.next;
    }
}
