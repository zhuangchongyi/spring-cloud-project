package com.zcy.sc1.service;

import com.zcy.sc1.pojo.Order;

public interface OrderService {
    Order getOrder(String orderId);

    void addOrder(Order order);
}
