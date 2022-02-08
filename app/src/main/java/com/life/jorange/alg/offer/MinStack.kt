package com.life.jorange.alg.offer

import java.util.*

/**
 * 包含 min 函数的栈:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack {
    private val nStack = Stack<Int>()
    private val oStack = Stack<Int>()
    fun push(x: Int) {
        nStack.push(x)
        if (oStack.empty() || oStack.peek() >= x) {
            oStack.push(x)
        }
    }

    fun pop() {
        if (nStack.pop().equals(oStack.peek())) {
            oStack.pop()
        }
    }

    fun top(): Int {
        return nStack.peek()
    }

    fun min(): Int {
        return oStack.peek()
    }
}