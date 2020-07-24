package com.zcy.sc4.feignclient.fb;

import com.zcy.sc1.pojo.Item;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc4.feignclient.ItemFeignService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemFeignServiceFB implements ItemFeignService {
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        // 获取商品列表的降级方法，模拟使用缓存数据
        if (Math.random() < 0.5) {
            return JsonResult.ok().data(

                    Arrays.asList(new Item[]{
                            new Item(1, "缓存aaa", 2),
                            new Item(2, "缓存bbb", 1),
                            new Item(3, "缓存ccc", 3),
                            new Item(4, "缓存ddd", 1),
                            new Item(5, "缓存eee", 5)
                    })

            );
        }
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }
}
