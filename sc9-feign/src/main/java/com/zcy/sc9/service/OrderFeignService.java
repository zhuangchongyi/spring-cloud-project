package com.zcy.sc9.service;

import com.zcy.sc1.pojo.Order;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc9.service.fb.OrderFeignServiceFB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order-service",fallback = OrderFeignServiceFB.class)
public interface OrderFeignService {
    @GetMapping("/{orderId}")
    JsonResult<Order> getOrder(@PathVariable String orderId);

    @GetMapping("/")
    JsonResult addOrder();

}
