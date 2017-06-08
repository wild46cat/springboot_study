package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;
import java.util.ResourceBundle;

/**
 * Created by wuxueyou on 2017/6/2.
 */
@Component
public class DataSourcePool {

    private ComboPooledDataSource comboPooledDataSource;
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.username}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maxPoolSize}")
    private int maxPoolSize;


    @Value("${jdbc.maxIdleTime}")
    private int maxIdleTime;

    public ComboPooledDataSource getDataSource() {
        if (comboPooledDataSource != null) {
            return comboPooledDataSource;
        }
        try {
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
}
