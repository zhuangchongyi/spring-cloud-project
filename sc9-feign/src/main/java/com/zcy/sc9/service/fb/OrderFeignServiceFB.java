package com.zcy.sc9.service.fb;

import com.zcy.sc1.pojo.Order;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc9.service.OrderFeignService;
import org.springframework.stereotype.Service;

@Service
public class OrderFeignServiceFB implements OrderFeignService {
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取商品订单");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("无法保存订单");
    }
}
