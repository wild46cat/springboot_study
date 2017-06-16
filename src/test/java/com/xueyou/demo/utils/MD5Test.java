package com.xueyou.demo.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wuxueyou on 2017/6/16.
 */
public class MD5Test {
    @Test
    public void md5test(){
        String sKey = MD5.getMD5Key("123");
        System.out.println(sKey);
        Assert.assertNotEquals(sKey,"");
    }
}
