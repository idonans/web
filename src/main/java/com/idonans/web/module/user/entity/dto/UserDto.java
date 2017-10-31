package com.idonans.web.module.user.entity.dto;

import com.idonans.web.module.user.entity.bo.UserBo;
import org.springframework.beans.BeanUtils;

/**
 * 数据传输对象
 */
public class UserDto {

  private long id;
  private String username;
  private String nickname;
  private int sex;
  private long timeCreate;
  private long timeUpdate;

  public static UserDto valueOf(UserBo userBo) {
    if (userBo == null) {
      return null;
    }

    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userBo, userDto);
    return userDto;
  }

  public UserBo toUserBo() {
    UserBo userBo = new UserBo();
    BeanUtils.copyProperties(this, userBo);
    return userBo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public long getTimeCreate() {
    return timeCreate;
  }

  public void setTimeCreate(long timeCreate) {
    this.timeCreate = timeCreate;
  }

  public long getTimeUpdate() {
    return timeUpdate;
  }

  public void setTimeUpdate(long timeUpdate) {
    this.timeUpdate = timeUpdate;
  }
}
