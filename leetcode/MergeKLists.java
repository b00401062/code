package leetcode;

class MergeKLists {
    private static int select(ListNode[] lists) {
        var argmin = -1;
        for (var i = 0; i < lists.length; i++) {
            argmin = (
                lists[i] == null ? argmin :
                argmin == -1 ? i :
                lists[argmin].val < lists[i].val ? argmin :
                i
            );
        }
        return argmin;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        var head = new ListNode(0);
        var tail = head;
        var i = select(lists);
        while (i != -1) {
            tail.next = new ListNode(lists[i].val);
            tail = tail.next;
            lists[i] = lists[i].next;
            i = select(lists);
        }
        return head.next;
    }
}
