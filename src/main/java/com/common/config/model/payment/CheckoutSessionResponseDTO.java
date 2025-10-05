package com.common.config.model.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutSessionResponseDTO {
    private String sessionId;
    private String publishableKey;
    private String checkoutUrl;
}