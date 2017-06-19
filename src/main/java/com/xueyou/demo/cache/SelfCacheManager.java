package com.xueyou.demo.cache;

/**
 * Created by wuxueyou on 2017/6/19.
 */
public interface SelfCacheManager<T> {
    void put(String key, T data);

    T get(String key);

    void remove(String key);

    boolean isExists(String key);
}
