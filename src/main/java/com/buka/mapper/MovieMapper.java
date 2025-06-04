package com.buka.mapper;

import com.buka.pojo.Cinema;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MovieMapper {
    @Insert("insert into t_movie values(null,#{movieName},#{movieTime},1,#{movieImgUrl})")
    int add(Cinema movie);
@Select("select * from t_movie ")
    List<Cinema> list();
@Update("update t_movie set movie_state=#{state} where movie_id=#{movieId}")
    int changeMovieState(@Param("movieId") int movieId, @Param("state")int state);
@Select("select * from t_movie where movie_state=#{state}")
    List<Cinema> getListByState(int state);
    @Select("select * from t_movie where movie_id=#{movieId}")
    Cinema getMovieById(int movieId);

    List<Cinema> getMovieByIds( @Param("movieIds") Collection<Integer> movieIds);
}
