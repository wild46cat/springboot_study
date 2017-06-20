package com.xueyou.demo.String;

import org.junit.Test;

/**
 * Created by wuxueyou on 2017/6/20.
 */
public class StringTest {
    @Test
    public void internTest() {
        String b = new String("123") + new String("456");
        b.intern();
        String s = "123456";

        String b1 = new String("123") + new String("456");
        String s1 = "123456";

        String b2 = new String("123456");
        b2.intern();
        String s2 = "123456";

        String b3 = new String("123456").intern();
        String s3 = "123456";

        System.out.println(s.equals(b));
        System.out.println(s == b);
        System.out.println("=================");
        System.out.println(s1.equals(b1));
        System.out.println(s1 == b1);
        System.out.println("=================");
        System.out.println(s2.equals(b2));
        System.out.println(s2 == b2);
        System.out.println("=================");
        System.out.println(s3.equals(b3));
        System.out.println(s3 == b3);
    }
}