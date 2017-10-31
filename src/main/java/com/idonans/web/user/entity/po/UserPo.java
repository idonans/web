package com.idonans.web.user.entity.po;

/**
 * 持久化对象
 */
public class UserPo {

  private long id;
  private String username;
  private String nickname;
  private int sex;
  private long timeCreate;
  private long timeUpdate;

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
