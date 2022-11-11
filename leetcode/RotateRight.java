package leetcode;

class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        var n = 0;
        var ptr = head;
        var tail = (ListNode) null;
        while (ptr != null) {
            n += 1;
            if (ptr.next == null) tail = ptr;
            ptr = ptr.next;
        }
        if (k % n == 0) return head;
        ptr = head;
        for (var i = 0; i < n - k % n - 1; i++) {
            ptr = ptr.next;
        }
        var newTail = ptr;
        var newHead = ptr.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}
