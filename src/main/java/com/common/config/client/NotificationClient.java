package com.common.config.client;

import com.common.config.model.ResModel;
import com.common.config.model.notification.SendNotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping("/notification/notifications")
    ResModel<String> sendNotification(@RequestBody SendNotificationRequest request);
}
