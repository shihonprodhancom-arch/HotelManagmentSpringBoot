package com.example.HotelManagment.Service;

import com.example.HotelManagment.Entity.PaymentEntity;
import com.example.HotelManagment.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentEntity> getAll() {
        return paymentRepository.findAll();
    }

    public PaymentEntity save(PaymentEntity payment) {
        return paymentRepository.save(payment);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    public PaymentEntity getById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
