package com.zcy.sc1.service;

import com.zcy.sc1.pojo.User;

public interface UserService {
    User getUser(Integer id);

    void addScore(Integer id, Integer score);
}
