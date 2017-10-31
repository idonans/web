package com.idonans.web.module.user.entity.bo;

import com.idonans.web.module.user.entity.po.UserPo;
import org.springframework.beans.BeanUtils;

/**
 * 业务对象
 */
public class UserBo {

  private long id;
  private String username;
  private String nickname;
  private int sex;
  private long timeCreate;
  private long timeUpdate;

  public static UserBo valueOf(UserPo userPo) {
    if (userPo == null) {
      return null;
    }

    UserBo userBo = new UserBo();
    BeanUtils.copyProperties(userPo, userBo);
    return userBo;
  }

  public UserPo toUserPo() {
    UserPo userPo = new UserPo();
    BeanUtils.copyProperties(this, userPo);
    return userPo;
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
