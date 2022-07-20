package com.life.jorange.generics;

import java.io.Serializable;

/**
 * create time: 2022/6/4
 * Descrite:
 */
public interface Shop<T> {
    T buy();

    <P extends Runnable & Serializable> void someMethod(P params);
}
