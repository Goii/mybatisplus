package com.levi.user.service.impl;

import com.levi.user.entity.User;
import com.levi.user.mapper.UserMapper;
import com.levi.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author levi
 * @since 2021-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
