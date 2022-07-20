package com.life.jorange.generics

/**
 * create time: 2022/6/5
 * Descrite:
 */
class KotlinAppleShop<out T> {
    fun buy(): T {
        return null as T
    }

    fun setPrice(price: Int) {
    }

    interface KotlinShop<T> {
        fun buy(): T

        fun setPrice(price: Int)
    }
}