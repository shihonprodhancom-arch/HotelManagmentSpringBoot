package com.example.HotelManagment.Service;

import com.example.HotelManagment.Entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> getAllPayments();
    PaymentEntity getPaymentById(Long id);
    PaymentEntity savePayment(PaymentEntity payment);
    PaymentEntity updatePayment(Long id, PaymentEntity payment);
    void deletePayment(Long id);
}
