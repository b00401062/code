package leetcode;

import java.util.ArrayList;

class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        var curr = head;
        var list = new ArrayList<ListNode>();
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if (list.size() == n)
            return head.next;
        list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
        return head;
    }
}
