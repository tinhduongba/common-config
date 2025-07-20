package com.common.config.interceptor;

import com.common.config.model.SessionHelper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignClientRequestInterceptor implements RequestInterceptor {
    private final ObjectProvider<SessionHelper> sessionHelperProvider;

    public FeignClientRequestInterceptor(ObjectProvider<SessionHelper> sessionHelperProvider) {
        this.sessionHelperProvider = sessionHelperProvider;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        SessionHelper sessionHelper = sessionHelperProvider.getIfAvailable();
        if (sessionHelper != null) {
            requestTemplate.header("userId", String.valueOf(sessionHelper.getCurrentUserID()));
            requestTemplate.header("lang", String.valueOf(sessionHelper.getLanguage()));
        }
    }
}
