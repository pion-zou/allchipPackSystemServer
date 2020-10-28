package com.allchip.pack.mapper;

import com.allchip.pack.pojo.Contract;
import com.allchip.pack.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Delete(" delete from user where id= #{id} ")
    public void delete(int id);

    @Select("select * from user where id= #{id} ")
    public User getById(int id);

    @Select("select * from user where name= #{name} ")
    public User getByName(String name);

    @Update("update user set password=#{password} where id=#{id} ")
    public int update(User user);

    @Insert(" insert into user ( name , password) values " +
            "(#{name} , #{password})")
    public int save(User user);



}
