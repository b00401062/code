package leetcode

import java.util.*

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var stack = Stack<ListNode>()
    var root = ListNode(0)
    root.next = head
    var prv = root
    var ptr = head
    while (ptr != null) {
        stack.push(ptr)
        ptr = ptr.next
        if (stack.size == k) {
            repeat(k) {
                prv.next = stack.pop()
                prv = prv.next!!
            }
            prv.next = ptr
        }
    }
    return root.next
}
