package com.common.config.model;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class SessionHelper {
    private final RequesterHeaders requesterHeaders;

    public SessionHelper(RequesterHeaders requestHeaders) {
        requesterHeaders = requestHeaders;
    }

    public UUID getCurrentUserID() {
        try {
            if (requesterHeaders == null || requesterHeaders.getUserId() == null) {
                return UUID.fromString("00000000-0000-0000-0000-000000000000");
            }
            return requesterHeaders.getUserId();

        } catch (Exception ex) {
            return UUID.fromString("11111111-1111-1111-1111-111111111111");
        }
    }

    public String getLanguage() {
        try {
            if (requesterHeaders == null || requesterHeaders.getLanguage() == null) {
                return "en";
            }
            return requesterHeaders.getLanguage();

        } catch (Exception ex) {
            return "en";
        }
    }
}
