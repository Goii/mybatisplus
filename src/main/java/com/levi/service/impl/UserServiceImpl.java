package com.levi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.levi.mapper.UserMapper;
import com.levi.pojo.User;
import com.levi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
