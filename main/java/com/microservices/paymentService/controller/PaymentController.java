package com.microservices.paymentService.controller;

import com.microservices.paymentService.entity.Payment;
import com.microservices.paymentService.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServices paymentServices;

    @PostMapping(
            value = "/doPayment",
            consumes = "application/json",
            produces = "application/json"
    )
    public Payment doPayment(@RequestBody Payment payment) {
        return paymentServices.doPayment(payment);
    }





}
