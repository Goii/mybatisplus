package com.levi;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.levi.mapper.UserMapper;
import com.levi.pojo.User;
import com.levi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisplusApplication.class)
public class PlusTests {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testLogicDel() {
        int res = mapper.deleteById(2);
//      条件删除
//        mapper.delete(QueryWrapper);
//        批量
//        mapper.deleteBatchIds(idlist);
        if(res ==1) {
            System.out.println("逻辑删除执行完.");
        }
    }

//  分页
    @Test
    public void testPage() {
        Page<User> page = new Page<>();
        page.setCurrent(1);//当前页
        page.setSize(2);//每页条数
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom");
        userMapper.selectPage(page, wrapper);
        page.getRecords().forEach(System.out::println);

        long total = page.getTotal();//获取总条数
        System.out.println("总条数："  + total);
    }

    //测试service
    @Test
    public void testService(){
//      查全部
        List<User> list = service.list(null);
        list.forEach(System.out::println);
//      总数
//        service.count(QueryWrapper);
//      修改
//      boolean flag=  service.update(QueryWrapper);
//        service.updateBatchById(List<User>)
//      保存
//        service.save(User);
//      保存或者更新
//        service.saveOrUpdate(User,QueryWrapper);
//      批量修改
//        service.updateBatchById(List<User>,size);
    }

    @Test
    public void TestWrapper(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        User user = new User();
        user.setName("levi");
        user.setAge("22");

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);


        wrapper.eq(User::getName,"levi") //等于
                .like(User::getEmail,"163")  //模糊查询
                .gt(StrUtil.isNotEmpty(user.getType()),User::getType,user.getType()) //greater then  大于
//                .ge() 等于
//                .lt()   less then    .le()   less equal
//                .likeLeft()
//                .likeRight()   左右侧模糊
                .orderByDesc(User::getId)
                .between(User::getId,1,5)

                .isNull(User::getEmail)
                .in(User::getId,idList)
                .inSql(User::getId,"select id from table where id < 3") //带sql
                .groupBy(User::getType)

                .having("sum(age) > 10")
                .having("sum(age) > ${0}",11)

                .or(i ->  i.eq(User::getId,1).ne(User::getType,"可用"))

                .apply("date_format(dateColumn,'%Y-%m-%d') = {0}", "2008-08-08");
    }
}
