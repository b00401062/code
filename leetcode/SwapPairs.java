package leetcode

fun swapPairs(head: ListNode?): ListNode? {
    var root = ListNode(0)
    root.next = head
    var pre = root
    var cur = head
    while (cur != null) {
        var nxt = cur.next ?: return root.next
        pre.next = nxt
        cur.next = nxt.next
        nxt.next = cur
        pre = cur
        cur = cur.next
    }
    return root.next
}
