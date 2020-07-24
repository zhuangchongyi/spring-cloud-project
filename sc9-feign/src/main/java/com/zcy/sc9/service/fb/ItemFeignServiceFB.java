package com.zcy.sc9.service.fb;

import com.zcy.sc1.pojo.Item;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc9.service.ItemFeignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemFeignServiceFB implements ItemFeignService {
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }
}
