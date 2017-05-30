package com.xueyou.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = {"controller", "com.xueyou.demo", "schedule"})
@EnableScheduling
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
