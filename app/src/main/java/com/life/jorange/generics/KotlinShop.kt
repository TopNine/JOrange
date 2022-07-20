package com.life.jorange.generics

/**
 * create time: 2022/6/5
 * Descrite:
 */
interface KotlinShop<T> {
    fun buy(): T

    fun setPrice(price: Int)
}