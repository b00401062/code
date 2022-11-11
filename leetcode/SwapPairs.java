package leetcode;

class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        var root = new ListNode(0);
        root.next = head;
        var pre = root;
        var cur = head;
        while (cur != null) {
            if (cur.next == null)
                return root.next;
            var nxt = cur.next;
            pre.next = nxt;
            cur.next = nxt.next;
            nxt.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return root.next;
    }
}
