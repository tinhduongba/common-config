package com.common.config.config;

import com.common.config.interceptor.RequesterHeaderInterceptor;
import com.common.config.model.RequesterHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HeaderInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(requesterHeaderInterceptor());
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequesterHeaders requestHeaders() {
        return new RequesterHeaders();
    }

    @Bean
    public RequesterHeaderInterceptor requesterHeaderInterceptor() {
        return new RequesterHeaderInterceptor(requestHeaders());
    }
}