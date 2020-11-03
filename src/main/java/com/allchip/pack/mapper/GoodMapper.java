package com.allchip.pack.mapper;

import com.allchip.pack.pojo.Contract;
import com.allchip.pack.pojo.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {

    @Select("select * from goods where number= #{number} ")
    public List<Good> getByNumber(String number);

    @Select("select * from goods where id=#{id} ")
    public Good getById(int id);

    @Insert(" insert into goods (item_index, number , creator ,remark ,type , count , package_count , package_time , year , manufacturer , package , unit_price) values " +
            "(#{item_index} ,#{number} , #{creator} , #{remark} , #{type} , #{count} , #{package_count} , #{package_time} ,#{year} , #{manufacturer} , #{packageName} , #{unit_price})")
    public int save(Good good);

    @Delete(" delete from goods where number= #{number} ")
    public void delete(String number);

    @Update("update goods set item_index=#{item_index}, type=#{type} , creator=#{creator}, remark=#{remark}  , count = #{count} ," +
            " package_count = #{package_count}, package_time = #{package_time} ,year =#{year} , " +
            "manufacturer = #{manufacturer}, package = #{package} ,total_price= #{total_price}, unit_price = #{unit_price} where id=#{id}")
    public int update(Good good);

    @Update("update goods set package_count=#{count} , package_time = #{package_time} where (item_index = #{item_index} and number=#{number})")
    public int updatePackage(Good good);

}
