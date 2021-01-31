package com.levi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.levi.pojo.Type;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMapper extends BaseMapper<Type> {

    @Select("SELECT * FROM `type` WHERE type = #{type}")
    public Type selectByType(String type);

}
