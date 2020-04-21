package club.fallngsakura.springboot.service.impl;

import club.fallngsakura.springboot.dao.PaymentDao;
import club.fallngsakura.springboot.entities.Payment;
import club.fallngsakura.springboot.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MISAKI RINNE
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
