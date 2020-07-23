package com.zcy.sc6.controller;

import com.zcy.sc1.pojo.Item;
import com.zcy.sc1.pojo.Order;
import com.zcy.sc1.pojo.User;
import com.zcy.sc1.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        //向指定微服务地址发送 get 请求，并获得该服务的返回结果
        //{orderId} 占位符，用 orderId 填充
        return restTemplate.getForObject("http://localhost:8001/{orderId}", JsonResult.class, orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        //发送 post 请求
        return restTemplate.postForObject("http://localhost:8001/decreaseNumber", items, JsonResult.class);
    }


    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return restTemplate.getForObject("http://localhost:8101/{1}", JsonResult.class, userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(
            @PathVariable Integer userId, Integer score) {
        return restTemplate.getForObject("http://localhost:8101/{1}/score?score={2}", JsonResult.class, userId, score);
    }


    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return restTemplate.getForObject("http://localhost:8201/{1}", JsonResult.class, orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return restTemplate.getForObject("http://localhost:8201/", JsonResult.class);
    }
}

