package com.example.paymentservicenew.paymentgateways;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {
    String generatePaymentLink(Long orderId, String email) throws RazorpayException;

}
