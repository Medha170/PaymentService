package com.example.paymentservicenew.paymentgateways;

import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;

@Component
public class RazorpayGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderId, String email) throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient("rzp_test_hLwh3k6JadYHlS", "kODk3nkCGedWDvFYLy2oKdgn");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1714237615);
        paymentLinkRequest.put("reference_id","TS1989");
        paymentLinkRequest.put("description","Sample Payment link for SST");
        JSONObject customer = new JSONObject();
        customer.put("name","+919000090000");
        customer.put("contact","Medha Shree");
        customer.put("email",email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
//        JSONObject notes = new JSONObject();
//        notes.put("policy_name","SST");
//        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
