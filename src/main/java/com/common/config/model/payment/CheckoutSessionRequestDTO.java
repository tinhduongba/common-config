package com.common.config.model.payment;

import com.common.config.enumclass.EBalanceHistoryType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckoutSessionRequestDTO {
    private UUID objectId;
    private UUID toUserId;
    private String objectType;
    private Long price;
    private String successUrl;
    private String cancelUrl;
    private String description;
    private String title;
    private EBalanceHistoryType type;
}