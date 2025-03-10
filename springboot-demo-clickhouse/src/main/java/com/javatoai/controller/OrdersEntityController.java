package com.javatoai.controller;
import com.javatoai.business.pojo.entity.OrdersEntity;
import com.javatoai.business.service.OrdersEntityServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* 订单分布式表(orders)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/orders")
public class OrdersEntityController {
/**
* 服务对象
*/
@Resource
private OrdersEntityServiceImpl ordersEntityServiceImpl;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public OrdersEntity selectOne(Integer id) {
return ordersEntityServiceImpl.selectByPrimaryKey(id);
}

}
