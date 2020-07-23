package com.zcy.sc1.service;

import com.zcy.sc1.pojo.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems(String orderId);

    void decreaseNumbers(List<Item> list);
}
