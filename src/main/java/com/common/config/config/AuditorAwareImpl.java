package com.common.config.config;

import com.common.config.model.SessionHelper;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuditorAwareImpl implements AuditorAware<UUID> {

    private final SessionHelper sessionHelper;

    public AuditorAwareImpl(SessionHelper sessionHelper) {
        this.sessionHelper = sessionHelper;
    }

    @Override
    public Optional<UUID> getCurrentAuditor() {
        return Optional.ofNullable(sessionHelper.getCurrentUserID());
    }
}
