package leetcode;

class AddTwoNumbers {
    private static void carry(ListNode l) {
        if (l.val < 10)
            return;
        l.val %= 10;
        if (l.next == null) {
            l.next = new ListNode(1);
        } else {
            l.next.val++;
            carry(l.next);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        var l = new ListNode(l1.val + l2.val);
        l.next = addTwoNumbers(l1.next, l2.next);
        carry(l);
        return l;
    }
}
