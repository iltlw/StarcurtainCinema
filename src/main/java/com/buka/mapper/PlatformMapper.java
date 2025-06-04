package com.buka.mapper;

import com.buka.pojo.Platform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PlatformMapper {
    @Insert("insert into t_platform values(null,#{platformName},#{platformPassword})")
    @Options(useGeneratedKeys = true,keyColumn ="platform_id",keyProperty ="platform_id" )
    int addUser(Platform platform);
    @Select("select * from t_platform where platform_name=#{name}")
    Platform getPlatformByPlatformName(String name);
}
