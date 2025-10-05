package com.common.config.model.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    private String successUrl;
    private String cancelUrl;
}
