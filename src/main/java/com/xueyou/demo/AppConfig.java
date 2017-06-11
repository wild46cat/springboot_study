package com.xueyou.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by wuxueyou on 2017/6/11.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class AppConfig {
    @Value("${com.xueyou.demo.jdbc.url}")
    private String url;

    @Value("${com.xueyou.demo.jdbc.driverClassName}")
    private String driverClassName;

    @Value("${com.xueyou.demo.jdbc.username}")
    private String user;

    @Value("${com.xueyou.demo.jdbc.password}")
    private String password;

    @Value("${com.xueyou.demo.jdbc.maxPoolSize}")
    private int maxPoolSize;


    @Value("${com.xueyou.demo.jdbc.maxIdleTime}")
    private int maxIdleTime;

    public String getUrl() {
        return url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public int getMaxIdleTime() {
        return maxIdleTime;
    }
}
