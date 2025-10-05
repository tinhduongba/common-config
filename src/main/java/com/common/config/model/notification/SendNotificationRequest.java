package com.common.config.model.notification;

import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendNotificationRequest {
    private UUID userId;
    private String title;
    private String body;
    private String link;
    private String type;
    private Map<String, Object> metadata;
}