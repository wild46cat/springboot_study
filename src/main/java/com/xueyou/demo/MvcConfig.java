package com.xueyou.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String[] excludes = new String[]{"/static/**", "**.html", "/login.html"};
//
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/").addResourceLocations("classpath:/my-project/");
        super.addResourceHandlers(registry);
    }
}
