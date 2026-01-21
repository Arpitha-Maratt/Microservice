package com.microservices.orderServices.service;

import com.microservices.orderServices.common.Payment;
import com.microservices.orderServices.common.TransactionRequest;
import com.microservices.orderServices.common.TransactionResponse;
import com.microservices.orderServices.entity.Order;
import com.microservices.orderServices.repository.OrderRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response="";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //rest call
        Payment paymentResponse = restTemplate.postForObject(
                "http://localhost:9191/payment/doPayment",
                payment,
                Payment.class
        );
        response=paymentResponse.getPaymentStatus().equals("success")?"payment Processing successful and order placed":"there is a failure api,order added to cart";

        orderRepository.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
