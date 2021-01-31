package com.levi.contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.levi.mapper.UserMapper;
import com.levi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserMapper user;

    @GetMapping("/all")
    public List all (){
        QueryWrapper<User>  wrapper = new QueryWrapper<>();
        return  user.selectList(wrapper);
    }

    @GetMapping("/test")
    public User test(){
        int x = 111;
        User  us= user.selectByIdWithType(new Integer(x));
        us.getType2().getDes();
        return  us;
    }

    @GetMapping("/delete")
    public void delete(){
        Integer x = 5;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",x);
        int rex = user.delete(queryWrapper);
        System.out.println(rex);

    }

    @GetMapping("/list")
    public IPage<User> list (){
        Page<User> page =new Page<>();
        page.setSize(10);
        page.setCurrent(1);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("age");
        IPage<User> records = user.selectPage(page, queryWrapper);
        return records;
    }

}
