package com.example.paymentservicenew.services;

import com.example.paymentservicenew.paymentgateways.PaymentGateway;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGateway paymentGateway;
    PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, String email) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId,email);
    }
}
