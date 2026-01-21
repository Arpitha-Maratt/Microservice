package com.microservices.paymentService.repository;

import com.microservices.paymentService.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PaymentRepository extends JpaRepository<Payment ,Integer>{


}
