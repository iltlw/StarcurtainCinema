package com.buka.mapper;

import com.buka.pojo.Pay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PayMapper {
    @Insert("insert into t_pay values(null,#{payNum},#{payUserId},#{payState},null,null,null)")
    @Options(useGeneratedKeys = true,keyProperty = "payId",keyColumn = "pay_id")
    int add(Pay pay);
@Update("update t_pay set pay_state=2,pay_notify_info=#{body} where pay_num=#{payNum}")
    void payd(@Param("payNum") String payNum,@Param("body") String body);

@Select("select pay_id from t_pay where pay_num=#{payNum}")
    int getIdByNum(String payNum);
@Select("select pay_state from t_pay where pay_id=#{payId} ")
    int getStateById(int payId);

@Select("select * from t_pay where pay_user_id=#{userId}")
    List<Pay> getListByUserId(int userId);
}
