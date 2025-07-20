package com.common.config.config;

import com.common.config.model.RequesterHeaders;
import com.common.config.model.SessionHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanInit {
    private final RequesterHeaders requesterHeaders;

    public CommonBeanInit(RequesterHeaders requesterHeaders) {
        this.requesterHeaders = requesterHeaders;
    }

    @Bean
    public SessionHelper sessionHelper() {
        return new SessionHelper(requesterHeaders);
    }
}