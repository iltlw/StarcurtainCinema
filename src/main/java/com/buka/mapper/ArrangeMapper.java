package com.buka.mapper;

import com.buka.pojo.Arrange;
import com.buka.pojo.CinemaHome;
import com.buka.pojo.Movie;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Mapper
public interface ArrangeMapper {

@Insert("insert into t_arrange values(null,#{arrangeCinemaId},#{arrangeCinemaHomeId},#{arrangeMovieId},#{arrangeMovieStartTime},#{arrangeMovieEndTime},#{arrangeMoney},1)")
    int add(Arrange arrange);
@Select("select * from t_arrange where arrange_cinema_id=#{cinemaId} ")
@Results({
        @Result(id = true,column = "arrange_id",property = "arrangeId"),
        @Result(
                property = "movie",
                javaType = Movie.class,
                column = "arrange_movie_id",
                one=@One(select = "com.buka.mapper.MovieMapper.getMovieById")
        ), @Result(
        property = "cinemaHome",
        javaType = Movie.class,
        column = "arrange_cinema_home_id",
        one=@One(select = "com.buka.mapper.CinemaHouseMapper.getById")
)
})
List<Arrange> getListByCinemaId(int cinemaId);

@Select("select arrange_movie_id from t_arrange where arrange_movie_start_time > #{startTime} and arrange_state =1")
Set<Integer> getListByStartTimeAfterForMovieIds(Date startTime);

@Select("select * from t_arrange where arrange_movie_start_time > #{startTime} and arrange_movie_id = #{movieId}")
@Results({
        @Result(id = true,column = "arrange_id",property = "arrangeId"),
        @Result(
                property = "movie",
                javaType = Movie.class,
                column = "arrange_movie_id",
                one=@One(select = "com.buka.mapper.MovieMapper.getMovieById")
        ), @Result(
        property = "cinemaHome",
        javaType = CinemaHome.class,
        column = "arrange_cinema_home_id",
        one=@One(select = "com.buka.mapper.CinemaHouseMapper.getById")
)
})
    List<Arrange>                           getListByStartTimeAfterAndMovieIds(@Param("startTime") Date startTime, @Param("movieId") int movieId);
@Select("select * from t_arrange where arrange_id=#{arrangeId}")
    Arrange getById(int arrangeId);
    @Select("select * from t_arrange where arrange_id=#{arrangeId}")
    @Results({
            @Result(id = true,column = "arrange_id",property = "arrangeId"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "arrange_movie_id",
                    one=@One(select = "com.buka.mapper.MovieMapper.getMovieById")
            ), @Result(
            property = "cinemaHome",
            javaType = Movie.class,
            column = "arrange_cinema_home_id",
            one=@One(select = "com.buka.mapper.CinemaHouseMapper.getById")
    )
    })
    Arrange getDetailById(int arrangeId);

}
