package leetcode;

class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        var head = new ListNode(0);
        var tail = head;
        var p1 = list1;
        var p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = new ListNode(p1.val);
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = new ListNode(p2.val);
                tail = tail.next;
                p2 = p2.next;
            }
        }
        tail.next = (p1 == null) ? p2 : p1;
        return head.next;
    }
}
