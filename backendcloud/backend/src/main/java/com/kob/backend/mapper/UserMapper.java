package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;


//这里直接集成myabatisplus提供的基础类
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
