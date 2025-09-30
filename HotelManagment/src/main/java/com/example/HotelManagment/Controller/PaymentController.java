package com.example.HotelManagment.Controller;

import com.example.HotelManagment.Entity.PaymentEntity;
import com.example.HotelManagment.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Get all payments
    @GetMapping
    public List<PaymentEntity> getAllPayments() {
        return paymentService.getAll();
    }

    // Add new payment
    @PostMapping
    public PaymentEntity addPayment(@RequestBody PaymentEntity payment) {
        return paymentService.save(payment);
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public PaymentEntity getPayment(@PathVariable Long id) {
        return paymentService.getById(id);
    }

    // Delete payment
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
