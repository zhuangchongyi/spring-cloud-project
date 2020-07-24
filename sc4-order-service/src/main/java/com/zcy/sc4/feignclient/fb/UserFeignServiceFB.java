package com.zcy.sc4.feignclient.fb;

import com.zcy.sc1.pojo.User;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc4.feignclient.UserFeignService;
import org.springframework.stereotype.Service;

@Service
public class UserFeignServiceFB implements UserFeignService {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        //获取用户信息的降级方法，模拟使用缓存数据
        if (Math.random() < 0.4) {
            return JsonResult.ok(new User(userId, "缓存name" + userId, "缓存pwd" + userId));
        }
        return JsonResult.err("无法获取用户信息");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分");
    }
}
