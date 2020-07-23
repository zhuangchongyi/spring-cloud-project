package com.zcy.sc2.controller;

import com.zcy.sc1.pojo.Item;
import com.zcy.sc1.service.ItemService;
import com.zcy.sc1.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        log.info("server.port=" + port + ", orderId=" + orderId);

        try {
            //测试 ribbon的重试机制，设置随机延迟
            long t = new Random().nextInt(5000);
            if(Math.random()<0.6) {
                log.info("item-service-"+port+" - 暂停 "+t);
                Thread.sleep(t);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Item> items = itemService.getItems(orderId);
        return JsonResult.ok(items).msg("port=" + port);
    }

    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        itemService.decreaseNumbers(items);
        return JsonResult.ok();
    }
}
