package com.buka.mapper;

import com.buka.pojo.CinemaHome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CinemaHouseMapper
{
    @Insert("insert into t_cinema_home values(null,#{cinemaHomeName},#{cinemaHomeSeat},#{cinemaHomeCinemaId},1)")
    int add(CinemaHome cinemaHome);
    @Select("select * from t_cinema_home where cinema_home_cinema_id=#{cinemaId}")
    List<CinemaHome> getList(int cinemaId);
    @Update("update t_cinema_home set cinema_home_state=#{state} where cinema_home_id=#{cinemaHomeId}")
    int changeHouseStateById(@Param("cinemaHomeId") int cinemaHomeId, @Param("state") int state);
    @Select("select * from t_cinema_home where cinema_home_cinema_id=#{cinemaId} and cinema_home_state=#{state}")
    List<CinemaHome> getListByState(@Param("cinemaId") int cinemaId, @Param("state") int state);

    @Select("select * from t_cinema_home where cinema_home_id=#{houseId}")
    CinemaHome getById(int houseId);
}

