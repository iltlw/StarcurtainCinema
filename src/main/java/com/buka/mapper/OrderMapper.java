package com.buka.mapper;

import com.buka.pojo.Arrange;
import com.buka.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from t_order where order_arrange_id=#{arrangeId}")
    List<Order> getListByArrangeId(int arrangeId);
@Insert("insert into t_order values(null,#{orderNum},#{orderArrangeId},#{orderCinemaId},#{orderMovieId},#{orderSeatRow},#{orderSeatCol},#{orderTime},#{orderMoney},#{orderState},#{orderPayId})")
    int add(Order order);

@Select("select count(1) from t_order where order_arrange_id=#{arrangeId} and order_seat_row=#{orderSeatRow} and order_seat_col=#{orderSeatCol}")
    Integer isLocalByArrangeIdAndSeat(@Param("arrangeId") int arrangeId, @Param("orderSeatRow") int orderSeatRow, @Param("orderSeatCol") int orderSeatCol);
@Update("update t_order set order_state=2 where order_pay_id=#{payId}")
    void payd(int payId);

@Select("select * from t_order where order_pay_id=#{payId}")
@Results({
        @Result(id = true,property = "orderId",column = "order_id"),

        @Result(
                property = "arrange",
                javaType = Arrange.class,
                column = "order_arrange_id",
                one=@One(select = "com.buka.mapper.ArrangeMapper.getDetailById")
        )
})
    List<Order> getListByPayId(int payId);

}
