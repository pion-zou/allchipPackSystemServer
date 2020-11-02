package com.allchip.pack.mapper;

import com.allchip.pack.pojo.Contract;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContractMapper {
    @Select("select * from contract")
    List<Contract> findAll();

    @Insert(" insert into contract ( number , creator ,remark ,create_time , state , update_time , editor , publish_time) values " +
            "(#{number} , #{creator} , #{remark} , now() , #{state} , now() , #{editor} , #{publish_time})")
    public int save(Contract category);

    @Delete(" delete from contract where number= #{number} ")
    public void delete(String number);

    @Select("select * from contract where id= #{id} ")
    public Contract getById(int id);

    @Select("select * from contract where number= #{number} ")
    public Contract getByNumber(String number);

    @Update("<script>update contract set <if test =\'number != null and number != \"\" \'>number  = #{number} , </if> remark=#{remark} , state=#{state}, publish_time=#{publish_time}  , update_time = now() , editor = #{editor} where id=#{id} </script>")
    public int update(Contract category);




}
