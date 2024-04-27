package com.example.paymentservicenew.controllers;

import com.example.paymentservicenew.dtos.InitiatePaymentRequestDTO;
import com.example.paymentservicenew.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO requestDTO) throws RazorpayException {
//        return "OrderId : " + requestDTO.getOrderId();
        return paymentService.initiatePayment(requestDTO.getOrderId(), requestDTO.getEmail());
    }
}
