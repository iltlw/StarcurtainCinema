package com.buka.mapper;

import com.buka.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into t_user values(null,#{username},#{userPassword},1)")
    @Options(useGeneratedKeys = true,keyColumn ="user_id",keyProperty ="user_id" )
    int addUser(User user);

    @Select("select * from t_user where username=#{username}")
    User getUserByUserName(String username);
}
