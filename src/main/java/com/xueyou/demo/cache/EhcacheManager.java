package com.xueyou.demo.cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URL;

/**
 * Created by wuxueyou on 2017/6/19.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EhcacheManager<T> implements SelfCacheManager<T>, InitializingBean, DisposableBean {
    private CacheManager myCacheManager;

    private Cache<String, CacheDataObject> cache;

    @PostConstruct
    private void init() {
        final URL myUrl = EhcacheManager.class.getResource("/ehcache.xml");
        Configuration xmlConfig = new XmlConfiguration(myUrl);
        myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        myCacheManager.init();
    }

    @Override
    public void put(String key, T data) {
        synchronized (key) {
            cache.put(key, new CacheDataObject(data));
        }
    }

    @Override
    public T get(String key) {
        return (T) cache.get(key);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public void destroy() throws Exception {
        this.myCacheManager.close();
    }

    @Override
    public boolean isExists(String key) {
        return cache.get(key) != null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = myCacheManager.getCache("BIPFCache", String.class, CacheDataObject.class);
    }
}
