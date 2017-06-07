package com.xueyou.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = {"controller", "com.xueyou.demo", "schedule", "jdbc"})
@PropertySource(value = {"classpath:jdbc.properties"})
@EnableScheduling
public class App {

    @Autowired
    public static ComboPooledDataSource comboPooledDataSource;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
