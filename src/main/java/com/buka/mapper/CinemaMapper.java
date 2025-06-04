package com.buka.mapper;

import com.buka.pojo.Cinema;
import com.buka.pojo.Movie;
import com.buka.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CinemaMapper {
    @Insert("insert into t_cinema values(null,#{cinemaName},#{cinemaPassword},null,0)")
    @Options(useGeneratedKeys = true,keyColumn ="cinema_id",keyProperty ="cinema_id" )
    int addMovie(Movie movie);
//    @Select("select * from t_cinema where cinema_name=#{cinemaName}")
//    Movie getUserByMovieName(String cinemaName);
@Select("select * from t_cinema where cinema_name=#{username}")
    Movie getCinemaByUserName(String username);

 @Insert("insert into t_cinema values(null,#{cinemaName},#{cinemaPassword},#{cinemaAddress},1)")
    int add(Movie cinema);
@Select("select * from t_cinema")
    List<Movie> getList();

    @Update("update t_cinema set cinema_state=#{state} where cinema_id=#{cinemaId}")
    int changeForStateById(@Param("cinemaId") int cinemaId, @Param("state") int state);
}
