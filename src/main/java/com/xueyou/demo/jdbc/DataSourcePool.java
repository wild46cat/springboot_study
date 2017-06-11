package com.xueyou.demo.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xueyou.demo.App;
import com.xueyou.demo.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;

/**
 * Created by wuxueyou on 2017/6/2.
 */
@Component
public class DataSourcePool {

    @Autowired
    AppConfig appConfig;

    private ComboPooledDataSource comboPooledDataSource;

    private String url;

    private String driverClassName;

    private String user;

    private String password;

    private int maxPoolSize;

    private int maxIdleTime;

    public ComboPooledDataSource getDataSource() {
        if (comboPooledDataSource != null) {
            return comboPooledDataSource;
        }
        try {
            setConfigFromAppConfig();
            comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setDriverClass(driverClassName);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setMaxPoolSize(maxPoolSize);
            comboPooledDataSource.setMaxIdleTime(maxIdleTime);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
        }
        return comboPooledDataSource;
    }

    private void setConfigFromAppConfig() {
        this.url = appConfig.getUrl();
        this.driverClassName = appConfig.getDriverClassName();
        this.user = appConfig.getUser();
        this.password = appConfig.getPassword();
        this.maxIdleTime = appConfig.getMaxIdleTime();
        this.maxPoolSize = appConfig.getMaxPoolSize();
    }
}
