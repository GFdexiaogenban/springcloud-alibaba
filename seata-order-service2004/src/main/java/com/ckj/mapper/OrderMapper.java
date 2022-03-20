package com.ckj.mapper;

import com.ckj.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderMapper extends Mapper<Order> {
    @Insert("insert into seata_order.tab_order(id, user_id, product_id, count, money, status) value(#{id}, #{userId}, #{productId}, #{count}, #{money}, #{status})")
    int createNew(Order order);
}
