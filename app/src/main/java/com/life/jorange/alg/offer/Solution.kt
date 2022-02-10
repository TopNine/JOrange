package com.life.jorange.alg.offer

import java.util.*

class Solution {
    private val temp = mutableListOf<Int>()
    fun reversePrint(head: ListNode?): IntArray {
        val stack = Stack<Int>()
        var temp = head
        while (temp != null) {
            stack.push(temp.`val`)
            temp = temp.next
        }
        val array = intArrayOf()
       stack.forEachIndexed { index, value ->
           array[index] = value
       }
        return array
    }

    private fun recur(head: ListNode?) {
        if (head == null) {
            return
        }

        recur(head.next)
        temp.add(head.`val`)
    }
}