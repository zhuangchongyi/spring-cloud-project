package com.zcy.sc9.service;

import com.zcy.sc1.pojo.User;
import com.zcy.sc1.utils.JsonResult;
import com.zcy.sc9.service.fb.UserFeignServiceFB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//fallback指定降级类
@FeignClient(value = "user-service",fallback = UserFeignServiceFB.class)
public interface UserFeignService {
    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    @GetMapping("/{userId}/score")
    JsonResult addScore(@PathVariable Integer userId, @RequestParam Integer score);
}
