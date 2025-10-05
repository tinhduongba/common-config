package com.common.config.client;

import com.common.config.model.ResModel;
import com.common.config.model.payment.CheckoutSessionRequestDTO;
import com.common.config.model.payment.CheckoutSessionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentClient {
    @PostMapping("/payment/payments/internal/checkout-session")
    ResModel<CheckoutSessionResponseDTO> createCheckoutSession(@RequestBody CheckoutSessionRequestDTO request);
}
