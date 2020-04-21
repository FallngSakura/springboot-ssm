package club.fallngsakura.springboot.controller;

import club.fallngsakura.springboot.entities.CommonResult;
import club.fallngsakura.springboot.entities.Payment;
import club.fallngsakura.springboot.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author MISAKI RINNE
 */

@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("create结果："+result);
        if(result > 0 )
        {
            return  new CommonResult<>(200,"插入数据库成功,端口："+serverPort,result);
        }else{
            return  new CommonResult<>(444,"插入数据库失败",null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if(payment != null )
        {
            return  new CommonResult<Payment>(200,"查询成功,端口："+serverPort,payment);
        }else{
            return  new CommonResult<Payment>(444,"没有对应记录，查询id:"+id,null);
        }
    }

}
