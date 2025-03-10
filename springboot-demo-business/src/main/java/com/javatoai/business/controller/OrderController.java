package com.javatoai.business.controller;

import com.javatoai.business.pojo.entity.OrdersEntity;
import com.javatoai.business.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/init")
    public String init() throws ParseException {
        // 准备一个装载 OrdersDistributedEntity 的列表
        List<OrdersEntity> list = new ArrayList<>(10000);

        // 300000: 30704ms
        // 10000: 7150ms  6678ms
        // 循环生成 10000 条测试数据
        for (long i = 1; i <= 10000; i++) {
            OrdersEntity entity = new OrdersEntity();

            entity.setOrderId(i);
            entity.setUserId(1000 + i);            // 示例：用户ID 从1001开始
            entity.setProductId(2000 + i);         // 示例：商品ID 从2001开始
            entity.setQuantity((i % 5) + 1);       // 示例：1~5之间的购买数量
            entity.setPrice(BigDecimal.valueOf(99.99)); // 示例：单价固定 99.99
            // 订单总金额 = 单价 * 数量
            entity.setTotalAmount(entity.getPrice().multiply(BigDecimal.valueOf(entity.getQuantity())));

            entity.setCurrency("USD");             // 示例：默认币种 USD
            entity.setOrderStatus("Created");      // 示例：默认订单状态
            entity.setPaymentMethod("CreditCard"); // 示例：支付方式
            entity.setShippingAddress("No." + i + " Main Street");
            entity.setShippingCity("City" + i);
            entity.setShippingCountry("Country" + i);
            entity.setContactPhone("1333000" + i);
            entity.setContactEmail("user" + i + "@example.com");

            // 设置创建时间、更新时间为当前时间
            Date now = new Date();


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            entity.setCreatedAt(sdf.parse(sdf.format(new Date())));
            entity.setUpdatedAt(sdf.parse(sdf.format(new Date())));


            list.add(entity);
        }

        long start  = System.currentTimeMillis();
        // 调用服务的 saveBatch() 方法一次性插入
        ordersService.saveBatch(list);
        long end = System.currentTimeMillis();

        return end - start + "ms";
    }
}
