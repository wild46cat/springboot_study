package com.xueyou.demo.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * Created by wuxueyou on 2017/6/16.
 */
public class MD5 {
    public static String getMD5Key(String str){
        return Hashing.md5().newHasher().putString(str, Charsets.UTF_8).hash().toString();
    }
}
