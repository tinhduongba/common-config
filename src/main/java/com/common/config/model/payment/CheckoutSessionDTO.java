package com.common.config.model.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutSessionDTO {
    private String id;
    private String status;        // open | complete | expired
    private String projectId;
    private Long amountTotal;
    private String currency;
}