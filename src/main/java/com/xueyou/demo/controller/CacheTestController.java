package com.xueyou.demo.controller;

import com.xueyou.demo.cache.CacheDataObject;
import com.xueyou.demo.cache.EhcacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuxueyou on 2017/6/19.
 */
@RestController
@RequestMapping("/cache")
public class CacheTestController {

    @Autowired
    EhcacheManager ehcacheManager;

    @RequestMapping("/put")
    public String putData(String key, String value) {
        ehcacheManager.put(key, value);
        return key;
    }

    @RequestMapping("get")
    public CacheDataObject getData(String key) {
        return (CacheDataObject) ehcacheManager.get(key);
    }

    @RequestMapping("/isExists")
    public boolean isExists(String key) {
        return ehcacheManager.isExists(key);
    }

    @RequestMapping("/remove")
    public String remove(String key) {
        ehcacheManager.remove(key);
        return key;
    }
}
