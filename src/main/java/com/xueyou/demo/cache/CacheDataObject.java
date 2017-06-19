package com.xueyou.demo.cache;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wuxueyou on 2017/6/19.
 */
public class CacheDataObject implements Serializable {
    private Long timeStamp;
    private String context;

    public CacheDataObject() {
    }

    public CacheDataObject(String context) {
        this.context = context;
        this.timeStamp = new Date().getTime();
    }

    public CacheDataObject(Object context) {
        this.context = context.toString();
        this.timeStamp = new Date().getTime();
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
