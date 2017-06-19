package com.xueyou.demo.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wuxueyou on 2017/6/16.
 */
public class LambdaTest {
    @Test
    public void tt() {
        //foreach 使用
        List<String> list = Arrays.asList("23", "2622", "3", "4444444");
        System.out.println("======foreach的使用======");
        list.forEach(x -> System.out.print(x + "\t"));
        System.out.println("");
        list.forEach(x -> System.out.print(x.length() + "\t"));
        System.out.println("");
        list.forEach(x -> System.out.print(dealStr(x) + "\t"));
        System.out.println("");


        //filter的使用
        System.out.println("======filter的使用======");
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (Integer.valueOf(s) > 100) {
                    return true;
                } else {
                    return false;
                }
            }
        }).forEach(x -> System.out.print(x + "\t"));
        System.out.println("");

        list.stream().filter(this::selfCondition).forEach(x -> System.out.print(x + "\t"));
        System.out.println("");

        //返回长度大于1且长度小于5的
        System.out.println("filter返回长度在1和5之间的数据");
        Predicate<String> lenthBiggerThan1 = (n) -> n.length() > 1;
        Predicate<String> lenthLessThan5 = (n) -> n.length() < 5;
        list.stream().filter(lenthBiggerThan1.and(lenthLessThan5)).forEach(x -> System.out.print(x + "\t"));
        System.out.println("");

        //过滤后转换成新的List
        System.out.println("过滤后生成一个新的list");
        List<String> newList = list.stream().filter(lenthBiggerThan1.and(lenthLessThan5)).collect(Collectors.toList());
        newList.forEach(x -> System.out.print(dealStr(x) + "\t"));
        System.out.println("");

        //map使用
        System.out.println("======map使用======");
        list.stream().map(x -> Integer.valueOf(x.toString()) * 2).forEach(x -> System.out.print(x + "\t"));
        System.out.println("");
        //这里传递的参数是一个函数，这个函数把String转换成任意类型
        list.stream().map(this::strToInt).forEach(x -> System.out.print(x + "\t"));
        System.out.println("");

        //map之后，生成一个新的list
        System.out.println("======map之后，生成一个新的list======");
        List<Integer> newIntList = list.stream().map(this::strToInt).collect(Collectors.toList());
        newIntList.forEach(x -> System.out.print(x + "\t"));
        System.out.println("");


        //统计
        System.out.println("======统计最大值最小值等======");
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

        //groupingBy使用
        System.out.println("=======groupingBy==========");
        Stream<Person> stream = Stream.of(new Person("1", "aa", "12"), new Person("1", "bb", "13"), new Person("3", "cc", "14"));
        System.out.println(stream.collect(Collectors.groupingBy(x -> x.id)));

        //groupingBy
        Map<String, List<Person>> tempMap = Stream.of(new Person("1", "aa", "12"), new Person("1", "bb", "13"), new Person("3", "cc", "14"))
                .collect(Collectors.groupingBy(x -> x.id));
        for (String s : tempMap.keySet()) {
            tempMap.get(s).stream().forEach(x -> System.out.println(x));
        }

        Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4)
                .collect(Collectors.groupingBy(it -> it > 3));
        System.out.println("collectGroup : " + collectGroup);
    }

    public String dealStr(String str) {
        return str + "xxxx";
    }

    public boolean selfCondition(String s) {
        if (Integer.valueOf(s) > 100) {
            return true;
        } else {
            return false;
        }
    }

    public int strToInt(String c) {
        return Integer.valueOf(c);
    }


}

class Person {
    String id;
    String name;
    String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
