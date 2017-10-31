package com.idonans.web.user.mapper;

import com.idonans.web.user.entity.po.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("select id, username, nickname, sex, time_ms_create, time_ms_update from t_user where id = #{id}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "username", column = "username"),
      @Result(property = "nickname", column = "nickname"),
      @Result(property = "sex", column = "sex"),
      @Result(property = "timeCreate", column = "time_ms_create"),
      @Result(property = "timeUpdate", column = "time_ms_update")
  })
  UserPo findOneById(@Param("id") long id);

  @Insert("insert into t_user(username, nickname, sex, time_ms_create, time_ms_update) values (#{username}, #{nickname}, #{sex}, #{timeCreate}, #{timeUpdate})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  int insertOne(UserPo userPo);
}
