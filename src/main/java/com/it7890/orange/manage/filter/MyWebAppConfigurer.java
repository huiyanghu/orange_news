package com.it7890.orange.manage.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/6/13.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        LoginInterceptor loginInterceptor1 = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor1)
            .addPathPatterns("/")
            .addPathPatterns("/grabListRule/**")
            .addPathPatterns("/grabDetailRule/**")
            .addPathPatterns("/appTop/**")
            .addPathPatterns("/conArticle/**")
            .excludePathPatterns("/toLogin")
            .excludePathPatterns("/toDefault");
    }
}
