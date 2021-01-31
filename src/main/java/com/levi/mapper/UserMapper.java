package com.levi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.levi.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    //select * from table1 a left join table2 on a.id=b.id
    @Results({
            @Result(id=true,column="id",property="id"),//主键,不是主键可以不写
            @Result(column="id",property="id"),
            @Result(column="type",property="type2",//一对一
                    one=@One(
                            select="com.levi.mapper.TypeMapper.selectByType",
                            fetchType= FetchType.EAGER
                    )
            ) ,
            @Result(column = "type",property = "type")

//            @Result(column="id",property="listTable3",//多对多
//                    many=@Many(
//                            select="com.xx.xx.mapper.Table3Mapper.selectById",
//                            fetchType= FetchType.EAGER
//                    )
//            )
    })
    @Select("SELECT * FROM `user` WHERE id = #{id}")
    public  User selectByIdWithType(Integer id);
}
