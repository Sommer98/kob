package com.kob.backend.service.user.account;

import com.kob.backend.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public List<User> getAll();
}
