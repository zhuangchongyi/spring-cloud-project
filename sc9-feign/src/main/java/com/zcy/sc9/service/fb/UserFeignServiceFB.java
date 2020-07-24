package com.zcy.sc9.service.fb;

import com.zcy.sc1.pojo.User;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc9.service.UserFeignService;
import org.springframework.stereotype.Service;

@Service
public class UserFeignServiceFB implements UserFeignService {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("无法获取用户信息");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分");
    }
}
