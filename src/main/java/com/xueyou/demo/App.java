package com.xueyou.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xueyou.demo"})
@EnableScheduling
@PropertySource(value = {"classpath:jdbc-dev.properties"})
//@PropertySource(value = {"classpath:jdbc-test.properties"})
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
